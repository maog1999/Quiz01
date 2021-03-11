package com.example.quiz01;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;

public class sintomasActivity extends AppCompatActivity {

    private CheckBox checkBox1;
    private CheckBox checkBox2;
    private CheckBox checkBox3;
    private CheckBox checkBox4;
    private CheckBox checkBox5;
    private CheckBox checkBox6;
    private CheckBox checkBox7;
    private Button btnFinalizar;
    private String username;
    private String idContra;
    private int ptRiesgo;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sintomas);

        checkBox1 = findViewById(R.id.checkBox1);
        checkBox2 = findViewById(R.id.checkBox2);
        checkBox3 = findViewById(R.id.checkBox3);
        checkBox4 = findViewById(R.id.checkBox4);
        checkBox5 = findViewById(R.id.checkBox5);
        checkBox6 = findViewById(R.id.checkBox6);
        checkBox7 = findViewById(R.id.checkBox7);
        btnFinalizar = findViewById(R.id.btnFinalizar);

        //Recoleccion de info
        username = getIntent().getExtras().getString("username");
        idContra = getIntent().getExtras().getString("idContra");
        ptRiesgo = getIntent().getExtras().getInt("ptRiesgo");


        btnFinalizar.setOnClickListener(
                (v)->{
                    checkboxs();

                    //validacion de si ya oprimio las boxes y pueda continuar
                    if(checkBox1.isChecked() == true || checkBox2.isChecked() == true || checkBox3.isChecked() == true || checkBox4.isChecked() == true ||
                    checkBox5.isChecked() == true || checkBox6.isChecked() == true || checkBox7.isChecked() == true){
                        btnFinalizar.setBackgroundColor(Color.parseColor("#AAD123"));
                        Intent m = new Intent(this, MainActivity.class);
                        saveData();
                        startActivity(m);
                        finish();
                    }else {
                        btnFinalizar.setBackgroundColor(Color.parseColor("#DEDEDE"));
                    }

                }
        );
    }

    private void checkboxs(){
        if(checkBox1.isChecked()){
            ptRiesgo += 4;
        }if (checkBox2.isChecked()){
            ptRiesgo += 4;
        }if(checkBox3.isChecked()){
            ptRiesgo += 4;
        }if(checkBox4.isChecked()){
            ptRiesgo += 4;
        }if(checkBox5.isChecked()){
            ptRiesgo +=4;
        }if(checkBox6.isChecked()){
            ptRiesgo +=4;
        }if(checkBox7.isChecked()){
            ptRiesgo +=0;
        }
    }

    private void saveData(){
        SharedPreferences preferences = getSharedPreferences("datos", MODE_PRIVATE); //lave para guardar todos los datos
        String loQueYaEstaba = preferences.getString("usuarios","");//como no hay nada a la primera, está vacio
        String user = username + ", " + idContra + ", " + ptRiesgo + "\n" ;
        preferences.edit().putString("usuarios", loQueYaEstaba + user ).apply();
    }
}