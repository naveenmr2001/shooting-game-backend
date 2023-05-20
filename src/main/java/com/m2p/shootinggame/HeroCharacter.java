package com.m2p.shootinggame;


public class HeroCharacter {
    private int health = 100;
    private final int damage = 20;
    public int getHealth() {
        return health;
    }

    public void setHealth(int health){
        this.health = health;
    }
    public void damage() {
        this.setHealth(this.health-damage);
    }

}
