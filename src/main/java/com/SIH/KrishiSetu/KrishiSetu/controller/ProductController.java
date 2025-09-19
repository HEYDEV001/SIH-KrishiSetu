package com.SIH.KrishiSetu.KrishiSetu.controller;

import com.SIH.KrishiSetu.KrishiSetu.dto.DivisionSupervisorDTO;
import com.SIH.KrishiSetu.KrishiSetu.dto.ProductDTO;
import com.SIH.KrishiSetu.KrishiSetu.entity.DivisionSupervisor;
import com.SIH.KrishiSetu.KrishiSetu.entity.Product;
import com.SIH.KrishiSetu.KrishiSetu.repository.ProductRepository;
import com.SIH.KrishiSetu.KrishiSetu.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;
    private final ModelMapper modelMapper;
    private final ProductRepository productRepository;


    @PostMapping("/create")
    public ResponseEntity<ProductDTO> createProduct(@RequestBody ProductDTO newProduct) {
        ProductDTO savedProduct = productService.createProduct(newProduct).getBody();
        return new ResponseEntity<>(savedProduct, HttpStatus.CREATED);
    }

    @GetMapping("/{category}")
    public ResponseEntity<List<ProductDTO>> getProductsByCategory(@PathVariable String category) {
        List<ProductDTO> products = productService.getProductsByCategory(category);
        return ResponseEntity.ok(products);
    }

    @GetMapping("/get")
    public ResponseEntity<List<ProductDTO>> getAllProducts() {
        List<ProductDTO> products = productService.getAllProducts();
        return ResponseEntity.ok(products);
    }

}
