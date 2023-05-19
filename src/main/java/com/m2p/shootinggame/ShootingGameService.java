package com.m2p.shootinggame;

import org.springframework.stereotype.Service;

@Service
public class ShootingGameService {
    private int heroHealth = 100;

    private int villanHealth = 100;
    public int getHealth(String heroOrVillan) {
        if(heroOrVillan.equals("Hero")){
            return heroHealth;
        }
        return villanHealth;
    }

    public String postShooting(String heroOrVillan){
        if(heroOrVillan.equals("Hero")){
            return "{\"content\": \"Post for Hero\"}";
        }
        return "{\"content\": \"Post for Villan\"}";
    }

    public void setArmorOfVillan(){

    };
}
