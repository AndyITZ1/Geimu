package com.revature.controllers;

import com.revature.dtos.VideoGameDTO;
import com.revature.exceptions.ProductNotFoundException;
import com.revature.models.Product;
import com.revature.models.VideoGame;
import com.revature.services.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = {"http://localhost:3000"}, allowCredentials = "true")
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

    @PostMapping("/videogames")
    public ResponseEntity<Product> addVideoGame(@RequestBody VideoGameDTO videoGameDTO) {
        Product videoGame = new VideoGame(0,
                videoGameDTO.getName(),
                videoGameDTO.getPrice(),
                videoGameDTO.getDescription(),
                videoGameDTO.getConsole(),
                videoGameDTO.getEdition()
        );
        System.out.println(videoGame);
        return ResponseEntity.ok(productService.addProduct(videoGame));
    }

//    @PostMapping("/plushy")
//    public ResponseEntity<Product> addPlushy(@PathVariable)

    @GetMapping("/product/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable int id) {
        Optional<Product> productOptional = productService.getProductById(id);
        productOptional.orElseThrow(ProductNotFoundException::new);
        return ResponseEntity.ok(productOptional.get());
    }

    @DeleteMapping("/product/{id}")
    public ResponseEntity<Void> deleteProductById(@PathVariable int id) {
        productService.deleteProductById(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<List<Product>> getAllProducts() {
        return ResponseEntity.ok(productService.getAllProducts());
    }
}
