package com.m2p.shootinggame;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
@Import(ShootingGameService.class)
public class ShootingGameServiceTests {

    @Autowired
    private ShootingGameService shootingGameService;

    @Autowired
    private VillanCharacter villanCharacter;

    @Autowired
    private HeroCharacter heroCharacter;

    @BeforeEach
    void initBeforeEach(){
        villanCharacter.setArmour(false);
        villanCharacter.setHealth(100);
        heroCharacter.setHealth(100);
    }
    @Test
    void toCheckWhetherHealthIs100OfHero(){
        String heroOrVillan = "Hero";
        Integer heroHealth = shootingGameService.getHealth(heroOrVillan);
        assertThat(heroHealth,is(equalTo(100)));
    }

    @Test
    void toCheckWhetherHealthIs100ForVillan(){
        String heroOrVillan = "Villan";
        Integer villanHealth = shootingGameService.getHealth(heroOrVillan);
        assertThat(villanHealth,is(equalTo(100)));
    }

    @Test
    void toCheckTheExceptionInGetHealth(){
        String heroOrVillan = "Police";
        Throwable exception = assertThrows(IllegalArgumentException.class,()->shootingGameService.getHealth(heroOrVillan));
        assertTrue(exception.getMessage().contentEquals("Illegal Argument for getHealth"));
    }

    @Test
    void toCheckThePostShootingWhetherHeroShootAndVillanHealthIsDecreased(){
        String heroOrVillan = "Hero";
        shootingGameService.postShooting(heroOrVillan);
        Integer villanHealth = villanCharacter.getHealth();
        assertThat(villanHealth,is(equalTo(80)));
    }

    @Test
    void toCheckThePostShootingWhetherVillanShootAndHeroHealthIsDecreasedWithArmour(){
        String heroOrVillan = "Hero";
        villanCharacter.setArmour(true);
        shootingGameService.postShooting(heroOrVillan);
        Integer villanHealth = villanCharacter.getHealth();
        assertThat(villanHealth,is(equalTo(90)));
    }

    @Test
    void toCheckThePostShootingWhetherVillanShootAndHeroHealthIsDecreased(){
        String heroOrVillan = "Villan";
        shootingGameService.postShooting(heroOrVillan);
        Integer heroHealth = heroCharacter.getHealth();
        assertThat(heroHealth,is(equalTo(80)));
    }

}
