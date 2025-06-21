package com.example.mobileapi.service.impl;

import com.example.mobileapi.dto.ProductCustomizationDTO;
import com.example.mobileapi.dto.response.RevenueResponse;
import com.example.mobileapi.entity.ProductCustomization;
import com.example.mobileapi.entity.enums.OrderMethod;
import com.example.mobileapi.entity.enums.OrderStatus;
import com.example.mobileapi.dto.request.OrderEditRequestDTO;
import com.example.mobileapi.dto.request.OrderRequestDTO;
import com.example.mobileapi.dto.request.OrderDetailRequestDTO;
import com.example.mobileapi.dto.response.MonthlyRevenueResponse;
import com.example.mobileapi.dto.response.OrderResponseDTO;
import com.example.mobileapi.dto.response.OrderDetailResponseDTO;
import com.example.mobileapi.entity.enums.StockAction;
import com.example.mobileapi.event.StockUpdateEvent;
import com.example.mobileapi.exception.AppException;
import com.example.mobileapi.exception.ErrorCode;
import com.example.mobileapi.entity.Order;
import com.example.mobileapi.entity.OrderDetail;
import com.example.mobileapi.mapper.OrderMapper;
import com.example.mobileapi.mapper.ProductMapper;
import com.example.mobileapi.repository.CartItemRepository;
import com.example.mobileapi.repository.OrderRepository;
import com.example.mobileapi.repository.CustomerRepository;
import com.example.mobileapi.service.OrderService;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import static com.example.mobileapi.entity.enums.OrderStatus.DELIVERED;

@Service
@Slf4j
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = lombok.AccessLevel.PRIVATE)
public class OrderServiceImpl implements OrderService {
    OrderRepository orderRepository;
    CustomerRepository customerRepository;
    CustomerServiceImpl customerServiceImpl;
    ProductServiceImpl productService;
    CartItemRepository cartItemRepository;
    private final ProductMapper productMapper;
    private final OrderMapper orderMapper;
    ApplicationEventPublisher applicationEventPublisher;

    @Override
    @PreAuthorize("@customerServiceImpl.getCustomerIdByUsername(authentication.name) == #orderRequestDTO.customerId")
    public int saveOrder(OrderRequestDTO orderRequestDTO) throws AppException {
        Double totalAmount = calcTotalAmount(orderRequestDTO.getOrderDetails());

        Order order = Order.builder()
                .customer(customerRepository.findById(orderRequestDTO.getCustomerId())
                        .orElseThrow(() -> new AppException(ErrorCode.USER_NOT_FOUND)))
                .orderDate(LocalDateTime.now())
                .totalAmount(totalAmount) // Gán tổng tiền đã tính
                .address(orderRequestDTO.getAddress())
                .numberPhone(orderRequestDTO.getNumberPhone())
                .receiver(orderRequestDTO.getReceiver())
                .status(determineDefaultStatus(orderRequestDTO.getPaymentMethod()))
                .paymentMethod(orderRequestDTO.getPaymentMethod())
                .orderDetails(orderRequestDTO.getOrderDetails().stream()
                        .map(this::convertToOrderDetailEntity)
                        .collect(Collectors.toCollection(ArrayList::new)))
                .build();

        order.getOrderDetails().forEach(orderDetail -> orderDetail.setOrder(order));

        int orderId = orderRepository.save(order).getId();

        cartItemRepository.deleteByCustomerId(orderRequestDTO.getCustomerId());

        return orderId;
    }

    public Double calcTotalAmount(List<OrderDetailRequestDTO> orderDetails) {
        BigDecimal totalAmount = orderDetails.stream()
                .map(detail -> {
                    applicationEventPublisher.publishEvent(new StockUpdateEvent(
                            this, detail.getProductId(), detail.getQuantity(), StockAction.DECREASE));

                    BigDecimal price = BigDecimal.valueOf(productService.getPriceById(detail.getProductId()));
                    log.info("Product ID: {}, Price: {}", detail.getProductId(), price);

                    return price.multiply(BigDecimal.valueOf(detail.getQuantity()));
                })
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        log.info("Tổng tiền đơn hàng (không giảm giá): {}", totalAmount);
        return totalAmount.doubleValue(); // ✅ Chuyển về Double
    }


    public OrderStatus determineDefaultStatus(OrderMethod method) {
        switch (method) {
            case COD:
                return OrderStatus.PENDING;
            case VN_PAY,
                 MOMO,
                 ZALO_PAY:
                return OrderStatus.PENDING_PAYMENT;
            default:
                return OrderStatus.PENDING;
        }
    }


