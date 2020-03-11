package com.example.zombiefinal.Controller;

import com.example.zombiefinal.Model.Character;
import com.example.zombiefinal.Model.Runner;
import com.example.zombiefinal.Model.Space;
import com.example.zombiefinal.Model.Tank;
import com.example.zombiefinal.Model.Walker;
import com.example.zombiefinal.Model.Zombie;
import com.example.zombiefinal.Model.Player;

import java.util.Random;

import static com.example.zombiefinal.Model.ArrayModel.array;
import static com.example.zombiefinal.View.MainActivity.empty;
import static com.example.zombiefinal.View.MainActivity.players;

public class ZombieAI {

    private boolean checkLeft(String[][] theGameBoard, int zombiePositionHorizontal, int zombiePositionVertical){
        try {
            if (theGameBoard[zombiePositionHorizontal - 1][zombiePositionVertical] == null) {
                return false;
            } else {
                return true;
            }
        }catch (IndexOutOfBoundsException ioob){
            return false;
        }
    }

    private boolean checkRight(String[][] theGameBoard, int zombiePositionHorizontal, int zombiePositionVertical){
        try {
            if (theGameBoard[zombiePositionHorizontal + 1][zombiePositionVertical] == null) {
                return false;
            } else {
                return true;
            }
        } catch (IndexOutOfBoundsException ioob){
            return false;
        }
    }

    private boolean checkTop(String[][] theGameBoard, int zombiePositionHorizontal, int zombiePositionVertical){
        if(theGameBoard[zombiePositionHorizontal][zombiePositionVertical + 1] == null){
            return false;
        } else {return true;}
    }

    private boolean checkBottom(String[][] theGameBoard, int zombiePositionHorizontal, int zombiePositionVertical){
        if(theGameBoard[zombiePositionHorizontal][zombiePositionVertical - 1] == null){
            return false;
        } else {return true;}
    }

   /* public boolean checkForPlayer(String[][] gameBoard, int zombiePositionHorizontal, int zombiePositionVertical){
        if (checkLeft(gameBoard, zombiePositionHorizontal, zombiePositionVertical) == true
                || checkRight(gameBoard, zombiePositionHorizontal, zombiePositionVertical) == true
                || checkTop(gameBoard, zombiePositionHorizontal, zombiePositionVertical) == true
                || checkBottom(gameBoard, zombiePositionHorizontal, zombiePositionVertical) == true){
            //if there is a player ajacent
            return true;
        } else {
            //if there isn't a player ajacent
            return false;
        }
    }*/

    public Character checkForPlayer(int horizontal, int vertical){
        try{
            if(array[horizontal + 1][vertical + 1].getSpot().getClass().getSuperclass().getSimpleName().equals("Player")){
                return array[horizontal + 1][vertical + 1].getSpot();
            }
        } catch(NullPointerException npe){} catch(ArrayIndexOutOfBoundsException ioob){}

        try{
            if(array[horizontal + 1][vertical].getSpot().getClass().getSuperclass().getSimpleName().equals("Player")){
                return array[horizontal + 1][vertical].getSpot();
            }
        } catch(NullPointerException npe){} catch(ArrayIndexOutOfBoundsException ioob){}

        try{
            if(array[horizontal + 1][vertical - 1].getSpot().getClass().getSuperclass().getSimpleName().equals("Player")){
                return array[horizontal + 1][vertical - 1].getSpot();
            }
        } catch(NullPointerException npe){} catch(ArrayIndexOutOfBoundsException ioob){}

        try{
            if(array[horizontal][vertical - 1].getSpot().getClass().getSuperclass().getSimpleName().equals("Player")){
                return array[horizontal][vertical - 1].getSpot();
            }
        } catch(NullPointerException npe){} catch(ArrayIndexOutOfBoundsException ioob){}

        try{
            if(array[horizontal - 1][vertical - 1].getSpot().getClass().getSuperclass().getSimpleName().equals("Player")){
                return array[horizontal - 1][vertical - 1].getSpot();
            }
        } catch(NullPointerException npe){} catch(ArrayIndexOutOfBoundsException ioob){}

        try{
            if(array[horizontal - 1][vertical].getSpot().getClass().getSuperclass().getSimpleName().equals("Player")){
                return array[horizontal - 1][vertical].getSpot();
            }
        } catch(NullPointerException npe){} catch(ArrayIndexOutOfBoundsException ioob){}

        try{
            if(array[horizontal - 1][vertical + 1].getSpot().getClass().getSuperclass().getSimpleName().equals("Player")){
                return array[horizontal - 1][vertical + 1].getSpot();
            }
        } catch(NullPointerException npe){} catch(ArrayIndexOutOfBoundsException ioob){}

        try{
            if(array[horizontal][vertical + 1].getSpot().getClass().getSuperclass().getSimpleName().equals("Player")){
                return array[horizontal][vertical + 1].getSpot();
            }
        } catch(NullPointerException npe){} catch(ArrayIndexOutOfBoundsException ioob){}

        return empty;
    }



