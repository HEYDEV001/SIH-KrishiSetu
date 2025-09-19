package com.SIH.KrishiSetu.KrishiSetu.service;

import com.SIH.KrishiSetu.KrishiSetu.dto.DivisionSupervisorDTO;
import com.SIH.KrishiSetu.KrishiSetu.entity.DivisionSupervisor;
import com.SIH.KrishiSetu.KrishiSetu.repository.SupervisorRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SupervisorService {

    private final SupervisorRepository supervisorRepository;
    private final ModelMapper   modelMapper;


    @Transactional
    public ResponseEntity<DivisionSupervisorDTO> addSupervisor(DivisionSupervisorDTO supervisorDTO) {

        DivisionSupervisor supervisor = modelMapper.map(supervisorDTO, DivisionSupervisor.class);
        DivisionSupervisor savedSupervisor = supervisorRepository.save(supervisor);

        return ResponseEntity.ok(modelMapper.map(savedSupervisor,DivisionSupervisorDTO.class));
    }

    public DivisionSupervisor getSupervisorByDivision(String division) {
        return supervisorRepository.findByDivision(division);
    }


}
