package com.blakeprinty.ApexLegends.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Legend {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String name;

    private String realName;

    private Integer age;

    private String homeWorld;

    @Column(columnDefinition = "TEXT")
    private String introQuote;

    private String icon;

    @Enumerated(EnumType.STRING)
    private LegendClass legendClass;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    @JoinColumn(name = "legend_description_id")
    private LegendDescription description;

    @OneToMany(mappedBy = "legend", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<LegendAbility> abilities = new ArrayList<>();

    @OneToMany(mappedBy = "legend", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<EvoUpgrade> evoUpgrades = new ArrayList<>();

    public LegendAbility getPassive() {
        return abilities.stream()
                .filter(a -> a.getAbilityType() == AbilityType.PASSIVE)
                .findFirst()
                .orElse(null);
    }

    public LegendAbility getTactical() {
        return abilities.stream()
                .filter(a -> a.getAbilityType() == AbilityType.TACTICAL)
                .findFirst()
                .orElse(null);
    }

    public LegendAbility getUltimate() {
        return abilities.stream()
                .filter(a -> a.getAbilityType() == AbilityType.ULTIMATE)
                .findFirst()
                .orElse(null);
    }
}
