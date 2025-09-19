package com.SIH.KrishiSetu.KrishiSetu.service;

import com.SIH.KrishiSetu.KrishiSetu.dto.DivisionSupervisorDTO;
import com.SIH.KrishiSetu.KrishiSetu.dto.ProductDTO;
import com.SIH.KrishiSetu.KrishiSetu.entity.DivisionSupervisor;
import com.SIH.KrishiSetu.KrishiSetu.entity.Product;
import com.SIH.KrishiSetu.KrishiSetu.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;
    private final ModelMapper modelMapper;

    public ResponseEntity<ProductDTO> createProduct(ProductDTO newProduct) {
        Product product = modelMapper.map(newProduct, Product.class);
        Product savedProduct = productRepository.save(product);
        return ResponseEntity.ok(modelMapper.map(savedProduct, ProductDTO.class));
    }

    public List<ProductDTO> getProductsByCategory(String category) {
        List<Product> products = productRepository.getProductByCategory(category);
        return products
                .stream()
                .map(newProduct -> modelMapper.map(newProduct, ProductDTO.class))
                .collect(Collectors.toList());

    }

    public List<ProductDTO> getAllProducts() {
        List<Product> products = productRepository.findAll();
        return products
                .stream()
                .map(newProduct -> modelMapper.map(newProduct, ProductDTO.class))
                .collect(Collectors.toList());
    }
}
