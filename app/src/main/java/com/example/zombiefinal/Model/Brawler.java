package com.example.zombiefinal.Model;

import static com.example.zombiefinal.View.MainActivity.axe;
import static com.example.zombiefinal.View.MainActivity.players;

public class Brawler extends Player {

    @Override
    public void setMaxHealth() {
        this.maxHealth = 45;
    }

    public Brawler(){
        setMaxHealth();
        this.numDice = 2;
        this.numSides = 12;
        this.range = 1;
        this.maxActions = 3;
        this.actions = maxActions;
        this.currentHealth = maxHealth;
        players.add(this);
    }
}
