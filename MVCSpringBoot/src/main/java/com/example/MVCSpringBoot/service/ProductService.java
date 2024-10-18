package com.example.MVCSpringBoot.service;


import com.example.MVCSpringBoot.model.ProductEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ProductService {
    private final List<ProductEntity> products = new ArrayList<>();

    public ProductService() {
        // Inicializar con algunos productos de ejemplo
        products.add(new ProductEntity("Laptop", "Electrónica", 1000.00, 50));
        products.add(new ProductEntity("Silla", "Muebles", 150.00, 30));
        products.add(new ProductEntity("Cámara", "Fotografía", 500.00, 15));
    }

    public List<ProductEntity> getAllProducts() {
        return products;
    }

    public Optional<ProductEntity> getProductById(UUID id) {
        return products.stream().filter(product -> product.getId().equals(id)).findFirst();
    }

    public ProductEntity createProduct(ProductEntity product) {
        products.add(product);
        return product;
    }

    public Optional<ProductEntity> updateProduct(UUID id, ProductEntity updatedProduct) {
        return getProductById(id).map(product -> {
            product.setName(updatedProduct.getName());
            product.setCategory(updatedProduct.getCategory());
            product.setPrice(updatedProduct.getPrice());
            product.setStock(updatedProduct.getStock());
            return product;
        });
    }

    public boolean deleteProduct(UUID id) {
        return products.removeIf(product -> product.getId().equals(id));
    }
}
