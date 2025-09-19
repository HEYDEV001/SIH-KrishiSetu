package com.SIH.KrishiSetu.KrishiSetu.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class QueryDTO {

    private Long id;

    private String name;

    private String division;

    private Long contactNumber;

    private String query;
}
