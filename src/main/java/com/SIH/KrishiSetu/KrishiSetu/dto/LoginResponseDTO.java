package com.SIH.KrishiSetu.KrishiSetu.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginResponseDTO {
    private Long Id;
    private String name;
    private int age;
}
