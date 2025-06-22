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
import com.example.mobileapi.repository.SpecificationRepository;
import com.example.mobileapi.repository.CategoryRepository;
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
import java.util.ArrayList;

@Service
@Slf4j
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = lombok.AccessLevel.PRIVATE)
public class ProductServiceImpl implements ProductService {
    ProductRepository productRepository;
    CategoryServiceImpl categoryService;
    ProductMapper productMapper;
    final SpecificationRepository specificationRepository;
    final CategoryRepository categoryRepository;

    @Override
    public ProductResponseDTO saveProduct(ProductRequestDTO dto) {
        Product product = productMapper.toProduct(dto);

        // Nếu product.getCategory() == null, lấy từ categoryId trong DTO
        if (product.getCategory() == null && dto.getCategoryId() != null) {
            try {
                product.setCategory(categoryService.getCategoryEntityById(dto.getCategoryId()));
            } catch (Exception e) {
                // Nếu không tìm thấy category, tự động tạo mới category và lưu vào DB
                com.example.mobileapi.entity.Category newCategory = new com.example.mobileapi.entity.Category();
                newCategory.setName("Danh mục mặc định " + dto.getCategoryId());
                newCategory.setActive(true);
                categoryRepository.save(newCategory);
                product.setCategory(newCategory);
            }
        }

        // Set quan hệ ngược cho các entity con
        if (product.getProductSpecifications() != null) {
            java.util.List<com.example.mobileapi.entity.ProductSpecification> validSpecs = new ArrayList<>();
            for (com.example.mobileapi.entity.ProductSpecification spec : product.getProductSpecifications()) {
                spec.setProduct(product);
                Integer specId = null;
                try {
                    java.lang.reflect.Field f = spec.getClass().getDeclaredField("specificationId");
                    f.setAccessible(true);
                    specId = (Integer) f.get(spec);
                } catch (Exception ignored) {}
                if (specId != null) {
                    specificationRepository.findById(specId).ifPresent(spec::setSpecification);
                } else {
                    String specName = null;
                    try {
                        java.lang.reflect.Field f = spec.getClass().getDeclaredField("specificationName");
                        f.setAccessible(true);
                        specName = (String) f.get(spec);
                    } catch (Exception ignored) {}
                    if (specName != null && !specName.isEmpty() && product.getCategory() != null) {
                        com.example.mobileapi.entity.Specification newSpec = new com.example.mobileapi.entity.Specification();
                        newSpec.setName(specName);
                        newSpec.setCategory(product.getCategory());
                        specificationRepository.save(newSpec);
                        spec.setSpecification(newSpec);
                    }
                }
                // Chỉ add nếu đã có specification
                if (spec.getSpecification() != null) {
                    validSpecs.add(spec);
                }
            }
            product.setProductSpecifications(validSpecs);
        }
        if (product.getProductColors() != null) {
            product.getProductColors().forEach(color -> color.setProduct(product));
        }
        if (product.getProductSizes() != null) {
            product.getProductSizes().forEach(size -> size.setProduct(product));
        }
        if (product.getProductImages() != null) {
            product.getProductImages().forEach(img -> {
                img.setProduct(product);
                if (img.getAlt() == null) img.setAlt("");
            });
        }

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
        // Set quan hệ ngược cho các entity con khi update
        if (product.getProductSpecifications() != null) {
            java.util.List<com.example.mobileapi.entity.ProductSpecification> validSpecs = new ArrayList<>();
            for (com.example.mobileapi.entity.ProductSpecification spec : product.getProductSpecifications()) {
                spec.setProduct(product);
                Integer specId = null;
                try {
                    java.lang.reflect.Field f = spec.getClass().getDeclaredField("specificationId");
                    f.setAccessible(true);
                    specId = (Integer) f.get(spec);
                } catch (Exception ignored) {}
                if (specId != null) {
                    specificationRepository.findById(specId).ifPresent(spec::setSpecification);
                } else {
                    String specName = null;
                    try {
                        java.lang.reflect.Field f = spec.getClass().getDeclaredField("specificationName");
                        f.setAccessible(true);
                        specName = (String) f.get(spec);
                    } catch (Exception ignored) {}
                    if (specName != null && !specName.isEmpty() && product.getCategory() != null) {
                        com.example.mobileapi.entity.Specification newSpec = new com.example.mobileapi.entity.Specification();
                        newSpec.setName(specName);
                        newSpec.setCategory(product.getCategory());
                        specificationRepository.save(newSpec);
                        spec.setSpecification(newSpec);
                    }
                }
                // Chỉ add nếu đã có specification
                if (spec.getSpecification() != null) {
                    validSpecs.add(spec);
                }
            }
            product.setProductSpecifications(validSpecs);
        }
        if (product.getProductColors() != null) {
            product.getProductColors().forEach(color -> color.setProduct(product));
        }
        if (product.getProductSizes() != null) {
            product.getProductSizes().forEach(size -> size.setProduct(product));
        }
        if (product.getProductImages() != null) {
            product.getProductImages().forEach(img -> {
                img.setProduct(product);
                if (img.getAlt() == null) img.setAlt("");
            });
        }
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
