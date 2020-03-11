package com.example.zombiefinal.Model;

import static com.example.zombiefinal.View.MainActivity.players;
import static com.example.zombiefinal.View.MainActivity.sword;

public class Warrior extends Player {

    @Override
    public void setMaxHealth(){
        this.maxHealth = 30;
    }

    public Warrior(){
        this.numDice = 2;
        this.numSides = 6;
        this.range = 2;
        setMaxHealth();
        this.currentHealth = maxHealth;
        this.maxActions = 3;
        this.actions = 3;
        players.add(this);
    }

}
