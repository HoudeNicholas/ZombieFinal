package com.example.zombiefinal.Model;

import com.example.zombiefinal.Controller.Roll;

import static com.example.zombiefinal.View.MainActivity.turn;
import static com.example.zombiefinal.View.MainActivity.walkerClaw;
import static com.example.zombiefinal.View.MainActivity.zombies;

public class Walker extends Zombie {
    @Override
    public void setMaxHealth() {
        Roll roll = new Roll();
        this.maxHealth = roll.roll(2, 12);
        if(this.maxHealth < 12){
            maxHealth = 12;
        }
        this.maxHealth += (int)Math.floor(turn / 3);
    }

    public Walker(){
        this.numDice = 1;
        this.numSides = 8;
        this.range = 1;
        setMaxHealth();
        this.currentHealth = maxHealth;
        this.maxActions = 1;
        this.actions = 1;
        zombies.add(this);
    }

}
