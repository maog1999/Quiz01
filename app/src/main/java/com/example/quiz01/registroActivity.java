package com.example.quiz01;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class registroActivity extends AppCompatActivity {

    private EditText nombreInput;
    private EditText idInput;
    private Button btnContinuar;
    private boolean infoCheck;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        nombreInput = findViewById(R.id.nombreInput);
        idInput = findViewById(R.id.idInput);
        btnContinuar = findViewById(R.id.btnContinuar);

        btnContinuar.setBackgroundColor(Color.parseColor("#F01856"));

        //comprobacion para que no pase datosCheck
        btnContinuar.setOnClickListener(
                (v)->{
                    //metodo para saber si llenó los datos o no
                    boolean infoCheck = nombreInput.getText().toString().isEmpty() || idInput.getText().toString().isEmpty();
                    if(infoCheck == true ){
                        //No puede pasar
                        Toast mensaje = Toast.makeText(this,"Completar la información", Toast.LENGTH_LONG);
                        mensaje.show();
                        Log.e("--->", ""+ infoCheck);
                    }if(datosCheck()==false) {
                        String username = nombreInput.getText().toString();
                        String idContra = idInput.getText().toString();
                        Intent n = new Intent(this, nexoActivity.class);
                        n.putExtra("username",username);
                        n.putExtra("idContra",idContra);
                        startActivity(n);
                    }



                }
        );
    }
    public boolean datosCheck(){
        String datos = getSharedPreferences("datos", MODE_PRIVATE).getString("usuarios","No hay datos almacenados");
        if(datos.contains(idInput.getText().toString())){
            Toast mensaje2 = Toast.makeText(this,"La ID ya está registrada", Toast.LENGTH_LONG);
            mensaje2.show();
            return true;
        }
        return false;


    }
}