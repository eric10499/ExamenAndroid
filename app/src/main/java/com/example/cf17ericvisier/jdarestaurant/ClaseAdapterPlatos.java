package com.example.cf17ericvisier.jdarestaurant;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class ClaseAdapterPlatos extends RecyclerView.Adapter<ClaseAdapterPlatos.ClaseViewHolderPlatos> {

    List<Platos> platos;

    public ClaseAdapterPlatos(List<Platos> platos) {
        this.platos = platos;
    }

    @NonNull
    @Override
    public ClaseViewHolderPlatos onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater layoutInflater = LayoutInflater.from(viewGroup.getContext());
        View view = layoutInflater.inflate(R.layout.lista_platos, viewGroup, false);
        return new ClaseViewHolderPlatos(view);

    }

    @Override
    public void onBindViewHolder(@NonNull ClaseViewHolderPlatos claseViewHolderPlatos, int i) {

        Platos info = platos.get(i);
        claseViewHolderPlatos.a.setText(info.getIngredientes());
        claseViewHolderPlatos.b.setText(info.getNombre());
        claseViewHolderPlatos.c.setText(info.getPrecio());


    }

    @Override
    public int getItemCount() {
        return platos.size();
    }

   class ClaseViewHolderPlatos extends RecyclerView.ViewHolder{

        TextView a, b, c;

        public ClaseViewHolderPlatos(@NonNull View itemView) {
            super(itemView);

            a = itemView.findViewById(R.id.fecha);
            b = itemView.findViewById(R.id.ingredientes);
            c = itemView.findViewById(R.id.precio);
        }
    }


}
