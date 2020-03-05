package com.example.zombiefinal.Model;

import static com.example.zombiefinal.View.MainActivity.sword;

public class Warrior extends Player {

    @Override
    public void setMaxHealth(){
        this.maxHealth = 25;
    }

    @Override
    public void setWeapon(){}

    public void setWeapon(Weapon weapon){
        this.weapon = weapon;
    }

    public Warrior(){
        setMaxHealth();
        setWeapon(weapon);
        this.currentHealth = maxHealth;
        this.maxActions = 3;
        this.actions = 3;
        setWeapon(sword);
    }

}
