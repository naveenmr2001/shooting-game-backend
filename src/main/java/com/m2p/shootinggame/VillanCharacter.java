package com.m2p.shootinggame;


import org.springframework.context.annotation.Configuration;

import java.beans.JavaBean;


@Configuration
public class VillanCharacter extends HeroCharacter {

    private Boolean isArmour = false;
    public void setArmour(Boolean isArmour) {
        this.isArmour = isArmour;
    }

    public Boolean getIsArmour(){
        return this.isArmour;
    }

    @Override
    public void damage(){
        int damage;
        if(this.getIsArmour()){
            damage = 10;
        }else {
            damage = 20;
        }
        super.setHealth(getHealth()-damage);
    }
}
