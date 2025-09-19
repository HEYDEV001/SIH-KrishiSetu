package com.SIH.KrishiSetu.KrishiSetu.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DivisionSupervisorDTO {
    private Long id;
    private String name;

    private long contactNumber;

    private String email;

    private String state;

    private String division;
}
