package com.SIH.KrishiSetu.KrishiSetu.service;

import com.SIH.KrishiSetu.KrishiSetu.dto.QueryDTO;
import com.SIH.KrishiSetu.KrishiSetu.entity.Query;
import com.SIH.KrishiSetu.KrishiSetu.repository.QueryRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.net.CacheRequest;

@Service
@RequiredArgsConstructor
public class QueryService {
    private final QueryRepository queryRepository;
    private  final ModelMapper modelMapper;

    public ResponseEntity<QueryDTO> createQuery(QueryDTO queryDTO) {
        Query newQuery = modelMapper.map(queryDTO, Query.class);
        queryRepository.save(newQuery);
        return ResponseEntity.ok(modelMapper.map(newQuery, QueryDTO.class));
    }
}
