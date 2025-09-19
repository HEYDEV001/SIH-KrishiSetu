package com.SIH.KrishiSetu.KrishiSetu.dto;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductDTO {
    private Long id;

    private String title;

    private String description;

    private Double price;

    private String category;

    private String city;

    private String state;

    private Long mobileNumber;

    private Long whatsappNumber;

    @Column(nullable = false)
    private int expiry;
}
