package com.m2p.shootinggame;

import org.springframework.context.annotation.Configuration;

import java.beans.JavaBean;


@Configuration
public class HeroCharacter {
    private int health = 100;

    public int getHealth() {
        return health;
    }

    public void setHealth(int health){
        this.health = health;
    }
    public void damage() {
        int damage = 20;
        this.setHealth(this.health- damage);
    }

}
