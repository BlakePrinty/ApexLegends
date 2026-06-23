package com.blakeprinty.ApexLegends.loader;

import com.blakeprinty.ApexLegends.model.AbilityType;
import com.blakeprinty.ApexLegends.model.EvoUpgrade;
import com.blakeprinty.ApexLegends.model.Legend;
import com.blakeprinty.ApexLegends.model.LegendAbility;
import com.blakeprinty.ApexLegends.model.LegendClass;
import com.blakeprinty.ApexLegends.model.LegendDescription;
import com.blakeprinty.ApexLegends.repository.LegendRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
public class LegendDataLoader implements CommandLineRunner {

    private final LegendRepository legendRepository;

    public LegendDataLoader(LegendRepository legendRepository) {
        this.legendRepository = legendRepository;
    }

    @Override
    @Transactional
    public void run(String... args) {
        if (legendRepository.count() > 0) {
            return;
        }

        legendRepository.save(buildWraith());
        legendRepository.save(buildBangalore());
    }

    private Legend buildWraith() {
        Legend wraith = new Legend();
        wraith.setName("wraith");
        wraith.setRealName("Renee Blasey");
        wraith.setAge(32);
        wraith.setHomeWorld("Earth");
        wraith.setIntroQuote("The void is calling. I should answer.");
        wraith.setIcon("wraith.png");
        wraith.setLegendClass(LegendClass.SKIRMISHER);

        LegendDescription description = new LegendDescription();
        description.setNickname("The Interdimensional Skirmisher");
        description.setParagraphs(List.of(
                "Once a test subject in a covert IMC program, Renee Blasey gained the ability to sense and manipulate the void between dimensions after a catastrophic experiment.",
                "Haunted by voices only she can hear, she now uses her powers in the Apex Games, slipping between moments of danger and pulling allies through rifts in space."
        ));
        wraith.setDescription(description);

        LegendAbility passive = new LegendAbility();
        passive.setName("Voices from the Void");
        passive.setDescription("Wraith hears a warning whenever danger is incoming, giving her a brief heads-up to reposition.");
        passive.setCooldown("Passive");
        passive.setIcon("wraith_passive.png");
        passive.setAbilityType(AbilityType.PASSIVE);
        passive.setLegend(wraith);

        LegendAbility tactical = new LegendAbility();
        tactical.setName("Into the Void");
        tactical.setDescription("Wraith steps into the void, becoming briefly untargetable and gaining a burst of movement speed to reposition.");
        tactical.setCooldown("25 seconds");
        tactical.setIcon("wraith_tactical.png");
        tactical.setAbilityType(AbilityType.TACTICAL);
        tactical.setLegend(wraith);

        LegendAbility ultimate = new LegendAbility();
        ultimate.setName("Dimensional Rift");
        ultimate.setDescription("Wraith opens linked portals at two locations, letting her squad travel between them until the rift collapses.");
        ultimate.setCooldown("Ultimate");
        ultimate.setIcon("wraith_ultimate.png");
        ultimate.setAbilityType(AbilityType.ULTIMATE);
        ultimate.setLegend(wraith);

        wraith.getAbilities().add(passive);
        wraith.getAbilities().add(tactical);
        wraith.getAbilities().add(ultimate);

        EvoUpgrade tacticalUpgrade = new EvoUpgrade();
        tacticalUpgrade.setLevel(1);
        tacticalUpgrade.setUpgradeOption(1);
        tacticalUpgrade.setName("Extended Recon");
        tacticalUpgrade.setDescription("Into the Void now briefly reveals nearby enemies through walls while active.");
        tacticalUpgrade.setIcon("wraith_evo_tactical.png");
        tacticalUpgrade.setLegend(wraith);
        tacticalUpgrade.setAbility(tactical);

        EvoUpgrade ultimateUpgrade = new EvoUpgrade();
        ultimateUpgrade.setLevel(2);
        ultimateUpgrade.setUpgradeOption(1);
        ultimateUpgrade.setName("Stabilized Rift");
        ultimateUpgrade.setDescription("Dimensional Rift's cooldown is reduced, letting Wraith reposition her squad more often.");
        ultimateUpgrade.setIcon("wraith_evo_ultimate.png");
        ultimateUpgrade.setLegend(wraith);
        ultimateUpgrade.setAbility(ultimate);

        wraith.getEvoUpgrades().add(tacticalUpgrade);
        wraith.getEvoUpgrades().add(ultimateUpgrade);

        return wraith;
    }

