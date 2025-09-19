package com.SIH.KrishiSetu.KrishiSetu.controller;

import com.SIH.KrishiSetu.KrishiSetu.dto.DivisionSupervisorDTO;
import com.SIH.KrishiSetu.KrishiSetu.entity.DivisionSupervisor;
import com.SIH.KrishiSetu.KrishiSetu.repository.SupervisorRepository;
import com.SIH.KrishiSetu.KrishiSetu.service.SupervisorService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.internal.bytebuddy.implementation.bytecode.Division;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/super")
@RequiredArgsConstructor
public class DivisionController {

    private final SupervisorService supervisorService;
    private final ModelMapper modelMapper;

    @PostMapping
    public ResponseEntity<DivisionSupervisorDTO> addSupervisor(@RequestBody  DivisionSupervisorDTO divisionSupervisorDTO){
        DivisionSupervisorDTO savedSupervisor = supervisorService.addSupervisor(divisionSupervisorDTO).getBody();
        return new ResponseEntity<>(savedSupervisor, HttpStatus.CREATED);
    }

    @GetMapping("/{division}")
    public DivisionSupervisorDTO getSupervisorByDivision(@PathVariable String division) {
      DivisionSupervisor supervisor =  supervisorService.getSupervisorByDivision(division);
      return modelMapper.map(supervisor, DivisionSupervisorDTO.class);
    }
}
