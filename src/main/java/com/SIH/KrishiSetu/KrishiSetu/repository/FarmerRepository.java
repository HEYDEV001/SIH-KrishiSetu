package com.SIH.KrishiSetu.KrishiSetu.repository;

import com.SIH.KrishiSetu.KrishiSetu.entity.Farmer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface FarmerRepository extends JpaRepository<Farmer, Long> {
     Optional<Farmer> findByMobileNumber(Long MobileNumber);

}
