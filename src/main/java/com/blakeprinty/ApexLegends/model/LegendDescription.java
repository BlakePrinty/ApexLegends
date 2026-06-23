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
public class LegendDescription {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nickname;

    @ElementCollection
    @CollectionTable(
            name = "legend_description_paragraphs",
            joinColumns = @JoinColumn(name = "legend_description_id")
    )
    @OrderColumn(name = "paragraph_order")
    @Column(name = "paragraph", columnDefinition = "TEXT")
    private List<String> paragraphs = new ArrayList<>();
}
