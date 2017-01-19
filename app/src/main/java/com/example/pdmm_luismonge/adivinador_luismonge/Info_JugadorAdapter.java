package com.example.pdmm_luismonge.adivinador_luismonge;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by luis on 19/01/17.
 */

public class Info_JugadorAdapter extends ArrayAdapter<Jugador> {

    ArrayList<Jugador>info;

    public Info_JugadorAdapter(Activity context, ArrayList<Jugador>datos) {
        super(context, 0, datos);
        this.info=datos;
    }


    @NonNull
    @Override
    public View getView(int i, View vista, ViewGroup vistagrupo) {


        if (vista == null) {
            Context cnt = vistagrupo.getContext();
            vista = LayoutInflater.from(cnt).inflate(R.layout.activity_info__jugador, null);
        }


        final Jugador jugador=info.get(i);
        TextView nombre=(TextView)vista.findViewById(R.id.tv_infoNombre);
        TextView partidas=(TextView)vista.findViewById(R.id.tv_infoPartidas);
        TextView puntos=(TextView)vista.findViewById(R.id.tv_infoPuntos);



            nombre.setText("Usuario: "+jugador.getUsuario());
            partidas.setText("Partidas: "+jugador.getPartidas());
            puntos.setText("Puntos: "+jugador.getPuntuacion());



        return vista;

    }




}
