package com.blakeprinty.ApexLegends.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class LegendAbility {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Column(columnDefinition = "TEXT")
    private String description;

    private String cooldown;
    private String icon;

    @Enumerated(EnumType.STRING)
    private AbilityType abilityType;

    @ManyToOne
    @JoinColumn(name = "legend_id")
    private Legend legend;
}
