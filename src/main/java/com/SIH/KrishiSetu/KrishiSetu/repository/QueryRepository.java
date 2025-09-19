package com.SIH.KrishiSetu.KrishiSetu.repository;

import com.SIH.KrishiSetu.KrishiSetu.entity.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QueryRepository extends JpaRepository<Query, Long> {
}
