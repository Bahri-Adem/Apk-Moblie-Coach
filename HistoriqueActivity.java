package com.example.hadoula.view;



import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.example.hadoula.R;

public class HistoriqueActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_historique);
        ecouteRetour1();
    }
    protected void ecouteRetour1(){
        findViewById(R.id.imageButton3).setOnClickListener(new ImageButton.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HistoriqueActivity.this, MainActivity.class);
                startActivity(intent);

            }});}
}