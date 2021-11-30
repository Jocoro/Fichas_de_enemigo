package com.example.m1examen_jorge_corugedo_rodriguez;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.textfield.TextInputLayout;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    TextInputLayout txtNombre, txtEdad, txtDescripcion;
    Button add;
    RecyclerView recyclerView;
    ArrayList<Enemigo> listaEnemigos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtNombre = findViewById(R.id.edit_nombre_enemigo);
        txtEdad = findViewById(R.id.edit_edad);
        txtDescripcion = findViewById(R.id.edit_descripcion);
        add = findViewById(R.id.btn_add);

        recyclerView = findViewById(R.id.recicler_view);


        listaEnemigos = new ArrayList<>();
        EnemigosAdapter adapter = new EnemigosAdapter(this,listaEnemigos);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);

        add.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (txtNombre.getEditText().getText().toString().isEmpty()) {
            Toast.makeText(this, "El campo nombre está vacio", Toast.LENGTH_SHORT).show();
        } else {
            if (txtEdad.getEditText().getText().toString().isEmpty()) {
                Toast.makeText(this, "El campo edad está vacio", Toast.LENGTH_SHORT).show();
            } else{
               int edad = Integer.parseInt(txtEdad.getEditText().getText().toString());
               if( edad>=0 && edad<=150){
                   // Se añade el enemigo ya que cumple todas las condiciones
                   addEnemigo();
               }else{
                   Toast.makeText(this, "La edad tiene que estar entre 0 y 150", Toast.LENGTH_SHORT).show();
               }
            }
        }
    }
    public void addEnemigo(){
        //Añado el enemigo a la lista
      String nombre = txtNombre.getEditText().getText().toString();
      int edad = Integer.parseInt(txtEdad.getEditText().getText().toString());
      String descripcion = txtDescripcion.getEditText().getText().toString();
      listaEnemigos.add(new Enemigo(nombre,edad,descripcion));
      //Se notifica al adapter del recycler que ha habido un cambio para que lo refleje en la vista
      recyclerView.getAdapter().notifyDataSetChanged();
    }

    public void showInfo(Enemigo enemigo){
        Intent intent = new Intent(this, InfoEnemigoActivity.class);
        intent.putExtra("Nombre",enemigo.getNombre());
        intent.putExtra("Edad", enemigo.getEdad());
        intent.putExtra("Descripción",enemigo.getDescripcion());
        startActivity(intent);
    }

}