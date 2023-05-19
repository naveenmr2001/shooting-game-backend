package com.m2p.shootinggame;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

@SpringBootTest
@ContextConfiguration(classes = VillanCharacter.class)
public class VillanTests {
    @Autowired
    private VillanCharacter villanCharacter;

    @BeforeEach
    void init(){
        Boolean setArmour = villanCharacter.setArmour();
        System.out.println(villanCharacter.getIsArmour());
    }

    @AfterEach
    void initAfterEach(){
        System.out.println(villanCharacter.getIsArmour());
    }

    @Nested
    public class VillanTesting{

        @Test
        @Order(1)
        void toCheckIfDamageOfVillanIsReducedTo90WithArmor(){
            System.out.println("First");
            int damageOfVillan = villanCharacter.damage();
            assertThat(damageOfVillan,is(equalTo(90)));
        }

        @Test
        @Order(4)
        void toCheckTheVillanHealthAs100(){
            System.out.println("Four");
            int villaHealth = villanCharacter.getHealth();
            assertThat(villaHealth,is(equalTo(100)));
            villanCharacter.setArmour();
        }

        @Test
        @Order(2)
        void toCheckIfArmourIsToggling(){
            System.out.println("Second");
            Boolean armorValue = villanCharacter.setArmour();
            assertThat(armorValue,is(equalTo(false)));
        }


        @Test
        @Order(3)
        void toCheckIfDamageOfVillanIsReducedTo80(){
            System.out.println("Three");
            Boolean setArmour = villanCharacter.setArmour();
            int damageOfVillan = villanCharacter.damage();
            assertThat(damageOfVillan,is(equalTo(80)));
        }

        @Test
        @Order(5)
        void toCheckIfDamageOfVillanIsReducedTo60(){
            System.out.println("Three");
            Boolean setArmour = villanCharacter.setArmour();
            int waste = villanCharacter.damage();
            int damageOfVillan = villanCharacter.damage();
            assertThat(damageOfVillan,is(equalTo(60)));
        }
        @Test
        @Order(5)
        void toCheckIfDamageOfVillanIsReducedTo70(){
            System.out.println("Three");
            Boolean setArmour = villanCharacter.setArmour();
            int waste = villanCharacter.damage();
            Boolean setArmour2 = villanCharacter.setArmour();
            int damageOfVillan = villanCharacter.damage();
            assertThat(damageOfVillan,is(equalTo(70)));
        }

    }




}
