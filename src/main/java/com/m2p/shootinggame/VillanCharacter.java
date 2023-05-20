package com.m2p.shootinggame;



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
        if(this.getIsArmour()){
            super.setHealth(getHealth()-10);
        }else {
            super.setHealth(getHealth()-20);
        }
    }
}
