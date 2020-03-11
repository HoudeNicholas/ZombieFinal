package com.example.zombiefinal.View;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.zombiefinal.Controller.Controller;
import com.example.zombiefinal.Controller.ZombieAI;
import com.example.zombiefinal.Model.Brawler;
import com.example.zombiefinal.Model.Empty;
import com.example.zombiefinal.Model.Healer;
import com.example.zombiefinal.Model.Player;
import com.example.zombiefinal.Model.Ranger;
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
    public static Button[][] buttons = new Button[10][5];

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
    public static Brawler brawler = new Brawler();
    public static Ranger ranger = new Ranger();
    public static Healer healer = new Healer();
    public static Empty empty = new Empty();

    private Space selected = null;

    public void onSave(View v){
        //TODO create a text file that stores characters' health and weapons

    }

    public void onLoad(View v){

    }

    public void onNext(View v){
        selected = null;
        log.setText("");
        for(Player player : players){
            player.checkSpot();
        }
        for(Zombie zombie : zombies){
            while (zombie.getActions() > 0) {
                zombie.checkSpot();
                if (ai.checkForPlayer(zombie.getHorizontal(), zombie.getVertical()).getClass().getSuperclass().getSimpleName().equalsIgnoreCase("player")) {
                    log.append(controller.zombieAttack(zombie, ai.checkForPlayer(zombie.getHorizontal(), zombie.getVertical())));
                } else {
                    ai.move(zombie);
                }
                zombie.useAction();
            }
        }
        turn++;
        for(double c = 0; c < Math.floor(turn / 5) + 1; c++){
            if (array[9][2].getSpot().getClass().getSimpleName().equalsIgnoreCase("empty")) {
                array[9][2].setSpot(controller.generateZombie());
            } else if (array[9][1].getSpot().getClass().getSimpleName().equalsIgnoreCase("empty")){
                array[9][1].setSpot(controller.generateZombie());
            } else if (array[9][3].getSpot().getClass().getSimpleName().equalsIgnoreCase("empty")){
                array[9][3].setSpot(controller.generateZombie());
            } else if (array[9][0].getSpot().getClass().getSimpleName().equalsIgnoreCase("empty")){
                array[9][0].setSpot(controller.generateZombie());
            } else if (array[9][4].getSpot().getClass().getSimpleName().equalsIgnoreCase("empty")){
                array[9][4].setSpot(controller.generateZombie());
            }
        }
        for(Player player : players){
            player.refillActions();
        }

        for(Zombie zombie : zombies){
            zombie.refillActions();
        }
        output();
        actionUpdate();
    }

    public void onStart(View v){
        for(int c = 0; c < 10; c++){
            for(int i = 0; i < 5; i++){
                array[c][i] = new Space();
            }
        }
        zombies.removeAll(zombies);

        turn = 0;
        score = 0;

        array[1][2].setSpot(healer);
        array[2][3].setSpot(ranger);
        array[2][1].setSpot(brawler);
        array[2][2].setSpot(warrior);

        if (array[9][2].getSpot().getClass().getSimpleName().equalsIgnoreCase("empty")) {
            array[9][2].setSpot(controller.generateZombie());
        } else if (array[9][1].getSpot().getClass().getSimpleName().equalsIgnoreCase("empty")){
            array[9][1].setSpot(controller.generateZombie());
        } else if (array[9][3].getSpot().getClass().getSimpleName().equalsIgnoreCase("empty")){
            array[9][3].setSpot(controller.generateZombie());
        } else if (array[9][0].getSpot().getClass().getSimpleName().equalsIgnoreCase("empty")){
            array[9][0].setSpot(controller.generateZombie());
        } else if (array[9][4].getSpot().getClass().getSimpleName().equalsIgnoreCase("empty")){
            array[9][4].setSpot(controller.generateZombie());
        }

        instantiate();
        actionUpdate();

        output();
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

    public void on50(View v){
        clickStuff(5,0);
    }

    public void on51(View v){
        clickStuff(5,1);
    }

    public void on52(View v){
        clickStuff(5,2);
    }

    public void on53(View v){
        clickStuff(5,3);
    }

    public void on54(View v){
        clickStuff(5,4);
    }

    public void on60(View v){
        clickStuff(6,0);
    }

    public void on61(View v){
        clickStuff(6,1);
    }

    public void on62(View v){
        clickStuff(6,2);
    }

    public void on63(View v){
        clickStuff(6,3);
    }

    public void on64(View v){
        clickStuff(6,4);
    }

    public void on70(View v){
        clickStuff(7,0);
    }

    public void on71(View v){
        clickStuff(7,1);
    }

    public void on72(View v){
        clickStuff(7,2);
    }

    public void on73(View v){
        clickStuff(7,3);
    }

    public void on74(View v){
        clickStuff(7,4);
    }

    public void on80(View v){
        clickStuff(8,0);
    }

    public void on81(View v){
        clickStuff(8,1);
    }

    public void on82(View v){
        clickStuff(8,2);
    }

    public void on83(View v){
        clickStuff(8,3);
    }

    public void on84(View v){
        clickStuff(8,4);
    }

    public void on90(View v){
        clickStuff(9,0);
    }

    public void on91(View v){
        clickStuff(9,1);
    }

    public void on92(View v){
        clickStuff(9,2);
    }

    public void on93(View v){
        clickStuff(9,3);
    }

    public void on94(View v){
        clickStuff(9,4);
    }

    public void output(){
        for(int c = 0; c < 10; c++){
            for(int i = 0; i < 5; i++){
                try {
                    if (array[c][i].getSpot().getClass().getSimpleName().equalsIgnoreCase("empty")) {
                        buttons[c][i].setText("X");
                    } else if (array[c][i].getSpot().getClass().getSimpleName().equalsIgnoreCase("ranger")) {
                        buttons[c][i].setText("RA");
                    } else if (array[c][i].getSpot().getClass().getSimpleName().equalsIgnoreCase("brawler")) {
                        buttons[c][i].setText("BR");
                    } else if (array[c][i].getSpot().getClass().getSimpleName().equalsIgnoreCase("healer")) {
                        buttons[c][i].setText("HE");
                    } else if (array[c][i].getSpot().getClass().getSimpleName().equalsIgnoreCase("warrior")) {
                        buttons[c][i].setText("WA");
                    } else if (array[c][i].getSpot().getClass().getSimpleName().equalsIgnoreCase("walker")) {
                        buttons[c][i].setText("ZW");
                    } else if (array[c][i].getSpot().getClass().getSimpleName().equalsIgnoreCase("runner")) {
                        buttons[c][i].setText("ZR");
                    } else if (array[c][i].getSpot().getClass().getSimpleName().equalsIgnoreCase("tank")) {
                        buttons[c][i].setText("ZT");
                    }
                } catch(NullPointerException npe){
                    buttons[c][i].setText("X");
                } catch(ArrayIndexOutOfBoundsException io){
                    break;
                }
            }
        }
    }

    public void actionUpdate(){
        TextView actions = findViewById(R.id.acts);
        actions.setText("");
        for(Player player : players){
            actions.append(player.getClass().getSimpleName() + " hp: " + player.getCurrentHealth() + "\n");
            actions.append(player.getClass().getSimpleName() + " actions: " + player.getActions() + "\n");
        }
        actions.append("Pass when finished");

        TextView scores = findViewById(R.id.scores);
        scores.setText("");
        scores.append("Current score: " + score + "\n");
        scores.append("Turn: " + turn);
    }

    public void clickStuff(int h, int v){
        for(Player player : players){
            player.checkSpot();
        }
        //Is there a space selected?
        if(selected == null){
            if((array[h][v].getSpot().getClass().getSuperclass().getSimpleName().equalsIgnoreCase("player"))) {
                selected = array[h][v];
                selected.getSpot().checkSpot();
            }

            //If one is selected and is not the healer, and the clicked space contains a zombie and there are remaining actions, attack
        } else if (!(selected.getSpot().getClass().getSimpleName().equalsIgnoreCase("healer"))
                && array[h][v].getSpot().getClass().getSuperclass().getSimpleName().equalsIgnoreCase("zombie")
                && selected.getSpot().getActions() > 0){

            //If it is in the weapons range, continue with attack
            if(controller.inRange(selected.getSpot(), array[h][v].getSpot())){
                log.append(controller.playerAttack(selected.getSpot(), array[h][v].getSpot()));

                output();
                actionUpdate();
                selected = null;

            } else {
                log.append("Move closer \n");
            }

            //If selected contains the healer, heal
        } else if (selected.getSpot().getClass().getSimpleName().equalsIgnoreCase("healer")
                && array[h][v].getSpot().getClass().getSuperclass().getSimpleName().equalsIgnoreCase("player")
                && selected.getSpot().getActions() > 0){

            //If the target is in range, heal
            if(controller.inRange(selected.getSpot(), array[h][v].getSpot())){
                log.append(controller.heal(selected.getSpot(), array[h][v].getSpot()));

                output();
                actionUpdate();

                selected = null;
            } else {
                log.append("Move closer \n");
            }

            //If click on selected space, deselect
        } else if (selected == array[h][v]){
            selected = null;

            //If selected space is empty and there is enough actions, move to it
        } else if (array[h][v].getSpot().getClass().getSimpleName().equalsIgnoreCase("empty")
                && selected.getSpot().getActions() > 0){

            controller.move(selected.getSpot(), array[h][v]);
            selected.getSpot().useAction();
            selected = null;

            output();
            actionUpdate();
        } else {
            log.append("Not enough actions to move");
        }
    }

    public void instantiate(){
        buttons[0][0] = findViewById(R.id.b00);
        buttons[0][1] = findViewById(R.id.b01);
        buttons[0][2] = findViewById(R.id.b02);
        buttons[0][3] = findViewById(R.id.b03);
        buttons[0][4] = findViewById(R.id.b04);
        buttons[1][0] = findViewById(R.id.b10);
        buttons[1][1] = findViewById(R.id.b11);
        buttons[1][2] = findViewById(R.id.b12);
        buttons[1][3] = findViewById(R.id.b13);
        buttons[1][4] = findViewById(R.id.b14);
        buttons[2][0] = findViewById(R.id.b20);
        buttons[2][1] = findViewById(R.id.b21);
        buttons[2][2] = findViewById(R.id.b22);
        buttons[2][3] = findViewById(R.id.b23);
        buttons[2][4] = findViewById(R.id.b24);
        buttons[3][0] = findViewById(R.id.b30);
        buttons[3][1] = findViewById(R.id.b31);
        buttons[3][2] = findViewById(R.id.b32);
        buttons[3][3] = findViewById(R.id.b33);
        buttons[3][4] = findViewById(R.id.b34);
        buttons[4][0] = findViewById(R.id.b40);
        buttons[4][1] = findViewById(R.id.b41);
        buttons[4][2] = findViewById(R.id.b42);
        buttons[4][3] = findViewById(R.id.b43);
        buttons[4][4] = findViewById(R.id.b44);
        buttons[5][0] = findViewById(R.id.b50);
        buttons[5][1] = findViewById(R.id.b51);
        buttons[5][2] = findViewById(R.id.b52);
        buttons[5][3] = findViewById(R.id.b53);
        buttons[5][4] = findViewById(R.id.b54);
        buttons[6][0] = findViewById(R.id.b60);
        buttons[6][1] = findViewById(R.id.b61);
        buttons[6][2] = findViewById(R.id.b62);
        buttons[6][3] = findViewById(R.id.b63);
        buttons[6][4] = findViewById(R.id.b64);
        buttons[7][0] = findViewById(R.id.b70);
        buttons[7][1] = findViewById(R.id.b71);
        buttons[7][2] = findViewById(R.id.b72);
        buttons[7][3] = findViewById(R.id.b73);
        buttons[7][4] = findViewById(R.id.b74);
        buttons[8][0] = findViewById(R.id.b80);
        buttons[8][1] = findViewById(R.id.b81);
        buttons[8][2] = findViewById(R.id.b82);
        buttons[8][3] = findViewById(R.id.b83);
        buttons[8][4] = findViewById(R.id.b84);
        buttons[9][0] = findViewById(R.id.b90);
        buttons[9][1] = findViewById(R.id.b91);
        buttons[9][2] = findViewById(R.id.b92);
        buttons[9][3] = findViewById(R.id.b93);
        buttons[9][4] = findViewById(R.id.b94);
    }
}
