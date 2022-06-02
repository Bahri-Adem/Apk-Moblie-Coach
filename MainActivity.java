package com.example.hadoula.view;

import static com.example.hadoula.R.id.imageButton;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.example.hadoula.R;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ecouteMenuIMG();
        ecouteMenuHis();

    }
    protected void ecouteMenuIMG(){
        findViewById(imageButton).setOnClickListener(new ImageButton.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Intent(MainActivity, HistoriqueActivity.class)
                Intent intent = new Intent(MainActivity.this, CalculActivity.class);
                startActivity(intent);

            }
        });
      }


        protected void ecouteMenuHis(){
            findViewById(R.id.imageButton2).setOnClickListener(new ImageButton.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Intent(MainActivity, HistoriqueActivity.class)
                Intent intent = new Intent(MainActivity.this, HistoriqueActivity.class);
                startActivity(intent);

            }});}


    }