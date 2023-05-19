package com.m2p.shootinggame;


public class VillanCharacter extends HeroCharacter {

    private Boolean isArmour = false;
    public Boolean setArmour() {
        this.isArmour = !this.isArmour;
        return this.isArmour;
    }

    public Boolean getIsArmour(){
        return this.isArmour;
    }

    @Override
    public int damage(){
        System.out.println("Service"+getIsArmour());
        if(this.getIsArmour()){
            super.setHealth(getHealth()-10);
        }else {
            super.setHealth(getHealth()-20);
        }
        return super.getHealth();
    }
}
