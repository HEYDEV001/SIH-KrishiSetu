package com.SIH.KrishiSetu.KrishiSetu.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Entity
@RequiredArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    private String description;

    @Column(nullable = false)
    private Double price;

    @Column(nullable = false)
    private String category;

    @Column(nullable = false)
    private String city;

    @Column(nullable = false)
    private String state;

    @Column(nullable = false)
    private Long mobileNumber;

    @Column(nullable = false)
    private Long whatsappNumber;

    @Column(nullable = false)
    private int expiry;

}
