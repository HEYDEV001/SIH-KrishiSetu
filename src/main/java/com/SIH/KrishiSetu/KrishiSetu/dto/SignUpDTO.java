package com.SIH.KrishiSetu.KrishiSetu.dto;

import lombok.Data;

@Data
public class SignUpDTO {

    private Long id;
    private String name;
    private long mobileNumber;
    private String email;
    private int age ;
    private String address;
    private Long farmSize;
    private String password;

}
