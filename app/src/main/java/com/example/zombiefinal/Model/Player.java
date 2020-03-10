package com.example.zombiefinal.Model;

public abstract class Player extends Character {
    protected Weapon weapon;

    public void heal(int health){
        currentHealth += health;
    }
}
