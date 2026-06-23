package com.blakeprinty.ApexLegends.controller;

import com.blakeprinty.ApexLegends.model.Legend;
import com.blakeprinty.ApexLegends.model.LegendClass;
import com.blakeprinty.ApexLegends.service.LegendService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/legends")
public class LegendController {

    private final LegendService legendService;

    public LegendController(LegendService legendService) {
        this.legendService = legendService;
    }

    @GetMapping
    public String list(@RequestParam(required = false) LegendClass legendClass, Model model) {
        List<Legend> legends = legendClass != null
                ? legendService.findByClass(legendClass)
                : legendService.findAll();

        model.addAttribute("legends", legends);
        model.addAttribute("selectedClass", legendClass);
        model.addAttribute("legendClasses", LegendClass.values());
        return "legends/list";
    }

    @GetMapping("/{name}")
    public String detail(@PathVariable String name, Model model) {
        Legend legend = legendService.findByName(name);
        model.addAttribute("legend", legend);
        return "legends/detail";
    }
}