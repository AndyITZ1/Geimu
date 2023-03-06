package com.revature.services;

import com.revature.models.Product;
import com.revature.models.VideoGame;
import com.revature.repositories.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService{
    private final ProductRepository productRepository;

    public void deleteProductById(int id) {
        productRepository.deleteById(id);
    }
    public Optional<Product> getProductById(int id) {
        return productRepository.findById(id);
    }
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }
    public Product addProduct(Product product) {
        return productRepository.save(product);
    }
}
