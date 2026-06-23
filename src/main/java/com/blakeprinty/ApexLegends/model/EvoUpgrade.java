package com.blakeprinty.ApexLegends.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class EvoUpgrade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer level;

    private Integer upgradeOption;

    private String name;

    @Column(columnDefinition = "TEXT")
    private String description;

    private String icon;

    @ManyToOne
    @JoinColumn(name = "legend_id")
    private Legend legend;

    @ManyToOne
    @JoinColumn(name = "legend_ability_id")
    private LegendAbility ability;
}
