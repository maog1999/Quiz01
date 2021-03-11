package com.example.quiz01;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView listaUsers;
    private Button btnRegistrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listaUsers = findViewById(R.id.listaUsers);
        btnRegistrar = findViewById(R.id.btnRegistrar);

        btnRegistrar.setBackgroundColor(Color.parseColor("#F01856"));

        btnRegistrar.setOnClickListener(
                (v)->{
                    Intent i = new Intent(this, registroActivity.class );
                    startActivity(i);
                }
        );

    }

    @Override
    protected void onResume() {
        super.onResume();
        loadData();
    }

    private void loadData(){
        String datos = getSharedPreferences("datos", MODE_PRIVATE).getString("usuarios","No hay datos almacenados");
        listaUsers.setText(datos);
    }
}