package com.luisarreola.mascotas;


import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Pagina2 extends AppCompatActivity {
    ArrayList<Mascota> mascotas;

    RecyclerView listaMascotas;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pagina_hijo);

        listaMascotas = (RecyclerView) findViewById(R.id.rvMacotas);

        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);

        listaMascotas.setLayoutManager(llm);
        inicializarListaMascotas();
        inicializarAdaptador();

        ImageView pata = findViewById(R.id.icono);
        pata.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }

    private void inicializarAdaptador() {
        AdaptadorMascota adaptador = new AdaptadorMascota(mascotas);
        listaMascotas.setAdapter(adaptador);
    }

    private void inicializarListaMascotas() {
        mascotas = new ArrayList<Mascota>();
        Mascota mascota1 = new Mascota("Roberto", 0, R.drawable.frida);
        mascotas.add(mascota1);
        Mascota mascota2 = new Mascota("Maria", 0, R.drawable.oso);
        mascotas.add(mascota2);
        Mascota mascota3 = new Mascota("Juan", 0, R.drawable.panda);
        mascotas.add(mascota3);
        Mascota mascota4 = new Mascota("Rada", 0, R.drawable.puppy);
        mascotas.add(mascota4);
        Mascota mascota5 = new Mascota("Matty", 0, R.drawable.rocky);
        mascotas.add(mascota5);
    }

}
