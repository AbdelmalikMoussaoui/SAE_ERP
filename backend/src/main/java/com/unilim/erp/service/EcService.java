package com.unilim.erp.service;

import com.unilim.erp.entities.Ec;
import com.unilim.erp.repositories.EcRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class EcService {
    private final EcRepository ecRepository;

    public EcService(EcRepository ecRepository) {
        this.ecRepository = ecRepository;
    }

    public List<Ec> findAll() {
        return ecRepository.findAll();
    }

    public List<Ec> findByUeId(UUID ueId) {
        return ecRepository.findByUeId(ueId);
    }
}