    @Override
    public OrderResponseDTO getOrder(int orderId) {
        Order order = getOrderById(orderId);
        if (order == null) {
            return null;
        }

        return convertToOrderResponseDTO(order);
    }

    @Override
    public void deleteOrder(int orderId) {
        orderRepository.deleteById(orderId);
    }

    @Override
    public BigDecimal getPriceByOrderId(int orderId) {
        return orderRepository.findTotalAmountByOrderId(orderId);
    }


    @Override
    public void updateOrder(int id, OrderRequestDTO orderRequestDTO) {
        Order order = getOrderById(id);
        if (order != null) {
            order.setTotalAmount(orderRequestDTO.getTotalAmount());
            order.setAddress(orderRequestDTO.getAddress());
            order.setNumberPhone(orderRequestDTO.getNumberPhone());
            order.setStatus(orderRequestDTO.getStatus());
            order.setOrderDetails(orderRequestDTO.getOrderDetails().stream()
                    .map(this::convertToOrderDetailEntity)
                    .collect(Collectors.toCollection(ArrayList::new)));
            order.getOrderDetails().forEach(orderDetail -> orderDetail.setOrder(order));
            orderRepository.save(order);
        }
    }

    @Override
    @PreAuthorize("@customerServiceImpl.getCustomerIdByUsername(authentication.name) == #customerId")
    public List<OrderResponseDTO> getOrderByCustomerId(int customerId) {
        return getOrdersByCustomerId(customerId);
    }

    @Override
    public List<OrderResponseDTO> getAllOrders() {
        List<Order> orders = orderRepository.findAll();
        log.warn("List of orders: {}", orders);
        if (orders.isEmpty()) {
            return Collections.emptyList(); // Return an empty list if no orders found
        }

        return orders.stream()
                .map(this::convertToOrderResponseDTO)
                .collect(Collectors.toCollection(ArrayList::new));
    }

    @Override
    public void editOrder(int id, OrderEditRequestDTO orderEditRequestDTO) throws AppException {
        Order order = orderRepository.findById(id).orElseThrow(() -> new AppException(ErrorCode.ORDER_NOT_FOUND));
        order.setAddress(orderEditRequestDTO.getAddress());
        order.setNumberPhone(orderEditRequestDTO.getPhone());
        order.setStatus(orderEditRequestDTO.getStatus());
        order.setReceiver(orderEditRequestDTO.getFullname());
        orderRepository.save(order);
    }

    @Override
    public List<MonthlyRevenueResponse> getMonthlyRevenue() {
        List<Object[]> monthlyData = orderRepository.getMonthlyRevenue();
        List<MonthlyRevenueResponse> responseList = new ArrayList<>();

        for (Object[] row : monthlyData) {
            int month = (int) row[0];
            BigDecimal value = (BigDecimal) row[1];
            long revenue = value.longValueExact();
            responseList.add(MonthlyRevenueResponse.builder().month(month).revenue(revenue).build());
        }

        return responseList;
    }

    @Override
    public List<OrderResponseDTO> getOrdersByStatus(OrderStatus status) {
        List<Order> orders = orderRepository.findByStatus(status);
        if (orders.isEmpty()) {
            return Collections.emptyList();
        }
        return orderMapper.toOrderResponseDTOList(orders);
    }


    @Override
    public void changeOrderStatus(int orderId, OrderStatus status) throws AppException {
        Order order = orderRepository.findById(orderId).orElseThrow(() -> new AppException(ErrorCode.ORDER_NOT_FOUND));
        order.setStatus(status);
        orderRepository.save(order);
    }

    @Override
    @PreAuthorize("@customerServiceImpl.getCustomerIdByUsername(authentication.name) == #customerId")
    public List<OrderResponseDTO> getOrdersByStatusAndCustomerId(OrderStatus status, int customerId) {
        List<Order> orderResponseDTO = orderRepository.findByStatusAndCustomerId(status, customerId);
        if (orderResponseDTO.isEmpty()) {
            return Collections.emptyList();
        }
        return orderResponseDTO.stream()
                .map(this::convertToOrderResponseDTO)
                .collect(Collectors.toCollection(ArrayList::new));
    }

    @Override
    public boolean existById(Integer orderId) {
        return orderRepository.existsById(orderId);
    }

