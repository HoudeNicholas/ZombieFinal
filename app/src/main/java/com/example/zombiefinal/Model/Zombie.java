package com.example.zombiefinal.Model;
import static com.example.zombiefinal.Model.ArrayModel.array;

public abstract class Zombie extends Character {
    protected int horizontal;
    protected int vertical;

    public int getHorizontal(){
        return horizontal;
    }

    public int getVertical(){
        return vertical;
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
}
