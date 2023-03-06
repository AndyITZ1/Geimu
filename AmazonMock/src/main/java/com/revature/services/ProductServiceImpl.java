package com.revature.services;

import com.revature.exceptions.DeleteProductFailedException;
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

    public String deleteProductById(int id) throws DeleteProductFailedException {
        productRepository.deleteById(id);
        Optional<Product> productOptional = productRepository.findById(id);
        if (productOptional.isPresent())
            throw new DeleteProductFailedException(productOptional.get().getId(), productOptional.get().getName());
        return "Product #" + id + " was successfully deleted";
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
