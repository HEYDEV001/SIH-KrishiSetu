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
public class DivisionSupervisor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private long contactNumber;

    private String email;

    private String state;

    private String division;


}
