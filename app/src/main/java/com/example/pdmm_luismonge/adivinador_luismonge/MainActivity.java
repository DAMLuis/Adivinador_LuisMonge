package com.example.pdmm_luismonge.adivinador_luismonge;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    Spinner dificultad;
    Spinner rango;
    Button iniciar;
    EditText usuario;
    int pos;
    public static ArrayList<Jugador> jugador = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        iniciar = (Button)findViewById(R.id.btn_iniciar);
        usuario = (EditText)findViewById(R.id.edt_user);

        rango = (Spinner)findViewById(R.id.spiner_rango);
        dificultad = (Spinner)findViewById(R.id.spiner_dificultad);

        ArrayAdapter<CharSequence> adapta= ArrayAdapter.createFromResource(this,R.array.dificultad,R.layout.support_simple_spinner_dropdown_item);

        adapta.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        rango.setAdapter(adapta);

        rango.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {
                int [] difil = {R.array.facil,R.array.medio,R.array.dificil,R.array.muydificil};
                ArrayAdapter<CharSequence> adapta2= ArrayAdapter.createFromResource(getApplicationContext(),difil[position],R.layout.support_simple_spinner_dropdown_item);
                adapta2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                dificultad.setAdapter(adapta2);
                pos=position;
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


    }


    public void jugar(View view){
        String user = usuario.getText().toString();
        Jugador juga = new Jugador(user,0,0);
        jugador.add(juga);

        if(user.isEmpty()){
            Toast.makeText(getApplicationContext(),"Introduce un usuario" ,Toast.LENGTH_SHORT).show();
        }else{
            Intent i = new Intent(MainActivity.this,JugarActivity.class);
            Bundle b = new Bundle();
            b.putInt("pos", pos);
            i.putExtras(b);

            startActivity(i);
        }

    }



}
