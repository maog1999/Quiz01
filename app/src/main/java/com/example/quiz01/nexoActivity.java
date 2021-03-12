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

        btnContinuar2.setBackgroundColor(Color.parseColor("#DEDEDE"));

        //Recoleccion de info
        username = getIntent().getExtras().getString("username");
        idContra = getIntent().getExtras().getString("idContra");

        Log.e("->", "" + ptRiesgo);


        btnContinuar2.setOnClickListener(
                (v)->{

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

        check1.setOnClickListener(
                (v)->{
                    if (check1.isChecked()){
                        btnContinuar2.setBackgroundColor(Color.parseColor("#F01856"));
                        ptRiesgo += 3;

                    }else {
                        btnContinuar2.setBackgroundColor(Color.parseColor("#DEDEDE"));
                    }
                }
        );
        check2.setOnClickListener(
                (v)->{
                    if (check2.isChecked()){
                        btnContinuar2.setBackgroundColor(Color.parseColor("#F01856"));
                        ptRiesgo += 3;
                    }  else {
                        btnContinuar2.setBackgroundColor(Color.parseColor("#DEDEDE"));
                    }
                }
        );
        check3.setOnClickListener(
                (v)->{
                    if (check3.isChecked()){
                        btnContinuar2.setBackgroundColor(Color.parseColor("#F01856"));
                        ptRiesgo += 3;
                    }else {
                        btnContinuar2.setBackgroundColor(Color.parseColor("#DEDEDE"));
                    }
                }
        );
        check4.setOnClickListener(
                (v)->{
                    if (check4.isChecked()){
                        btnContinuar2.setBackgroundColor(Color.parseColor("#F01856"));
                        ptRiesgo += 3;
                    }else {
                        btnContinuar2.setBackgroundColor(Color.parseColor("#DEDEDE"));
                    }
                }
        );
        check5.setOnClickListener(
                (v)->{
                    if (check5.isChecked()){
                        btnContinuar2.setBackgroundColor(Color.parseColor("#F01856"));
                        ptRiesgo += 0;
                    }else {
                        btnContinuar2.setBackgroundColor(Color.parseColor("#DEDEDE"));
                    }
                }
        );
    }


}