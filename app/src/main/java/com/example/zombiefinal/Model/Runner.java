package com.example.zombiefinal.Model;

import com.example.zombiefinal.Controller.Roll;
import static com.example.zombiefinal.View.MainActivity.runnerClaw;
import static com.example.zombiefinal.View.MainActivity.turn;
import static com.example.zombiefinal.View.MainActivity.zombies;

public class Runner extends Zombie {

    @Override
    public void setMaxHealth() {
        Roll roll = new Roll();
        this.maxHealth = roll.roll(2, 8);
        if(maxHealth < 8){
            maxHealth = 8;
        }
        this.maxHealth += (int)Math.floor(turn / 3);
    }

    public Runner(){
        setMaxHealth();
        this.currentHealth = maxHealth;
        this.numDice = 1;
        this.numSides = 12;
        this.maxActions = 2;
        this.actions = maxActions;
        zombies.add(this);
    }
}
