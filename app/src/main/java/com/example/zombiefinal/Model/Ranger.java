package com.example.zombiefinal.Model;

import static com.example.zombiefinal.View.MainActivity.players;
import static com.example.zombiefinal.View.MainActivity.rifle;

public class Ranger extends Player {

    @Override
    public void setMaxHealth() {
        this.maxHealth = 20;
    }

    public Ranger(){
        this.numDice = 2;
        this.numSides = 8;
        this.range = 4;
        setMaxHealth();
        this.maxActions = 4;
        this.currentHealth = maxHealth;
        this.actions = maxActions;
        players.add(this);
    }
}
