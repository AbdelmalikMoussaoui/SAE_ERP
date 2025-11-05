package com.unilim.erp.repositories;

import com.unilim.erp.entities.Tac;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface TacRepository extends JpaRepository<Tac, UUID> {
}
