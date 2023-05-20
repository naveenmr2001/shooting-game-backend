package com.m2p.shootinggame;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import java.beans.JavaBean;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
@SpringBootTest
@ContextConfiguration(classes = HeroCharacter.class)
public class HeroTests {

    @BeforeEach
    void initBeforeEach(){
        heroCharacter.setHealth(100);
    }

    @Autowired
    private HeroCharacter heroCharacter;

    @Test
    void toCheckWhetherTheHealthOfHeroIs100(){
        int heroHealth = heroCharacter.getHealth();
        assertThat(heroHealth,is(equalTo(100)));
    }

    @Test
    void toCheckWhetherTheDamageForHeroGetDecreasedBy20(){
        heroCharacter.setHealth(100);
        heroCharacter.damage();
        assertThat(heroCharacter.getHealth(),is(equalTo(80)));
    }
    @Test
    void toCheckWhetherTheDamageForHeroGetDecreasedBy40(){
        heroCharacter.damage();
        heroCharacter.damage();
        assertThat(heroCharacter.getHealth(),is(equalTo(60)));
    }
}
