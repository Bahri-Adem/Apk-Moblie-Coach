package com.example.hadoula.view;

import static com.example.hadoula.R.id.imageButton;
import static com.example.hadoula.R.id.imageButton5;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;
import com.example.hadoula.R;

public class CalculActivity extends AppCompatActivity {

    private EditText txtPoids;
    private EditText txtTaille;
    private EditText txtAge;
    private RadioButton rdHomme;
    public TextView lblIMG;
    public ImageView imgSmiley;
    private com.example.hadoula.controler.Control Control;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calcul);
        init();
        this.Control= Control.getInstance();
    }

    private void init(){
        txtPoids = (EditText) findViewById(R.id.editTextNumber);
        txtTaille = (EditText) findViewById(R.id.editTextNumber2);
        txtAge = (EditText) findViewById(R.id.editTextNumber3);
        rdHomme = (RadioButton) findViewById(R.id.radioButton2);
        lblIMG = (TextView) findViewById(R.id.lblIMG);
        imgSmiley = (ImageView) findViewById(R.id.imgSmiley);
        ecouteCalcul();
        ecouteRetour();
    }
    private void ecouteCalcul(){
        ((Button) findViewById(R.id.button1)).setOnClickListener(new Button.OnClickListener(){

            public void onClick(View v) {
                Integer poids = 0;
                Integer taille = 0;
                Integer age = 0;
                Integer sexe =0;
                try {
                    poids =Integer.parseInt(txtPoids.getText().toString());

                    taille =Integer.parseInt(txtTaille.getText().toString());

                    age =Integer.parseInt(txtAge.getText().toString());

                }catch(Exception e){};
                if (rdHomme.isChecked()){
                    sexe =1;
                }
                if (poids ==0 || taille== 0 || age ==0){
                    Toast.makeText(CalculActivity.this, "Saisir incorrecte", Toast.LENGTH_SHORT).show();

                }else{
                    afficheResult(poids, taille, age, sexe);
                }
            }
        });
    }

    private void afficheResult(Integer poids, Integer taille,
                               Integer age, Integer sexe){
        this.Control.creerProfil(poids, taille, age, sexe);
        float img = this.Control.getImg();
        String message = this.Control.getMessage();
        if (message == "normal") {
            imgSmiley.setImageResource(R.drawable.img1);
            lblIMG.setTextColor(Color.GREEN);
        }else{
            lblIMG.setTextColor(Color.RED);
            if (message=="trop faible"){
                imgSmiley.setImageResource(R.drawable.img2);
            }else{
                imgSmiley.setImageResource(R.drawable.img3);
            }
        }
        lblIMG.setText(String.format("%.01f",img)+" : IMG "+ message);
    }
    protected void ecouteRetour(){
        findViewById(imageButton5).setOnClickListener(new ImageButton.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CalculActivity.this, MainActivity.class);
                startActivity(intent);

            }
        });
    }


}