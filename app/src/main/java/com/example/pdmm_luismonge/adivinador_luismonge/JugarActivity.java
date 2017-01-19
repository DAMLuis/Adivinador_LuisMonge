package com.example.pdmm_luismonge.adivinador_luismonge;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class JugarActivity extends AppCompatActivity {
    private int nGenerado;
    int puntos;
    int partidas=0;
    int intentos=0;
    int pos;
    Random r = new Random();
    Button comprobar, nuevaPartida, infoJugador;
    EditText numS;
    TextView tv_partidas;
    TextView tv_puntos;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jugar);

        Intent i = getIntent();
        Bundle b = i.getExtras();
        pos = b.getInt("pos");

        comprobar = (Button)findViewById(R.id.btn_comprobar);
        numS = (EditText)findViewById(R.id.edt_num);
        nuevaPartida=(Button)findViewById(R.id.btn_nuevaPartida);
        tv_partidas=(TextView)findViewById(R.id.tv_partidas);
        tv_puntos=(TextView)findViewById(R.id.tv_puntos);
        infoJugador=(Button)findViewById(R.id.btn_infoJugador);

        nuevaPartida.setEnabled(false);

        generar();

        comprobar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(numS.getText().toString().isEmpty()) {
                    Toast.makeText(getApplicationContext(), "Introduce un numero", Toast.LENGTH_SHORT).show();
                }else {
                    int num = Integer.parseInt(numS.getText().toString());

                    if (num == nGenerado) {
                        Toast.makeText(getApplicationContext(), "Has ganado", Toast.LENGTH_SHORT).show();
                        partidas++;
                        nuevaPartida.setEnabled(true);
                        comprobar.setEnabled(false);
                        switch (pos) {
                            case 0:
                                puntos +=2;
                                break;
                            case 1:
                                puntos +=4;
                                break;
                            case 2:
                                puntos += 6;
                                break;
                            case 3:
                                puntos += 10;
                                break;
                        }
                        tv_partidas.setText(String.valueOf(partidas));
                        tv_puntos.setText(String.valueOf(puntos));

                    } else {
                        intentos++;
                        Toast.makeText(getApplicationContext(), "Intente de nuevo " + intentos, Toast.LENGTH_SHORT).show();
                        if (num > nGenerado) {
                            Toast.makeText(getApplicationContext(), "Es menor que " + num, Toast.LENGTH_SHORT).show();
                        } else if (num < nGenerado) {
                            Toast.makeText(getApplicationContext(), "Es mayor que  " + num, Toast.LENGTH_SHORT).show();
                        }


                    }

                    if (intentos >= 5) {
                        puntos=-4;
                        Toast.makeText(getApplicationContext(), "Has perdido", Toast.LENGTH_SHORT).show();
                        comprobar.setEnabled(false);
                        tv_partidas.setText(String.valueOf(partidas));
                        tv_puntos.setText(String.valueOf(puntos));
                        nuevaPartida.setEnabled(true);
                    }
                }

            }
        });


        nuevaPartida.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                generar();
                intentos=0;
                numS.setText("");
                comprobar.setEnabled(true);
                nuevaPartida.setEnabled(false);
                tv_partidas.setText(String.valueOf(partidas));
                tv_puntos.setText(String.valueOf(puntos));


            }
        });

        //carga los datos
        datos();

        infoJugador.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(JugarActivity.this,Info_Jugador.class));
            }
        });


    }

    public void generar(){
        Toast.makeText(getApplicationContext(),"Tiene 5 intentos " ,Toast.LENGTH_SHORT).show();
        switch(pos){
            case 0:
                nGenerado=r.nextInt(30 - 1)+ 1;
                break;
            case 1:
                nGenerado=r.nextInt(200 - 1)+ 1;
                break;
            case 2:
                nGenerado=r.nextInt(400 - 1)+ 1;
                break;
            case 3:
                nGenerado=r.nextInt(1100 - 1)+ 1;
            break;

        }
        Toast.makeText(getApplicationContext(),String.valueOf(nGenerado),Toast.LENGTH_SHORT).show();

    }




    public void datos(){
        Jugador j1 = new Jugador();
        j1.setPartidas(partidas);
        j1.setPuntuacion(puntos);
    }



}
