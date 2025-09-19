package com.SIH.KrishiSetu.KrishiSetu.controller;

import com.SIH.KrishiSetu.KrishiSetu.dto.DivisionSupervisorDTO;
import com.SIH.KrishiSetu.KrishiSetu.dto.QueryDTO;
import com.SIH.KrishiSetu.KrishiSetu.entity.Query;
import com.SIH.KrishiSetu.KrishiSetu.service.QueryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/query")
@RequiredArgsConstructor
public class QueryController {
    private final QueryService queryService;

    @PostMapping
    public ResponseEntity<QueryDTO> createQuery(@RequestBody QueryDTO queryDTO) {
        return queryService.createQuery(queryDTO);
    }

}
