package com.unilim.erp.service;

import com.unilim.erp.entities.Competency;
import com.unilim.erp.repositories.CompetencyRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompetencyService {
    private final CompetencyRepository competencyRepository;

    public CompetencyService(CompetencyRepository competencyRepository) {
        this.competencyRepository = competencyRepository;
    }

    public List<Competency> findAll() {
        return competencyRepository.findAll();
    }
}
