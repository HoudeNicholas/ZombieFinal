package com.example.zombiefinal.Model;

import com.example.zombiefinal.Controller.Roll;
import static com.example.zombiefinal.View.MainActivity.tankClaw;
import static com.example.zombiefinal.View.MainActivity.zombies;

public class Tank extends Zombie {

    @Override
    public void setWeapon() {
        this.weapon = tankClaw;
    }

    @Override
    public void setMaxHealth() {
        Roll roll = new Roll();
        this.maxHealth = roll.roll(3, 10);
    }

    public Tank(){
        setMaxHealth();
        setWeapon();
        this.maxActions = 1;
        this.actions = 1;
        zombies.add(this);
    }
}
