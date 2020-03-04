package com.example.zombiefinal.Model;

public abstract class Player extends Character {
    protected Weapon weapon;

    public Weapon getWeapon(){
        return this.weapon;
    }
    public int getWeaponDice(){
        return this.weapon.getNumDice();
    }
    public int getWeaponSides(){
        return this.weapon.getNumSides();
    }
}
