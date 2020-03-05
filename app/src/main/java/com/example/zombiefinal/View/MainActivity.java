package com.example.zombiefinal.View;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.example.zombiefinal.Controller.ZombieAI;
import com.example.zombiefinal.Model.Warrior;
import com.example.zombiefinal.Model.Weapon;
import com.example.zombiefinal.Model.Zombie;
import com.example.zombiefinal.R;

import java.io.File;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }
    public static ArrayList<Zombie> zombies = new ArrayList();

    ZombieAI ai = new ZombieAI();
    public static Weapon sword = new Weapon(2, 6, 1);
    public static Weapon pistol = new Weapon(1, 10, 3);
    public static Weapon axe = new Weapon(2, 10, 1);
    public static Weapon rifle = new Weapon(2, 6, 4);
    public static Weapon staff = new Weapon(2, 12, 4);
    public static Weapon walkerClaw = new Weapon(1, 8, 1);
    public static Weapon runnerClaw = new Weapon(1, 12, 1);
    public static Weapon tankClaw = new Weapon(2, 10, 1);

    public static Warrior warrior = new Warrior();

    private boolean zombieTurn = false;

    public void onSave(View v){
        //TODO create a text file that stores characters' health and weapons

    }

    public void onLoad(View v){

    }

    public void onStart(View v){
        while(true){
            while(zombieTurn){
                for(Zombie zombie : zombies){
                    if(zombie.getActions() > 0) {
                        if (ai.checkForPlayer(zombie.getHorizontal(), zombie.getVertical())) {

                        }
                        zombie.useAction();
                    }
                }
                zombieTurn = false;
            }
        }
    }

}
