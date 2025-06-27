package com.example.crud.controllers;

import com.example.crud.domain.product.ProductRepository;
import com.example.crud.domain.product.ProductService;
import com.example.crud.domain.product.RequestProduct;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    private ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/list")
    public List<RequestProduct> getAllProducts(){
        return productService.listAllProducts();
    }

    @GetMapping("/list/{id}")
    public RequestProduct getProductById(@PathVariable Long id){
        return productService.getProductsById(id);
    }

    @PostMapping("/save")
    public RequestProduct saveProduct(@RequestBody @Valid RequestProduct data){
        return productService.createProduct(data);
    }

    @PutMapping("/update/{id}")
    public RequestProduct updateProduct(@PathVariable Long id, @RequestBody @Valid RequestProduct data){
        return productService.updateProduct(id, data);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteProduct(@PathVariable Long id){
        productService.deleteProduct(id);
    }
}
