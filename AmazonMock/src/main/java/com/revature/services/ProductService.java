package com.revature.services;

import com.revature.models.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {

    void deleteProductById(int id);
    Optional<Product> getProductById(int id);
    List<Product> getAllProducts();
}