    public void move(Zombie zombie){
        Random rand = new Random();
        Player nearest = null;
        int spaces = 999;
        int c = rand.nextInt(1);
        for(Player player : players){
            int zombieHorizontal = zombie.getHorizontal();
            int zombieVertical = zombie.getVertical();

            int playerHorizontal = player.getHorizontal();
            int playerVertical = player.getVertical();

            int newSpaces = (Math.abs(zombieHorizontal - playerHorizontal) + Math.abs(zombieVertical - playerVertical));

            if(newSpaces < spaces){
                nearest = player;
                spaces = newSpaces;
            }
        }
        if(c == 0){
            if (zombie.getHorizontal() != 9) {
                if (nearest.getHorizontal() > zombie.getHorizontal() && array[zombie.getHorizontal() + 1][zombie.getVertical()].getSpot().getClass().getSimpleName().equalsIgnoreCase("empty")) {
                    array[zombie.getHorizontal() + 1][zombie.getVertical()].setSpot(zombie);
                    array[zombie.getHorizontal()][zombie.getVertical()].setSpot(empty);
                } else if (nearest.getHorizontal() < zombie.getHorizontal() && array[zombie.getHorizontal() - 1][zombie.getVertical()].getSpot().getClass().getSimpleName().equalsIgnoreCase("empty")) {
                    array[zombie.getHorizontal() - 1][zombie.getVertical()].setSpot(zombie);
                    array[zombie.getHorizontal()][zombie.getVertical()].setSpot(empty);
                }
            } else {
                if (nearest.getHorizontal() < zombie.getHorizontal() && array[zombie.getHorizontal() - 1][zombie.getVertical()].getSpot().getClass().getSimpleName().equalsIgnoreCase("empty")) {
                    array[zombie.getHorizontal() - 1][zombie.getVertical()].setSpot(zombie);
                    array[zombie.getHorizontal()][zombie.getVertical()].setSpot(empty);
                }
            }

        } else if (c == 1){
            if(zombie.getVertical() != 0 && zombie.getVertical() != 4) {
                if (nearest.getVertical() > zombie.getVertical() && array[zombie.getHorizontal()][zombie.getVertical() + 1].getSpot().getClass().getSimpleName().equalsIgnoreCase("empty")) {
                    array[zombie.getHorizontal()][zombie.getVertical() + 1].setSpot(zombie);
                    array[zombie.getHorizontal()][zombie.getVertical()].setSpot(empty);
                } else if (nearest.getVertical() < zombie.getVertical() && array[zombie.getHorizontal()][zombie.getVertical() - 1].getSpot().getClass().getSimpleName().equalsIgnoreCase("empty")) {
                    array[zombie.getHorizontal() - 1][zombie.getVertical()].setSpot(zombie);
                    array[zombie.getHorizontal()][zombie.getVertical()].setSpot(empty);
                }
            } else if (zombie.getVertical() == 4){
                if (nearest.getVertical() < zombie.getVertical() && array[zombie.getHorizontal()][zombie.getVertical() - 1].getSpot().getClass().getSimpleName().equalsIgnoreCase("empty")) {
                    array[zombie.getHorizontal() - 1][zombie.getVertical()].setSpot(zombie);
                    array[zombie.getHorizontal()][zombie.getVertical()].setSpot(empty);
                }

            } else if(zombie.getVertical() == 0){
                if (nearest.getVertical() > zombie.getVertical() && array[zombie.getHorizontal()][zombie.getVertical() + 1].getSpot().getClass().getSimpleName().equalsIgnoreCase("empty")) {
                    array[zombie.getHorizontal()][zombie.getVertical() + 1].setSpot(zombie);
                    array[zombie.getHorizontal()][zombie.getVertical()].setSpot(empty);
                }
            }
        }

    }

   /* public void actualZombieAI(String[][] theGameBoard, Zombie theZombieInQuestion, int zombiePositionHorizontal, int zombiePositionVertical){

        if(checkForPlayer(theGameBoard, zombiePositionHorizontal, zombiePositionVertical) == true){
            //This bit will attack the player
        }


    }*/

}
