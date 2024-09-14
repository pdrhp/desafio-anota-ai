package com.pedroh.desafio_anota_ai.controllers;

import com.pedroh.desafio_anota_ai.domain.category.Category;
import com.pedroh.desafio_anota_ai.domain.category.CategoryDTO;
import com.pedroh.desafio_anota_ai.domain.product.Product;
import com.pedroh.desafio_anota_ai.domain.product.ProductDTO;
import com.pedroh.desafio_anota_ai.services.ProductService;
import jakarta.websocket.server.PathParam;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/product")
public class ProductController {

    private ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping
    public ResponseEntity<Product> create(@RequestBody ProductDTO productDTO) {
        Product newProduct = this.productService.create(productDTO);

        return ResponseEntity.ok().body(newProduct);
    }

    @GetMapping
    public ResponseEntity<List<Product>> getAll() {
        List<Product> products = this.productService.getAll();

        return ResponseEntity.ok().body(products);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Product> update(@PathParam("id") String id, @RequestBody ProductDTO productDTO) {
        Product updatedProduct = this.productService.update(id ,productDTO);

        return ResponseEntity.ok().body(updatedProduct);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathParam("id") String id) {
        this.productService.delete(id);

        return ResponseEntity.noContent().build();
    }
}
