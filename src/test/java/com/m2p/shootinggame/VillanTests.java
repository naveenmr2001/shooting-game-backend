package com.m2p.shootinggame;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Component;
import org.springframework.test.context.ContextConfiguration;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.not;

@SpringBootTest
@ContextConfiguration(classes = VillanCharacter.class)
public class VillanTests {
    @Autowired
    private VillanCharacter villanCharacter;

    @BeforeEach
    void init(){
        villanCharacter.setArmour(false);
        villanCharacter.setHealth(100);
    }

    @Nested
    public class VillanTesting{

        @Test
        void toCheckIfDamageOfVillanIsReducedTo90WithArmor(){
            villanCharacter.setArmour(true);
            villanCharacter.damage();
            assertThat(villanCharacter.getHealth(),is(equalTo(90)));
        }

        @Test
        void toCheckTheVillanHealthAs100(){
            int villaHealth = villanCharacter.getHealth();
            assertThat(villaHealth,is(equalTo(100)));
        }

        @Test
        void toCheckIfArmourIsToggling(){
            villanCharacter.setArmour(true);
            assertThat(villanCharacter.getIsArmour(),is(equalTo(true)));
        }

        @Test
        void toCheckIfDamageOfVillanIsReducedTo80(){
            villanCharacter.damage();
            assertThat(villanCharacter.getHealth(),is(equalTo(80)));
        }

    }




}
