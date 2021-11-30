package com.example.m1examen_jorge_corugedo_rodriguez;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class InfoEnemigoActivity extends AppCompatActivity {
     Enemigo enemigo;
     TextView txtNombre,txtEdad,txtDescripcion;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = getIntent();
        String nombre = intent.getStringExtra("Nombre");
        int edad = intent.getIntExtra("Edad",0);
        String descripcion = intent.getStringExtra("Descripción");
        enemigo = new Enemigo(nombre,edad,descripcion);
        setContentView(R.layout.activity_info_enemigo);
        setTitle(enemigo.getNombre());

        txtNombre = findViewById(R.id.txtview_name);
        txtEdad = findViewById(R.id.txtview_edad);
        txtDescripcion = findViewById(R.id.txtview_descripcion);

        txtNombre.setText(nombre);
        txtEdad.setText(String.valueOf(edad));
        txtDescripcion.setText(descripcion);


    }
}