package com.SIH.KrishiSetu.KrishiSetu.repository;

import com.SIH.KrishiSetu.KrishiSetu.dto.ProductDTO;
import com.SIH.KrishiSetu.KrishiSetu.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> getProductByCategory(String category);
}
