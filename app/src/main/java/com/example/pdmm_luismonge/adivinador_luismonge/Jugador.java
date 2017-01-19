package com.example.pdmm_luismonge.adivinador_luismonge;

import java.util.ArrayList;

/**
 * Created by pdmm_luismonge on 12/12/16.
 */

public class Jugador {

    private String usuario;
    private int puntuacion;
    private int partidas;
    public static ArrayList<String>datos=new ArrayList<>();

    public Jugador(){}

    public Jugador(String usuario, int puntuacion, int partidas) {
        this.setUsuario(usuario);
        this.setPuntuacion(puntuacion);
        this.setPartidas(partidas);
        datos.add(" Usuario: "+usuario+" Puntos: " + puntuacion +  " Partidas: " + partidas);
    }


    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public int getPuntuacion() {
        return puntuacion;
    }

    public void setPuntuacion(int puntuacion) {
        this.puntuacion = puntuacion;
    }

    public int getPartidas() {
        return partidas;
    }

    public void setPartidas(int partidas) {
        this.partidas = partidas;
    }





}
