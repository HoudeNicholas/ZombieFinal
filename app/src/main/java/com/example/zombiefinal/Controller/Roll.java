package com.example.zombiefinal.Controller;

import java.util.Random;

public class Roll {

    public int roll(int numDice, int numSides){
        int total = 0;
        Random rand = new Random();

        for(int c = 0; c < numDice; c++){
            total += rand.nextInt(numSides) + 1;
        }

        return total;
    }
}
