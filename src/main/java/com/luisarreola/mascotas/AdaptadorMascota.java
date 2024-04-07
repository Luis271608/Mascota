package com.luisarreola.mascotas;


import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AdaptadorMascota extends RecyclerView.Adapter<AdaptadorMascota.MascotaViewHolder> {
    ArrayList<Mascota> mascotas;
    public AdaptadorMascota(ArrayList<Mascota> mascotas){
        this.mascotas = mascotas;
    }


    @NonNull
    @Override
    public MascotaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_mascota, parent, false);
        return new MascotaViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MascotaViewHolder holder, @SuppressLint("RecyclerView") int position) { //asoccia cada elemento con los text y image
        Mascota mascota = mascotas.get(position);
        holder.imgFoto.setImageResource(mascota.getFoto());
        holder.tvNombre.setText(mascota.getNombre());
        String numero = String.valueOf(mascota.getRating());
        holder.tvRating.setText(numero);

        holder.imgHuesoBlanco.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mascota.incrementarRating();
                notifyDataSetChanged();
            }
        });
    }

    @Override
    public int getItemCount() { //cantidad de elemento que contiene la lista
        return mascotas.size();
    }

    public static class MascotaViewHolder extends RecyclerView.ViewHolder {
        private ImageView imgFoto;
        private TextView tvNombre;
        private TextView tvRating;
        private ImageView imgHuesoBlanco;

        public MascotaViewHolder(@NonNull View itemView) {
            super(itemView);
            imgFoto = itemView.findViewById(R.id.imgFoto);
            tvNombre = itemView.findViewById(R.id.tvNombre);
            tvRating = itemView.findViewById(R.id.tvRating);
            imgHuesoBlanco = itemView.findViewById(R.id.boton_huesoBlanco);
        }
    }
}