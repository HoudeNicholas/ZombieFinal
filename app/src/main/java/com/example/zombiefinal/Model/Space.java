package com.example.zombiefinal.Model;

public class Space {
    private Character spot = new Empty();

    public Character getSpot(){
        return this.spot;
    }

    public void setSpot(Character character){
        this.spot = character;
    }

}
