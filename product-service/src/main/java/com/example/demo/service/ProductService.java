package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.repository.ProductRepository;
import com.example.demo.model.Product;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository repository;   

    public Product create(Product product, String email) {
        product.setCreatedBy(email);
        product.setCreatedAt(LocalDateTime.now());
        return repository.save(product);
    }

    public List<Product> getAll() {
        return repository.findAll();
    }

    public Product getById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found"));
    }

    public Product update(Long id, Product updatedProduct) {
        Product existing = getById(id);
        existing.setName(updatedProduct.getName());
        existing.setDescription(updatedProduct.getDescription());
        existing.setPrice(updatedProduct.getPrice());
        return repository.save(existing);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}