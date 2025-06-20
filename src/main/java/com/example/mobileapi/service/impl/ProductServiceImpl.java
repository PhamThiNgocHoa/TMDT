package com.example.mobileapi.service.impl;

import com.example.mobileapi.dto.request.ProductRequestDTO;
import com.example.mobileapi.dto.response.ProductResponseDTO;
import com.example.mobileapi.entity.Product;
import com.example.mobileapi.entity.enums.BookForm;
import com.example.mobileapi.entity.enums.Language;
import com.example.mobileapi.exception.AppException;
import com.example.mobileapi.exception.ErrorCode;
import com.example.mobileapi.mapper.ProductMapper;
import com.example.mobileapi.repository.ProductRepository;
import com.example.mobileapi.service.ProductService;
import com.example.mobileapi.specification.ProductSpecifications;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@Slf4j
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = lombok.AccessLevel.PRIVATE)
public class ProductServiceImpl implements ProductService {
    ProductRepository productRepository;
    CategoryServiceImpl categoryService;

    ProductMapper productMapper;

    @Override
    public ProductResponseDTO saveProduct(ProductRequestDTO dto) {
        Product product = productMapper.toProduct(dto);

        // Tính toán giá sau khi áp dụng giảm giá
        product.calculatePrice();

        // Lưu vào cơ sở dữ liệu
        Product savedProduct = productRepository.save(product);

        // Trả về đối tượng ProductResponseDTO
        return productMapper.toProductResponseDTO(savedProduct);
    }


    @Override
    public ProductResponseDTO updateProduct(Integer id, ProductRequestDTO productRequestDTO) {
        Product product = productMapper.toProduct(productRequestDTO);
        product.setId(id);
        productRepository.save(product);
        return productMapper.toProductResponseDTO(product);
    }

    @Override
    public void deleteProduct(int id) {
        productRepository.deleteById(id);
    }

    @Override
    public List<ProductResponseDTO> getAllProducts() {
        return productMapper.toProductResponseDTOList(productRepository.findAll());
    }

    public ProductResponseDTO getProductById(Integer id) throws AppException {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new AppException(ErrorCode.PRODUCT_NOT_FOUND));
        return productMapper.toProductResponseDTO(product);
    }


    @Override
    public List<ProductResponseDTO> findByCategoryId(Integer categoryId) {
        List<Product> products = productRepository.findByCategoryId(categoryId);
        return productMapper.toProductResponseDTOList(products);

    }

    @Override
    public List<ProductResponseDTO> getProductByName(String nameProduct) {
        List<Product> products = productRepository.findByNameContainingIgnoreCase(nameProduct);
        return productMapper.toProductResponseDTOList(products);
    }

    @Override
    public List<ProductResponseDTO> findByNameContainingIgnoreCase(String name) {
        List<Product> products = productRepository.findByNameContainingIgnoreCase(name);
        return productMapper.toProductResponseDTOList(products);
    }

    @Override
    public List<ProductResponseDTO> filterProducts(String name, Integer categoryId, Integer minPrice, Integer maxPrice) {
        Specification<Product> spec = Specification.where(null);
        if (StringUtils.hasText(name)) {
            spec = spec.and(ProductSpecifications
                    .nameContains(name));
        }
        if (categoryId != null) {
            spec = spec.and(ProductSpecifications.hasCategoryId(categoryId));
        }
        if (minPrice != null && maxPrice != null) {
            spec = spec.and(ProductSpecifications.priceBetween(minPrice, maxPrice));
        }
        return productMapper.toProductResponseDTOList(productRepository.findAll(spec));

    }

    @Override
    public List<ProductResponseDTO> getListProductSale() {
        List<Product> saleProducts = productRepository.findByDiscountIsNotNullAndDiscountNot("");
        return productMapper.toProductResponseDTOList(saleProducts);
    }


    public Double getPriceById(int id) {
        Product product = getById(id);
        if (product == null) {
            throw new AppException(ErrorCode.PRODUCT_NOT_FOUND);
        }

        return (product.getPrice());
    }




    public Product getById(int id) {
        return productRepository.findById(id).orElse(null);
    }

    public boolean existById(int id) {
        return productRepository.existsById(id);
    }


}
