package com.example.pdmm_luismonge.adivinador_luismonge;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

public class Info_Jugador extends AppCompatActivity {

    ListView listView;
    Info_JugadorAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.esqueleto_info_jugador);



        adapter = new Info_JugadorAdapter(this, JugarActivity.info);
        listView = (ListView) findViewById(R.id.mListView);
        listView.setAdapter(adapter);


    }





}
