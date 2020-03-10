package com.example.zombiefinal.View;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.zombiefinal.Controller.Controller;
import com.example.zombiefinal.Controller.Roll;
import com.example.zombiefinal.Controller.ZombieAI;
import com.example.zombiefinal.Model.Player;
import com.example.zombiefinal.Model.Space;
import com.example.zombiefinal.Model.Warrior;
import com.example.zombiefinal.Model.Weapon;
import com.example.zombiefinal.Model.Zombie;
import com.example.zombiefinal.R;

import java.util.ArrayList;

import static com.example.zombiefinal.Model.ArrayModel.array;

public class MainActivity extends AppCompatActivity {

    private TextView log;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        log = findViewById(R.id.log);
    }
    public static ArrayList<Zombie> zombies = new ArrayList();
    public static ArrayList<Player> players = new ArrayList();

    ZombieAI ai = new ZombieAI();
    Controller controller = new Controller();

    public static int turn = 1;

    public static int score = 0;
    public static int highScore = 0;

    public static Weapon sword = new Weapon(2, 6, 1);
    public static Weapon pistol = new Weapon(1, 10, 3);
    public static Weapon axe = new Weapon(2, 10, 1);
    public static Weapon rifle = new Weapon(2, 8, 4);
    public static Weapon staff = new Weapon(2, 12, 4);
    public static Weapon walkerClaw = new Weapon(1, 8, 1);
    public static Weapon runnerClaw = new Weapon(1, 12, 1);
    public static Weapon tankClaw = new Weapon(2, 10, 1);

    public static Warrior warrior = new Warrior();

    private Space selected = null;

    public void onSave(View v){
        //TODO create a text file that stores characters' health and weapons

    }

    public void onLoad(View v){

    }

    public void onNext(View v){
        for(Zombie zombie : zombies){
            while(zombie.getActions() > 0) {
                zombie.checkSpot();
                if (ai.checkForPlayer(zombie.getHorizontal(), zombie.getVertical()) != null) {
                    controller.zombieAttack(zombie, ai.checkForPlayer(zombie.getHorizontal(), zombie.getVertical()));
                } else {
                    ai.move(zombie);
                }
                zombie.useAction();
            }
        }
        turn++;
        for(double c = 0; c < Math.floor(turn / 5) + 1; c++){
            if (array[9][2].getSpot() == null) {
                array[9][2].setSpot(controller.generateZombie());
            } else if (array[9][1].getSpot() == null){
                array[9][1].setSpot(controller.generateZombie());
            } else if (array[9][3].getSpot() == null){
                array[9][3].setSpot(controller.generateZombie());
            } else if (array[9][0].getSpot() == null){
                array[9][0].setSpot(controller.generateZombie());
            } else if (array[9][4].getSpot() == null){
                array[9][4].setSpot(controller.generateZombie());
            }
        }
        for(Player player : players){
            player.refillActions();
        }

        for(Zombie zombie : zombies){
            zombie.refillActions();
        }
    }

    public void onStart(View v){
        output();
    }

    public void onSword(View v){
        warrior.setWeapon(sword);
        Button swordButton = findViewById(R.id.swordButton);
        Button pistolButton = findViewById(R.id.pistolButton);
        swordButton.setEnabled(false);
        pistolButton.setEnabled(true);
    }

    public void onPistol(View v){
        warrior.setWeapon(pistol);
        Button pistolButton = findViewById(R.id.pistolButton);
        Button swordButton = findViewById(R.id.swordButton);
        pistolButton.setEnabled(false);
        swordButton.setEnabled(true);
    }

    public void on00(View v){
        clickStuff(0,0);
    }

    public void on01(View v){
        clickStuff(0,1);
    }

    public void on02(View v){
        clickStuff(0,2);
    }

    public void on03(View v){
        clickStuff(0,3);
    }

    public void on04(View v){
        clickStuff(0,4);
    }

    public void on05(View v){
        clickStuff(0,5);
    }

    public void on06(View v){
        clickStuff(0,6);
    }

    public void on07(View v){
        clickStuff(0,7);
    }

    public void on08(View v){
        clickStuff(0,8);
    }

    public void on09(View v){
        clickStuff(0,9);
    }

    public void on10(View v){
        clickStuff(1,0);
    }

    public void on11(View v){
        clickStuff(1,1);
    }

    public void on12(View v){
        clickStuff(1,2);
    }

    public void on13(View v){
        clickStuff(1,3);
    }

    public void on14(View v){
        clickStuff(1,4);
    }

    public void on15(View v){
        clickStuff(1,5);
    }

    public void on16(View v){
        clickStuff(1,6);
    }

    public void on17(View v){
        clickStuff(1,7);
    }

    public void on18(View v){
        clickStuff(1,8);
    }

    public void on19(View v){
        clickStuff(1,9);
    }

    public void on20(View v){
        clickStuff(2,0);
    }

    public void on21(View v){
        clickStuff(2,1);
    }

    public void on22(View v){
        clickStuff(2,2);
    }

    public void on23(View v){
        clickStuff(2,3);
    }

    public void on24(View v){
        clickStuff(2,4);
    }

    public void on25(View v){
        clickStuff(2,5);
    }

    public void on26(View v){
        clickStuff(2,6);
    }

    public void on27(View v){
        clickStuff(2,7);
    }

    public void on28(View v){
        clickStuff(2,8);
    }

    public void on29(View v){
        clickStuff(2,9);
    }

    public void on30(View v){
        clickStuff(3,0);
    }

    public void on31(View v){
        clickStuff(3,1);
    }

    public void on32(View v){
        clickStuff(3,2);
    }

    public void on33(View v){
        clickStuff(3,3);
    }

    public void on34(View v){
        clickStuff(3,4);
    }

    public void on35(View v){
        clickStuff(3,5);
    }

    public void on36(View v){
        clickStuff(3,6);
    }

    public void on37(View v){
        clickStuff(3,7);
    }

    public void on38(View v){
        clickStuff(3,8);
    }

    public void on39(View v){
        clickStuff(3,9);
    }

    public void on40(View v){
        clickStuff(4,0);
    }

    public void on41(View v){
        clickStuff(4,1);
    }

    public void on42(View v){
        clickStuff(4,2);
    }

    public void on43(View v){
        clickStuff(4,3);
    }

    public void on44(View v){
        clickStuff(4,4);
    }

    public void on45(View v){
        clickStuff(4,5);
    }

    public void on46(View v){
        clickStuff(4,6);
    }

    public void on47(View v){
        clickStuff(4,7);
    }

    public void on48(View v){
        clickStuff(4,8);
    }

    public void on49(View v){
        clickStuff(4,9);
    }

    public void output(){
        TextView output = findViewById(R.id.output);
        for(int c = 0; c < 5; c++){
            for(int i = 0; i < 10; i++){
                try {
                    if (array[i][c].getSpot() == null) {
                        output.append("X  ");
                    } else if (array[i][c].getSpot().getClass().getSimpleName().equalsIgnoreCase("ranger")) {
                        output.append("Ra ");
                    } else if (array[i][c].getSpot().getClass().getSimpleName().equalsIgnoreCase("brawler")) {
                        output.append("Br ");
                    } else if (array[i][c].getSpot().getClass().getSimpleName().equalsIgnoreCase("healer")) {
                        output.append("He ");
                    } else if (array[i][c].getSpot().getClass().getSimpleName().equalsIgnoreCase("warrior")) {
                        output.append("Wa ");
                    } else if (array[i][c].getSpot().getClass().getSimpleName().equalsIgnoreCase("walker")) {
                        output.append("ZW ");
                    } else if (array[i][c].getSpot().getClass().getSimpleName().equalsIgnoreCase("runner")) {
                        output.append("ZR ");
                    } else if (array[i][c].getSpot().getClass().getSimpleName().equalsIgnoreCase("tank")) {
                        output.append("ZT ");
                    }
                    if (i == array[c].length - 1) {
                        output.append("\n");
                    }
                } catch(NullPointerException npe){
                    output.append("X  ");
                    if(i == array.length - 1){
                        output.append("\n");
                    }
                } catch(IndexOutOfBoundsException ioob){

                }
            }
        }
    }

    public void actionUpdate(){
        TextView actions = findViewById(R.id.acts);
        actions.setText("");
        for(Player player : players){
            actions.append(player.getClass().getSimpleName() + " actions: " + player.getActions() + "\n");
            actions.append(player.getClass().getSimpleName() + " hp: " + player.getCurrentHealth() + "\n");
        }
        actions.append("Pass when finished");

        TextView scores = findViewById(R.id.scores);
        scores.setText("");
        scores.append("Current score: " + score);
        scores.append("High score: " + highScore);
    }

    public void clickStuff(int h, int v){
        //Is there a space selected?
        if(selected == null){
            if((array[h][v].getSpot().getClass().getSuperclass().getSimpleName().equalsIgnoreCase("player"))) {
                selected = array[h][v];
                selected.getSpot().checkSpot();
            }

            //If one is selected and is not the healer, and the clicked space contains a zombie and there are remaining actions, attack
        } else if (!(selected.getSpot().getClass().getSimpleName().equalsIgnoreCase("healer"))
                && array[h][v].getSpot().getClass().getSimpleName().equalsIgnoreCase("zombie")
                && selected.getSpot().getActions() > 0){

            //If it is in the weapons range, continue with attack
            if(Math.abs(selected.getSpot().getHorizontal() - array[h][v].getSpot().getHorizontal()) < selected.getSpot().getWeapon().getRange()
                    && Math.abs(selected.getSpot().getVertical() - array[h][v].getSpot().getVertical()) < selected.getSpot().getWeapon().getRange()){
                log.append(controller.playerAttack(selected.getSpot(), array[h][v].getSpot()));
                selected.getSpot().useAction();

                output();
                actionUpdate();

            } else {
                log.append("Move closer \n");
            }

            //If selected contains the healer, heal
        } else if (selected.getSpot().getClass().getSimpleName().equalsIgnoreCase("healer")
                && array[h][v].getSpot().getClass().getSuperclass().getSimpleName().equalsIgnoreCase("player")
                && selected.getSpot().getActions() > 0){

            //If the target is in range, heal
            if(Math.abs(selected.getSpot().getHorizontal() - array[h][v].getSpot().getHorizontal()) < selected.getSpot().getWeapon().getRange()
                    && Math.abs(selected.getSpot().getVertical() - array[h][v].getSpot().getVertical()) < selected.getSpot().getWeapon().getRange()){
                log.append(controller.heal(selected.getSpot(), array[h][v].getSpot()));
                selected.getSpot().useAction();

                output();
                actionUpdate();
            } else {
                log.append("Move closer \n");
            }

            //If click on selected space, deselect
        } else if (selected == array[h][v]){
            selected = null;

            //If selected space is empty and there is enough actions, move to it
        } else if (array[h][v].getSpot() == null
                && Math.abs(selected.getSpot().getHorizontal() - h) <= selected.getSpot().getActions()
                && Math.abs(selected.getSpot().getVertical() - v) <= selected.getSpot().getActions()) {

            controller.move(selected.getSpot(), array[h][v]);

            for(int c = 0; c < Math.max(Math.abs(selected.getSpot().getHorizontal() - h), Math.abs(selected.getSpot().getVertical() - v)); c++){
                selected.getSpot().useAction();
            }

            output();
            actionUpdate();
        } else {
            log.append("Not enough actions to move");
        }
    }

}
