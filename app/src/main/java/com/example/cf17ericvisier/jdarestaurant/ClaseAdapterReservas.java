package com.example.cf17ericvisier.jdarestaurant;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class ClaseAdapterReservas extends RecyclerView.Adapter<ClaseAdapterReservas.ClaseAdapterViewHolder> {

    List<Reservas> reservas;

    public ClaseAdapterReservas(List<Reservas> reservas) {
        this.reservas = reservas;
    }

    @NonNull
    @Override
    public ClaseAdapterViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater layoutInflater = LayoutInflater.from(viewGroup.getContext());
        View view = layoutInflater.inflate(R.layout.lista_reservas, viewGroup, false);
        return new ClaseAdapterViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull ClaseAdapterViewHolder claseAdapterViewHolder, int i) {

        Reservas info = reservas.get(i);
        claseAdapterViewHolder.a.setText(info.getFecha());
        claseAdapterViewHolder.b.setText(info.getPersonas());

    }

    @Override
    public int getItemCount() {
        return reservas.size();
    }


    class ClaseAdapterViewHolder extends RecyclerView.ViewHolder{
        TextView a, b;


        public ClaseAdapterViewHolder(@NonNull View itemView) {
            super(itemView);

            a = itemView.findViewById(R.id.fecha);
            b = itemView.findViewById(R.id.comensales);
        }
    }
}
