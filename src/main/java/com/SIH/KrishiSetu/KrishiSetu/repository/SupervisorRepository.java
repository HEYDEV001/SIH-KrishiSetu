package com.SIH.KrishiSetu.KrishiSetu.repository;

import com.SIH.KrishiSetu.KrishiSetu.entity.DivisionSupervisor;
import org.modelmapper.internal.bytebuddy.implementation.bytecode.Division;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SupervisorRepository extends JpaRepository<DivisionSupervisor, Long> {

    DivisionSupervisor findByDivision(String division);
}