    private Legend buildBangalore() {
        Legend bangalore = new Legend();
        bangalore.setName("bangalore");
        bangalore.setRealName("Anita Williams");
        bangalore.setAge(32);
        bangalore.setHomeWorld("Gridiron");
        bangalore.setIntroQuote("Stay sharp out there. I've got your six.");
        bangalore.setIcon("bangalore.png");
        bangalore.setLegendClass(LegendClass.ASSAULT);

        LegendDescription description = new LegendDescription();
        description.setNickname("The Professional");
        description.setParagraphs(List.of(
                "Born into a long line of soldiers, Anita Williams enlisted with the IMC the moment she was old enough, eventually rising through the ranks during the war on Gridiron.",
                "After her unit was cut off and presumed lost, she found her way into the Apex Games, bringing military discipline and battlefield tactics to every match."
        ));
        bangalore.setDescription(description);

        LegendAbility passive = new LegendAbility();
        passive.setName("Double Time");
        passive.setDescription("Sprinting while fired upon grants Bangalore a temporary burst of movement speed.");
        passive.setCooldown("Passive");
        passive.setIcon("bangalore_passive.png");
        passive.setAbilityType(AbilityType.PASSIVE);
        passive.setLegend(bangalore);

        LegendAbility tactical = new LegendAbility();
        tactical.setName("Smoke Launcher");
        tactical.setDescription("Bangalore fires a canister that bursts into a cloud of smoke, blocking line of sight for anyone caught inside.");
        tactical.setCooldown("20 seconds");
        tactical.setIcon("bangalore_tactical.png");
        tactical.setAbilityType(AbilityType.TACTICAL);
        tactical.setLegend(bangalore);

        LegendAbility ultimate = new LegendAbility();
        ultimate.setName("Rolling Thunder");
        ultimate.setDescription("Bangalore calls in an artillery strike that telegraphs its path before rounds rain down across the area.");
        ultimate.setCooldown("Ultimate");
        ultimate.setIcon("bangalore_ultimate.png");
        ultimate.setAbilityType(AbilityType.ULTIMATE);
        ultimate.setLegend(bangalore);

        bangalore.getAbilities().add(passive);
        bangalore.getAbilities().add(tactical);
        bangalore.getAbilities().add(ultimate);

        EvoUpgrade tacticalUpgrade = new EvoUpgrade();
        tacticalUpgrade.setLevel(1);
        tacticalUpgrade.setUpgradeOption(1);
        tacticalUpgrade.setName("Thicker Smoke");
        tacticalUpgrade.setDescription("Smoke Launcher's cloud expands to cover a wider area.");
        tacticalUpgrade.setIcon("bangalore_evo_tactical.png");
        tacticalUpgrade.setLegend(bangalore);
        tacticalUpgrade.setAbility(tactical);

        EvoUpgrade ultimateUpgrade = new EvoUpgrade();
        ultimateUpgrade.setLevel(2);
        ultimateUpgrade.setUpgradeOption(1);
        ultimateUpgrade.setName("Faster Barrage");
        ultimateUpgrade.setDescription("Rolling Thunder's artillery rounds begin falling sooner after the strike is called in.");
        ultimateUpgrade.setIcon("bangalore_evo_ultimate.png");
        ultimateUpgrade.setLegend(bangalore);
        ultimateUpgrade.setAbility(ultimate);

        bangalore.getEvoUpgrades().add(tacticalUpgrade);
        bangalore.getEvoUpgrades().add(ultimateUpgrade);

        return bangalore;
    }
}