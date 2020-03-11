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
import static com.example.zombiefinal.View.MainActivity.empty;
import static com.example.zombiefinal.View.MainActivity.players;
import static com.example.zombiefinal.View.MainActivity.score;
import static com.example.zombiefinal.View.MainActivity.turn;
import static com.example.zombiefinal.View.MainActivity.zombies;

public class Controller {
    Roll roll = new Roll();

    public String playerAttack(Character player, Character zombie){
        int damage = roll.roll(player.getNumDice(), player.getNumSides());
        zombie.damage(damage);
        player.useAction();

        if(zombie.getHealth() < 0){
            zombie.checkSpot();
            array [zombie.getHorizontal()][zombie.getVertical()].setSpot(empty);
            if(zombie.getClass().getSimpleName().equalsIgnoreCase("walker")){
                score++;
            } else if (zombie.getClass().getSimpleName().equalsIgnoreCase("runner")){
                score += 2;
            } else if (zombie.getClass().getSimpleName().equalsIgnoreCase("tank")){
                score += 3;
            }
            zombies.remove(zombie);
            return player.getClass().getSimpleName() + " attacks " + zombie.getClass().getSimpleName() + " for " + damage + " damage. " + zombie.getClass().getSimpleName() + " dies.\n";
        }

        return player.getClass().getSimpleName() + " attacks " + zombie.getClass().getSimpleName() + " for " + damage + " damage.\n";

    }

    public String zombieAttack(Zombie zombie, Character player){
        int damage = roll.roll(zombie.getNumDice(), zombie.getNumSides());
        damage += (int)Math.floor(turn / 10);
        player.damage(damage);

        if(player.getHealth() < 0){
            player.checkSpot();
            array [player.getHorizontal()][player.getVertical()].setSpot(empty);
            players.remove(player);
            return zombie.getClass().getSimpleName() + " attacks " + player.getClass().getSimpleName() + " for " + damage + " damage. " + player.getClass().getSimpleName() + " dies.\n";
        }

        return zombie.getClass().getSimpleName() + " attacks " + player.getClass().getSimpleName() + " for " + damage + " damage.\n";
    }

    public String heal(Character player1, Character player2){
        int damage = roll.roll(player1.getNumDice(), player1.getNumSides());
        player2.heal(damage);
        player1.useAction();

        return player1.getClass().getSimpleName() + " heals " + player2.getClass().getSimpleName() + " for " + damage + " damage.\n";
    }

    public void move(Character player, Space space){
        player.checkSpot();
        array[player.getHorizontal()][player.getVertical()].setSpot(empty);
        space.setSpot(player);
        player.useAction();
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

    public boolean inRange(Character player, Character zombie){
        for(int c = 1; c < player.getRange() + 1; c++){
            try{
                if(array[player.getHorizontal() + c][player.getVertical() + c].getSpot() == zombie){
                    return true;
                }
            } catch(NullPointerException npe){} catch(ArrayIndexOutOfBoundsException ioob){}

            try{
                if(array[player.getHorizontal() + c][player.getVertical()].getSpot() == zombie){
                    return true;
                }
            } catch(NullPointerException npe){} catch(ArrayIndexOutOfBoundsException ioob){}

            try{
                if(array[player.getHorizontal() + c][player.getVertical() - c].getSpot() == zombie){
                    return true;
                }
            } catch(NullPointerException npe){} catch(ArrayIndexOutOfBoundsException ioob){}

            try{
                if(array[player.getHorizontal()][player.getVertical() - c].getSpot() == zombie){
                    return true;
                }
            } catch(NullPointerException npe){} catch(ArrayIndexOutOfBoundsException ioob){}

            try{
                if(array[player.getHorizontal() - c][player.getVertical() - c].getSpot() == zombie){
                    return true;
                }
            } catch(NullPointerException npe){} catch(ArrayIndexOutOfBoundsException ioob){}

            try{
                if(array[player.getHorizontal() - c][player.getVertical()].getSpot() == zombie){
                    return true;
                }
            } catch(NullPointerException npe){} catch(ArrayIndexOutOfBoundsException ioob){}

            try{
                if(array[player.getHorizontal() - c][player.getVertical() + c].getSpot() == zombie){
                    return true;
                }
            } catch(NullPointerException npe){} catch(ArrayIndexOutOfBoundsException ioob){}

            try{
                if(array[player.getHorizontal()][player.getVertical() + c].getSpot() == zombie){
                    return true;
                }
            } catch(NullPointerException npe){} catch(ArrayIndexOutOfBoundsException ioob){}


        }
        return false;
    }

}
