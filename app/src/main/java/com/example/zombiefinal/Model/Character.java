package com.example.zombiefinal.Model;

public abstract class Character {
    protected int maxHealth;
    protected int currentHealth;
    protected int actions;
    protected int maxActions;
    protected Weapon weapon;

    public abstract void setWeapon();

    public abstract void setMaxHealth();

    public int getMaxHealth(){
        return maxHealth;
    }

    public void damage(int damage){
        currentHealth -= damage;
    }

    public int getActions(){
        return actions;
    }

    public void useAction(){
        actions -= 1;
    }
}
