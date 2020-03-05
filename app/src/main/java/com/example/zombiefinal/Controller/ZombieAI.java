package com.example.zombiefinal.Controller;

import com.example.zombiefinal.Model.Runner;
import com.example.zombiefinal.Model.Tank;
import com.example.zombiefinal.Model.Walker;
import com.example.zombiefinal.Model.Zombie;
import com.example.zombiefinal.Model.Player;

import java.util.Random;

import static com.example.zombiefinal.Model.ArrayModel.array;

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

    public boolean checkForPlayer(int horizontal, int vertical){
        try{
            if(array[horizontal + 1][vertical + 1].getSpot().getClass().getSuperclass().getSimpleName().equals("Player")){
                return true;
            } else {return false;}
        } catch(IndexOutOfBoundsException ioob){}

        try{
            if(array[horizontal + 1][vertical].getSpot().getClass().getSuperclass().getSimpleName().equals("Player")){
                return true;
            } else {return false;}
        } catch(IndexOutOfBoundsException ioob){}

        try{
            if(array[horizontal + 1][vertical - 1].getSpot().getClass().getSuperclass().getSimpleName().equals("Player")){
                return true;
            } else {return false;}
        } catch(IndexOutOfBoundsException ioob){}

        try{
            if(array[horizontal][vertical - 1].getSpot().getClass().getSuperclass().getSimpleName().equals("Player")){
                return true;
            } else {return false;}
        } catch(IndexOutOfBoundsException ioob){}

        try{
            if(array[horizontal - 1][vertical - 1].getSpot().getClass().getSuperclass().getSimpleName().equals("Player")){
                return true;
            } else {return false;}
        } catch(IndexOutOfBoundsException ioob){}

        try{
            if(array[horizontal - 1][vertical].getSpot().getClass().getSuperclass().getSimpleName().equals("Player")){
                return true;
            } else {return false;}
        } catch(IndexOutOfBoundsException ioob){}

        try{
            if(array[horizontal - 1][vertical + 1].getSpot().getClass().getSuperclass().getSimpleName().equals("Player")){
                return true;
            } else {return false;}
        } catch(IndexOutOfBoundsException ioob){}

        try{
            if(array[horizontal][vertical + 1].getSpot().getClass().getSuperclass().getSimpleName().equals("Player")){
                return true;
            } else {return false;}
        } catch(IndexOutOfBoundsException ioob){}

        return false;
    }

    //Ints that show how far away in each direction a player is
    public int checkDown(String[][] checkThisColumn, int zombiePositionHorizontal, int zombiePositionVertical){

        if(checkThisColumn[zombiePositionHorizontal][zombiePositionVertical + 2] != null){
            return 2;
        }
        else if(checkThisColumn[zombiePositionHorizontal][zombiePositionVertical + 3] != null){
            return 3;
        }
        else if(checkThisColumn[zombiePositionHorizontal][zombiePositionVertical + 4] != null){
            return 4;
        }
        else if(checkThisColumn[zombiePositionHorizontal][zombiePositionVertical + 5] != null){
            return 5;
        }
        else if(checkThisColumn[zombiePositionHorizontal][zombiePositionVertical + 6] != null){
            return 6;
        }
        else if(checkThisColumn[zombiePositionHorizontal][zombiePositionVertical + 7] != null){
            return 7;
        }
        else if(checkThisColumn[zombiePositionHorizontal][zombiePositionVertical + 8] != null){
            return 8;
        } else {return 100;}
    }

    public int checkRightRow(String[][] checkRightRowOfZombie, int zombiePositionHorizontal, int zombiePositionVertical){
        if(checkRightRowOfZombie[zombiePositionHorizontal+2][zombiePositionVertical] != null){
            return 2;
        }
        else if(checkRightRowOfZombie[zombiePositionHorizontal+3][zombiePositionVertical] != null){
            return 3;
        }
        else return 200;
    }

    public int checkLeftRow(String[][] checkLeftRowOfZombie, int zombiePositionHorizontal, int zombiePositionVertical){
        //TODO
        return 0;
    }

    //When moving left or right, make sure to add the amount down the Zombie would have to move in addition to the amount left or right
    public String[][] moveZombieDown(){
        //TODO
        return null;
    }
    public String[][] moveZombieLeft(){
        //TODO
        return null;
    }
    public String[][] moveZombieRight(){
        //TODO
        return null;
    }



   /* public void actualZombieAI(String[][] theGameBoard, Zombie theZombieInQuestion, int zombiePositionHorizontal, int zombiePositionVertical){

        if(checkForPlayer(theGameBoard, zombiePositionHorizontal, zombiePositionVertical) == true){
            //This bit will attack the player
        }


    }*/






    public Zombie generateZombie(){
        Random rand = new Random();
        int itsTheInt = rand.nextInt(20)+1;

        if(itsTheInt <= 10){
            return new Walker();
        }
        else if(itsTheInt >= 17){
            return new Tank();
        } else {
            return new Runner();
        }
    }
}
