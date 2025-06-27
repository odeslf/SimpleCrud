package com.example.crud.domain.product;

import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductService {

    private ProductRepository productRepository;
    private ProductMapper productMapper;

    public ProductService(ProductRepository productRepository, ProductMapper productMapper) {
        this.productRepository = productRepository;
        this.productMapper = productMapper;
    }

    public RequestProduct updateProduct(Long id, RequestProduct product) {
        Optional<Product> existingProduct = productRepository.findById(id);
        if (existingProduct.isPresent()) {
            Product updatedProduct = productMapper.map(product);
            updatedProduct.setId(id);
            Product savedProduct = productRepository.save(updatedProduct);
            return productMapper.map(savedProduct);
        }
        return null;
    }

}
