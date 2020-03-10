package com.example.zombiefinal.Controller;

import com.example.zombiefinal.Model.Character;
import com.example.zombiefinal.Model.Player;
import com.example.zombiefinal.Model.Zombie;

import static com.example.zombiefinal.Model.ArrayModel.array;

public class Controller {
    Roll roll = new Roll();

    public String playerAttack(Player player, Zombie zombie){
        int damage = roll.roll(player.getWeaponDice(), player.getWeaponSides());
        zombie.damage(damage);

        if(zombie.getHealth() < 0){
            array [zombie.getHorizontal()][zombie.getVertical()].setSpot(null);
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

    public String heal(Player player1, Player player2){
        int damage = roll.roll(player1.getWeaponDice(), player1.getWeaponSides());
        player1.heal(damage);

        return player1.getClass().getSimpleName() + " heals " + player2.getClass().getSimpleName() + " for " + damage + " damage.";
    }
}
