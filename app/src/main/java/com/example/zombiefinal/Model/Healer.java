package com.example.zombiefinal.Model;

import static com.example.zombiefinal.View.MainActivity.players;
import static com.example.zombiefinal.View.MainActivity.staff;

public class Healer extends Player {

    @Override
    public void setMaxHealth() {
        this.maxHealth = 15;
    }

    public Healer(){
        this.numDice = 2;
        this.numSides = 12;
        this.range = 4;
        setMaxHealth();
        this.maxHealth = 15;
        this.maxActions = 3;
        this.currentHealth = maxHealth;
        players.add(this);
    }
}
