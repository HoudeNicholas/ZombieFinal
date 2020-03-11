package com.example.zombiefinal.Model;

import com.example.zombiefinal.Controller.Roll;

import static com.example.zombiefinal.View.MainActivity.highScore;
import static com.example.zombiefinal.View.MainActivity.tankClaw;
import static com.example.zombiefinal.View.MainActivity.zombies;

public class Tank extends Zombie {
    @Override
    public void setMaxHealth() {
        Roll roll = new Roll();
        this.maxHealth = roll.roll(4, 10);
        if(this.maxHealth < 20){
            maxHealth = 20;
        }
    }

    public Tank(){
        setMaxHealth();
        this.numDice = 2;
        this.numSides = 10;
        this.range = 1;
        this.maxActions = 1;
        this.actions = 1;
        zombies.add(this);
    }
}
