package com.example.zombiefinal.Model;

import com.example.zombiefinal.Controller.Roll;
import static com.example.zombiefinal.View.MainActivity.runnerClaw;
import static com.example.zombiefinal.View.MainActivity.zombies;

public class Runner extends Zombie {

    @Override
    public void setWeapon() {
        this.weapon = runnerClaw;
    }

    @Override
    public void setMaxHealth() {
        Roll roll = new Roll();
        this.maxHealth = roll.roll(1, 8);
    }

    public Runner(){
        setMaxHealth();
        this.currentHealth = maxHealth;
        setWeapon();
        this.maxActions = 2;
        this.actions = maxActions;
        zombies.add(this);
    }
}
