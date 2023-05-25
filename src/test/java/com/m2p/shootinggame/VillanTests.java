package com.m2p.shootinggame;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import java.beans.JavaBean;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

@SpringBootTest
@ContextConfiguration(classes = VillanCharacter.class)
@ExtendWith(MockitoExtension.class)
public class VillanTests {
    @InjectMocks
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
