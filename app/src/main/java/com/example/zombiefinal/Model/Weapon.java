package com.example.zombiefinal.Model;

public class Weapon {
    private int numSides;
    private int numDice;
    private int range;

    public int getNumDice(){
        return this.numDice;
    }

    public int getNumSides(){
        return this.numSides;
    }

    public int getRange(){
        return this.range;
    }

    public Weapon(int numDice, int numSides, int range){
        this.numSides = numSides;
        this.numDice = numDice;
        this.range = range;
    }
}
