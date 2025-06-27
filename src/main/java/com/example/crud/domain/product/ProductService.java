package com.example.crud.domain.product;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductService {

    private ProductRepository productRepository;
    private ProductMapper productMapper;

    public ProductService(ProductRepository productRepository, ProductMapper productMapper) {
        this.productRepository = productRepository;
        this.productMapper = productMapper;
    }

    public RequestProduct createProduct(RequestProduct newProduct) {
        Product product = new ProductMapper().map(newProduct);
        productRepository.save(product);
        return productMapper.map(product);
    }

    public List<RequestProduct> listAllProducts() {
        List<Product> products = productRepository.findAll();
        return products.stream().map(productMapper::map).collect(Collectors.toList());
    }

    public RequestProduct getProductsById(Long id) {
        Optional<Product> product = productRepository.findById(id);
        return product.map(productMapper::map).orElse(null);
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

    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }
}
