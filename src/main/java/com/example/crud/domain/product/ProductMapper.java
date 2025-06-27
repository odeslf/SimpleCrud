package com.example.crud.domain.product;

import org.springframework.stereotype.Component;

@Component
public class ProductMapper {

    public Product map(RequestProduct requestProduct) {
        Product product = new Product();
        product.setName(requestProduct.name());
        product.setPrice(requestProduct.price());
        return product;
    }

    public RequestProduct map(Product product) {
        return new RequestProduct(product.getName(), product.getPrice());
    }
}
