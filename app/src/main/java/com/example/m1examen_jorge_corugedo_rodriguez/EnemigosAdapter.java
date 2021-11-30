package com.example.m1examen_jorge_corugedo_rodriguez;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class EnemigosAdapter extends RecyclerView.Adapter<EnemigosAdapter.ViewHolder> {
    Context context;
    ArrayList<Enemigo> listaEnemigos;


    public EnemigosAdapter(Context context, ArrayList<Enemigo> listaEnemigos){
      this.context = context;
      this.listaEnemigos = listaEnemigos;
    }
    @NonNull
    @Override

    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_list, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        String nombre = listaEnemigos.get(position).getNombre();
        //Paso la información que necesita el holder para el clicklistener: el contexto y el enemigo
        holder.getTextView().setText(nombre);
        holder.setEnemigo(listaEnemigos.get(position));
        holder.setContext(context);
    }


    @Override
    public int getItemCount() {
        return listaEnemigos.size();
    }
    public static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private final TextView textView;
        private Enemigo enemigo;
        private Context context;

        public ViewHolder(View view) {
            super(view);


            textView = (TextView) view.findViewById(R.id.item_name);
            textView.setOnClickListener(this);
        }

        public void setEnemigo(Enemigo enemigo) {
            this.enemigo = enemigo;
        }

        public void setContext(Context context) {
            this.context = context;
        }

        public TextView getTextView() {
            return textView;
        }

        @Override
        public void onClick(View view) {
            //Mando a la actividad para que genere desde ella la nueva actividad con la información
           MainActivity activity = (MainActivity) context;
           activity.showInfo(enemigo);
        }
    }
}
