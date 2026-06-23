package com.blakeprinty.ApexLegends.model;

import lombok.Getter;

@Getter
public enum LegendClass {
    ASSAULT("#E63946"),
    SKIRMISHER("#F4A261"),
    RECON("#2A9D8F"),
    CONTROLLER("#264653"),
    SUPPORT("#A8DADC");

    private final String colorHex;

    LegendClass(String colorHex) {
        this.colorHex = colorHex;
    }
}
