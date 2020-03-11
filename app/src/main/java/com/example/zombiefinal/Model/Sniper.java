package com.example.zombiefinal.Model;

import static com.example.zombiefinal.View.MainActivity.players;

public class Sniper extends Player {
    @Override
    public void setMaxHealth() {
        this.maxHealth = 15;
    }

    public Sniper(){
        setMaxHealth();
        this.numDice = 2;
        this.numSides = 12;
        this.range = 6;
        this.maxActions = 2;
        this.actions = maxActions;
        this.currentHealth = maxHealth;
        players.add(this);
    }
}
