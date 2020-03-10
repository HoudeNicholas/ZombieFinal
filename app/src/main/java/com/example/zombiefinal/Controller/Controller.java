package com.example.zombiefinal.Controller;

import com.example.zombiefinal.Model.Character;
import com.example.zombiefinal.Model.Player;
import com.example.zombiefinal.Model.Runner;
import com.example.zombiefinal.Model.Space;
import com.example.zombiefinal.Model.Tank;
import com.example.zombiefinal.Model.Walker;
import com.example.zombiefinal.Model.Zombie;

import java.util.Random;

import static com.example.zombiefinal.Model.ArrayModel.array;
import static com.example.zombiefinal.View.MainActivity.score;
import static com.example.zombiefinal.View.MainActivity.turn;

public class Controller {
    Roll roll = new Roll();

    public String playerAttack(Character player, Character zombie){
        int damage = roll.roll(player.getWeaponDice(), player.getWeaponSides());
        zombie.damage(damage);

        if(zombie.getHealth() < 0){
            array [zombie.getHorizontal()][zombie.getVertical()].setSpot(null);
            if(zombie.getClass().getSimpleName().equalsIgnoreCase("walker")){
                score++;
            } else if (zombie.getClass().getSimpleName().equalsIgnoreCase("runner")){
                score += 2;
            } else if (zombie.getClass().getSimpleName().equalsIgnoreCase("tank")){
                score += 3;
            }
            return player.getClass().getSimpleName() + " attacks " + zombie.getClass().getSimpleName() + " for " + damage + " damage. " + zombie.getClass().getSimpleName() + " dies.";
        }

        return player.getClass().getSimpleName() + " attacks " + zombie.getClass().getSimpleName() + " for " + damage + " damage.";

    }

    public String zombieAttack(Zombie zombie, Character player){
        int damage = roll.roll(zombie.getWeaponDice(), zombie.getWeaponSides());
        player.damage(damage);

        if(player.getHealth() < 0){
            array [player.getHorizontal()][player.getVertical()].setSpot(null);
            return zombie.getClass().getSimpleName() + " attacks " + player.getClass().getSimpleName() + " for " + damage + " damage. " + player.getClass().getSimpleName() + " dies.";
        }

        return zombie.getClass().getSimpleName() + " attacks " + player.getClass().getSimpleName() + " for " + damage + " damage.";
    }

    public String heal(Character player1, Character player2){
        int damage = roll.roll(player1.getWeaponDice(), player1.getWeaponSides());
        player2.heal(damage);

        return player1.getClass().getSimpleName() + " heals " + player2.getClass().getSimpleName() + " for " + damage + " damage.";
    }

    public void move(Character player, Space space){
        player.checkSpot();
        array[player.getHorizontal()][player.getVertical()].setSpot(null);
        space.setSpot(player);
    }

    public Zombie generateZombie(){
        Random rand = new Random();
        int itsTheInt = rand.nextInt(20)+ (int)Math.floor((turn / 5)+1);

        if(itsTheInt <= 10){
            return new Walker();
        }
        else if(itsTheInt >= 18){
            return new Tank();
        } else {
            return new Runner();
        }
    }

}
