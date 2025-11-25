package com.unilim.erp.repositories;

import com.unilim.erp.entities.Ec;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface EcRepository extends JpaRepository<Ec, UUID> {
    List<Ec> findByUeId(UUID ueId);
}
