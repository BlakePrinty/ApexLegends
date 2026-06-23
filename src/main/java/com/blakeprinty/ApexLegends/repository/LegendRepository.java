package com.blakeprinty.ApexLegends.repository;

import com.blakeprinty.ApexLegends.model.Legend;
import com.blakeprinty.ApexLegends.model.LegendClass;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface LegendRepository extends JpaRepository<Legend, Long> {

    @Query("SELECT DISTINCT l FROM Legend l " +
            "LEFT JOIN FETCH l.description " +
            "LEFT JOIN FETCH l.abilities " +
            "WHERE l.name = :name")
    Optional<Legend> findByNameWithAbilities(@Param("name") String name);

    List<Legend> findByLegendClass(LegendClass legendClass);
}