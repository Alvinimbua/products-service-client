package com.example.productsserviceclient.controller;

import com.example.productsserviceclient.client.ProductsServiceClient;
import com.example.productsserviceclient.dto.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product-client/api/v1/products")
@RequiredArgsConstructor
public class ProductClientController {

    private final ProductsServiceClient productsServiceClient;

    @PostMapping
    public Product saveNewProduct(@RequestBody Product product) {
        return  productsServiceClient.saveNewProduct(product);
    }

    @GetMapping
    public List<Product> getAllProducts() {
        return productsServiceClient.getAllProducts();
    }

    @GetMapping("/{id}")
    public Product getProduct(@PathVariable int id) {
        return productsServiceClient.getProduct(id);
    }

    @PutMapping("/{id}")
    public Product updateProduct(@PathVariable int id, @RequestBody Product product) {
        return productsServiceClient.updateProduct(id, product);
    }

    @DeleteMapping("/{id}")
    public String deleteProduct(@PathVariable int id) {
        return productsServiceClient.deleteProduct(id);
    }
}
