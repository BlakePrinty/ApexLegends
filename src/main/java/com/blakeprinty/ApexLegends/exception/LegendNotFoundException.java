package com.blakeprinty.ApexLegends.exception;

public class LegendNotFoundException extends RuntimeException {

    public LegendNotFoundException(String name) {
        super("No legend found with name: " + name);
    }
}