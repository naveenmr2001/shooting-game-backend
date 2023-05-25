package com.m2p.shootinggame;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.verify;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
@Import(ShootingGameService.class)
public class ShootingGameServiceTests {

    @InjectMocks
    private ShootingGameService shootingGameService;

    @Mock
    private VillanCharacter villanCharacter;

    @Mock
    private HeroCharacter heroCharacter;

    @Test
    void toCheckWhetherHealthIs100OfHero(){
        Mockito.when(heroCharacter.getHealth()).thenReturn(100);
        String heroOrVillan = "Hero";
        Integer heroHealth = shootingGameService.getHealth(heroOrVillan);
        assertThat(heroHealth,is(equalTo(100)));
    }

    @Test
    void toCheckWhetherHealthIs100ForVillan(){
        Mockito.when(villanCharacter.getHealth()).thenReturn(100);
        String heroOrVillan = "Villan";
        Integer villanHealth = shootingGameService.getHealth(heroOrVillan);
        assertThat(villanHealth,is(equalTo(100)));
    }

    @Test
    void toCheckTheExceptionInGetHealth(){
        String heroOrVillan = "Police";
        Throwable exception = assertThrows(IllegalArgumentException.class,()->shootingGameService
                .getHealth(heroOrVillan));
        assertTrue(exception.getMessage().contentEquals("Illegal Argument for getHealth"));
    }

    @Test
    void toCheckThePostShootingWhetherHeroShootAndVillanHealthIsDecreased(){
        Mockito.when(villanCharacter.getHealth()).thenReturn(80);
        Mockito.doNothing().when(villanCharacter).damage();
        shootingGameService.postShooting("Hero");
        Integer villanHealth = shootingGameService.getHealth("Villan");
        verify(villanCharacter).damage();
        verify(villanCharacter).getHealth();
        assertThat(villanHealth,is(equalTo(80)));
    }

    @Test
    void toCheckThePostShootingWhetherVillanShootAndHeroHealthIsDecreased(){
        Mockito.when(heroCharacter.getHealth()).thenReturn(80);
        Mockito.doNothing().when(heroCharacter).damage();
        shootingGameService.postShooting("Villan");
        Integer heroHealth = shootingGameService.getHealth("Hero");
        assertThat(heroHealth,is(equalTo(80)));
        verify(heroCharacter).damage();
        verify(heroCharacter).getHealth();
    }

    @Test
    void toCheckThePostShootingWhetherHeroShootAndVillanHealthIsDecreasedWithArmour(){
        Mockito.when(villanCharacter.getHealth()).thenReturn(90);
        Mockito.doNothing().when(villanCharacter).damage();
        Mockito.doNothing().when(villanCharacter).setArmour(true);
        shootingGameService.setArmourOfVillan(true);
        shootingGameService.postShooting("Hero");
        Integer heroHealth = shootingGameService.getHealth("Villan");
        assertThat(heroHealth,is(equalTo(90)));
        verify(villanCharacter).damage();
        verify(villanCharacter).getHealth();
        verify(villanCharacter).setArmour(true);
    }
}
