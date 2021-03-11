package com.example.quiz01;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.CheckBox;

public class nexoActivity extends AppCompatActivity {

    private CheckBox check1;
    private CheckBox check2;
    private CheckBox check3;
    private CheckBox check4;
    private CheckBox check5;
    private Button btnContinuar2;
    private String username;
    private String idContra;
    private int ptRiesgo = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nexo);

        check1 = findViewById(R.id.check1);
        check2 = findViewById(R.id.check2);
        check3 = findViewById(R.id.check3);
        check4 = findViewById(R.id.check4);
        check5 = findViewById(R.id.check5);
        btnContinuar2 = findViewById(R.id.btnContinuar2);


        //Recoleccion de info
        username = getIntent().getExtras().getString("username");
        idContra = getIntent().getExtras().getString("idContra");

        Log.e("->", "" + ptRiesgo);

        cambioBoton();

        btnContinuar2.setOnClickListener(
                (v)->{
                    checkboxs();

                    //validacion de si ya oprimio las boxes y pueda continuar
                    if(check1.isChecked() == true || check2.isChecked()==true || check3.isChecked()==true || check4.isChecked()==true || check5.isChecked()==true ) {
                        Intent n = new Intent(this, sintomasActivity.class);
                        n.putExtra("username", username);
                        n.putExtra("idContra", idContra);
                        n.putExtra("ptRiesgo",ptRiesgo);
                        startActivity(n);
                        finish();
                    }
                }
        );
    }

    private void checkboxs(){
        if(check1.isChecked()){
            ptRiesgo += 4;
        }if (check2.isChecked()){
            ptRiesgo += 4;
        }if(check3.isChecked()){
            ptRiesgo += 4;
        }if(check4.isChecked()){
            ptRiesgo += 4;
        }if(check5.isChecked()){
            ptRiesgo +=0;
        }
    }

    private void cambioBoton(){
        new  Thread(
                ()->{
                    Log.e("----->","entro");
                    if(check1.isChecked() == true || check2.isChecked()==true || check3.isChecked()==true || check4.isChecked()==true || check5.isChecked()==true ) {
                       runOnUiThread(
                               ()->{
                                   btnContinuar2.setBackgroundColor(Color.parseColor("#AAD123"));
                               }
                       );
                    }else {
                        runOnUiThread(
                                ()->{
                                    btnContinuar2.setBackgroundColor(Color.parseColor("#DEDEDE"));
                                }
                        );

                    }
                }
        ).start();

    }
}