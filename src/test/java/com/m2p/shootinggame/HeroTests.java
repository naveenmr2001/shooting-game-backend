package com.m2p.shootinggame;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.annotation.Order;
import org.springframework.test.context.ContextConfiguration;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
@SpringBootTest
@ContextConfiguration(classes = HeroCharacter.class)
public class HeroTests {

    @Autowired
    private HeroCharacter heroCharacter;

    @BeforeEach
    void init(){
        heroCharacter.setHealth(100);
    }
    @Test
    @Order(1)
    void toCheckWhetherTheHealthOfHeroIs100(){
        int heroHealth = heroCharacter.getHealth();
        assertThat(heroHealth,is(equalTo(100)));
    }

    @Test
    void toCheckWhetherTheDamageForHeroGetDecreasedBy20(){
        int decreaseHealth = heroCharacter.damage();
        assertThat(decreaseHealth,is(equalTo(80)));
    }
    @Test
    void toCheckWhetherTheDamageForHeroGetDecreasedBy40(){
        int waste = heroCharacter.damage();
        int decreaseHealth = heroCharacter.damage();
        assertThat(decreaseHealth,is(equalTo(60)));
    }
}
