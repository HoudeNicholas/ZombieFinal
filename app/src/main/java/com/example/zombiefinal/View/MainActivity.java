package com.example.zombiefinal.View;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.zombiefinal.Model.Weapon;
import com.example.zombiefinal.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public static Weapon sword = new Weapon(2, 6, 1);
    public static Weapon pistol = new Weapon(1, 10, 3);
}
