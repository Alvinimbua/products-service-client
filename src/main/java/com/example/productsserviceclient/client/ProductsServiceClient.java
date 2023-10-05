package com.example.productsserviceclient.client;

import com.example.productsserviceclient.dto.Product;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.util.List;

@Service
public class ProductsServiceClient {

    private final RestClient restClient;

    public ProductsServiceClient() {
        restClient = RestClient.builder()
                .baseUrl("http://localhost:8080/api/v1/products")
                .build();
    }

    public Product saveNewProduct(Product product) {
        return restClient.post()
                .uri("/createProduct")
                .contentType(MediaType.APPLICATION_JSON)
                .body(product)
                .retrieve()
                .body(Product.class);
    }

    public List<Product> getAllProducts() {
        return restClient.get()
                .uri("/getAllProducts")
                .retrieve()
                .body(new ParameterizedTypeReference<List<Product>>(){});
    }

    public Product getProduct(int id) {
        return restClient.get()
                .uri("/find/{id}", id)
                .retrieve()
                .body(Product.class);
    }

    public Product updateProduct(int id, Product product) {
        return restClient.put()
                .uri("/update/{id}", id)
                .contentType(MediaType.APPLICATION_JSON)
                .body(product)
                .retrieve()
                .body(Product.class);
    }

    public String deleteProduct(int id) {
        restClient.delete()
                .uri("/delete/{id}", id)
                .retrieve()
                .toBodilessEntity();
        return "product removed : " + id;
    }
}
