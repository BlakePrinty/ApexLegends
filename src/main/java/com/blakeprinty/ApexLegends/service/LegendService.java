package com.blakeprinty.ApexLegends.service;

import com.blakeprinty.ApexLegends.exception.LegendNotFoundException;
import com.blakeprinty.ApexLegends.model.Legend;
import com.blakeprinty.ApexLegends.model.LegendClass;
import com.blakeprinty.ApexLegends.repository.LegendRepository;
import org.hibernate.Hibernate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class LegendService {

    private final LegendRepository legendRepository;

    public LegendService(LegendRepository legendRepository) {
        this.legendRepository = legendRepository;
    }

    @Transactional(readOnly = true)
    public List<Legend> findAll() {
        return legendRepository.findAll();
    }

    @Transactional(readOnly = true)
    public List<Legend> findByClass(LegendClass legendClass) {
        return legendRepository.findByLegendClass(legendClass);
    }

    @Transactional(readOnly = true)
    public Legend findByName(String name) {
        Legend legend = legendRepository.findByNameWithAbilities(name)
                .orElseThrow(() -> new LegendNotFoundException(name));
        Hibernate.initialize(legend.getEvoUpgrades());
        if (legend.getDescription() != null) {
            Hibernate.initialize(legend.getDescription().getParagraphs());
        }
        return legend;
    }
}