    @Override
    public RevenueResponse getRevenueByMonth(int month, int year) {
        if (month < 1 || month > 12 || year < 2000 || year > LocalDate.now().getYear()) {
            throw new AppException(ErrorCode.INVALID_TIME);
        }

        LocalDate startDate = LocalDate.of(year, month, 1);
        LocalDate endDate = startDate.withDayOfMonth(startDate.lengthOfMonth());

        LocalDateTime startDateTime = startDate.atStartOfDay();
        LocalDateTime endDateTime = endDate.atTime(23, 59, 59);

        BigDecimal revenue = orderRepository.findAllByOrderDateBetween(startDateTime, endDateTime).stream()
                .filter(o -> o.getStatus() == DELIVERED)
                .map(o -> BigDecimal.valueOf(o.getTotalAmount()))
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        return RevenueResponse.builder()
                .month(month)
                .year(year)
                .revenue(revenue)
                .build();
    }


    @Override
    public RevenueResponse getRevenueByYear(int year) {
        if (year < 2000 || year > LocalDate.now().getYear()) {
            throw new AppException(ErrorCode.INVALID_TIME);
        }

        LocalDateTime startOfYear = LocalDate.of(year, 1, 1).atStartOfDay();
        LocalDateTime endOfYear = LocalDate.of(year, 12, 31).atTime(23, 59, 59);

        BigDecimal revenue = orderRepository.findAllByOrderDateBetween(startOfYear, endOfYear).stream()
                .filter(order -> order.getStatus() == OrderStatus.DELIVERED)
                .map(o -> BigDecimal.valueOf(o.getTotalAmount()))
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        return RevenueResponse.builder()
                .year(year)
                .revenue(revenue)
                .build();
    }


    @Override
    public RevenueResponse getRevenueByDate(LocalDate date) {
        LocalDateTime startOfDay = date.atStartOfDay(); // 00:00:00
        LocalDateTime endOfDay = date.atTime(23, 59, 59); // 23:59:59

        List<Order> orders = orderRepository.findAllByOrderDateBetween(startOfDay, endOfDay);

        BigDecimal revenue = orders.stream()
                .filter(o -> o.getStatus() == DELIVERED)
                .map(o -> BigDecimal.valueOf(o.getTotalAmount()))
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        return RevenueResponse.builder()
                .day(date.getDayOfMonth())
                .month(date.getMonthValue())
                .year(date.getYear())
                .revenue(revenue)
                .build();
    }


    public List<OrderResponseDTO> getOrdersByCustomerId(int customerId) {
        List<Order> orders = orderRepository.findByCustomerId(customerId);
        if (orders.isEmpty()) {
            return Collections.emptyList(); // Return an empty list if no orders found
        }

        return orders.stream()
                .map(this::convertToOrderResponseDTO)
                .collect(Collectors.toCollection(ArrayList::new));
    }

    private Order getOrderById(int orderId) {
        return orderRepository.findById(orderId).orElse(null);
    }

    private OrderResponseDTO convertToOrderResponseDTO(Order order) {
        List<OrderDetailResponseDTO> orderDetailDTOs = order.getOrderDetails().stream()
                .map(this::convertToOrderDetailResponseDTO)
                .collect(Collectors.toCollection(ArrayList::new));

        return OrderResponseDTO.builder()
                .id(order.getId())
                .customerDTO(customerServiceImpl.getCustomer(order.getCustomer().getId()))
                .orderDate(order.getOrderDate())
                .totalAmount(order.getTotalAmount())
                .address(order.getAddress())
                .numberPhone(order.getNumberPhone())
                .status(order.getStatus())
                .receiver(order.getReceiver())
                .orderDetails(orderDetailDTOs)
                .paymentMethod(order.getPaymentMethod())
                .build();
    }


    private OrderDetailResponseDTO convertToOrderDetailResponseDTO(OrderDetail orderDetail) {
        return OrderDetailResponseDTO.builder()
                .id(orderDetail.getId())
                .orderId(orderDetail.getOrder().getId())
                .productResponseDTO(productMapper.toProductResponseDTO(orderDetail.getProduct()))
                .quantity(orderDetail.getQuantity())
                .build();
    }

    private OrderDetail convertToOrderDetailEntity(OrderDetailRequestDTO dto) {
        OrderDetail.OrderDetailBuilder builder = OrderDetail.builder()
                .product(productService.getById(dto.getProductId()))
                .quantity(dto.getQuantity())
                .color(dto.getColor());

        if (dto.getCustomization() != null) {
            builder.customization(convertToCustomization(dto.getCustomization()));
        }

        return builder.build();
    }
    private ProductCustomization convertToCustomization(ProductCustomizationDTO dto) {
        return ProductCustomization.builder()
                .location(dto.getLocation())
                .height(dto.getHeight())
                .note(dto.getNote())
                .build();
    }

}
