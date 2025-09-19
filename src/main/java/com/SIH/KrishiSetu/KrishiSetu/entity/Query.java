package com.SIH.KrishiSetu.KrishiSetu.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@Getter
@Setter
@Entity
@RequiredArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class Query {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String division;

    private Long contactNumber;

    private String query;
}
