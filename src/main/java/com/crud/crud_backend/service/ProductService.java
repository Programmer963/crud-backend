package com.crud.crud_backend.service;

import com.crud.crud_backend.model.Product;
import com.crud.crud_backend.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getAll() {
        return productRepository.findAll();
    }

    public Product getById(Long id) {
        return productRepository.findById(id).orElseThrow(() -> new RuntimeException("Product not found"));
    }

    public Product create(Product product) {
        return productRepository.save(product);
    }

    public Product update(Long id, Product product) {
        Product temp = getById(id);
        temp.setName(product.getName());
        temp.setDescription(product.getDescription());
        temp.setPrice(product.getPrice());
        return productRepository.save(temp);
    }

    public void delete(Long id) {
        productRepository.deleteById(id);
    }
}
