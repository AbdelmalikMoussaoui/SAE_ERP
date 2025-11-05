package com.unilim.erp.repositories;

import com.unilim.erp.entities.Competency;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CompetencyRepository extends JpaRepository<Competency, UUID> {
}
