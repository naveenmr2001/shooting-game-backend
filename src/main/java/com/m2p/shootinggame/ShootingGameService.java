package com.m2p.shootinggame;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Import;
import org.springframework.stereotype.Service;


@Service
@Import(HeroCharacter.class)
public class ShootingGameService extends RuntimeException{
    
    @Autowired
    private HeroCharacter heroCharacter;
    
    @Autowired 
    private VillanCharacter villanCharacter;

    public Integer getHealth(String heroOrVillan) throws IllegalArgumentException{
        if(heroOrVillan.equals("Hero")){
            return heroCharacter.getHealth();
        }else if(heroOrVillan.equals("Villan")){
            return villanCharacter.getHealth();
        }
        throw new IllegalArgumentException("Illegal Argument for getHealth");
    }

    public void postShooting(String heroOrVillan) {
        if(heroOrVillan.equals("Hero")){
            villanCharacter.damage();
        }else if(heroOrVillan.equals("Villan")){
            heroCharacter.damage();
        }
    }

    public void setArmourOfVillan(Boolean trueOrFalse) {

        villanCharacter.setArmour(trueOrFalse);
    }
}
