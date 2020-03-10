package com.example.zombiefinal.Model;

import static com.example.zombiefinal.Model.ArrayModel.array;

public abstract class Character {
    protected int maxHealth;
    protected int currentHealth;
    protected int actions;
    protected int maxActions;
    protected Weapon weapon;

    protected int horizontal;
    protected int vertical;

    public int getHorizontal(){
        return horizontal;
    }

    public int getVertical(){
        return vertical;
    }

    public int getCurrentHealth(){
        return currentHealth;
    }

    public void checkSpot(){
        for(int c = 0; c < array.length; c++){
            for(int i = 0; i < array[0].length; i++){
                if(array[c][i].getSpot() == this){
                    this.horizontal = c;
                    this.vertical = i;
                }
            }
        }
    }

    public Weapon getWeapon(){
        return this.weapon;
    }

    public int getWeaponDice(){
        return this.weapon.getNumDice();
    }

    public int getWeaponSides(){
        return this.weapon.getNumSides();
    }

    public abstract void setWeapon();

    public abstract void setMaxHealth();

    public void heal(int health){
        currentHealth += health;
        if(currentHealth > maxHealth){
            currentHealth = maxHealth;
        }
    }

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

    public int getHealth(){
        return currentHealth;
    }

    public void refillActions(){
        this.actions = maxActions;
    }
}
