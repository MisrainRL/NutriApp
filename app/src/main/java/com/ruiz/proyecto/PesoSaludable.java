package com.ruiz.proyecto;

import android.annotation.SuppressLint;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.text.DecimalFormat;

public class PesoSaludable extends AppCompatActivity {

    TextView titulo;
    TextView informacion;
    TextView psmin;
    TextView psmax;
    EditText altura;

    DecimalFormat df = new DecimalFormat("#.00");
    @SuppressLint("SourceLockedOrientationActivity")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_peso_saludable);
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.mipmap.ic_launcher_round);
        //Se considera un peso saludable  aquel que nos permite mantenernos en un buen estado de salud y calidad de vida.  También se entiende como  los valores de peso, dentro de los cuales, no existe riesgo para la salud de la persona

        titulo=(TextView)findViewById(R.id.txtvTitulo);
        titulo.setText("Calcula tu peso saludable");

        informacion=(TextView)findViewById(R.id.txtvInfo);
        informacion.setText("En nuestro país y otros se ha sugerido el término “peso corporal saludable” para  definir  el  intervalo  de  peso  corporal " +
                " que  se  relaciona  con  estadísticas  de  buena  salud es  decir,  un  pesocorporal  que  tiene  un  límite  mínimo " +
                " y  uno  máximo  entre  los  cuales  es  muy  probable  mantener  un  buen  estado  desalud.");

        altura=(EditText)findViewById(R.id.edtTalla) ;

        psmin=(TextView)findViewById(R.id.psMIN);
        psmax=(TextView)findViewById(R.id.psMax);
    }

    public void CalculoPS(View view){
        if (altura.getText().toString().trim().equalsIgnoreCase("")){
            Toast toast1 = Toast.makeText(getApplicationContext(), "No ingreso el valor de su altura", Toast.LENGTH_SHORT);
            toast1.show();
        }else {

            double estatura = Double.parseDouble(altura.getText().toString());
            double PSMIN;
            double PSMax;

            PSMIN=(Math.pow(estatura,2))*18.5;
            PSMax=(Math.pow(estatura,2))*24.9;

            psmin.setText("Tu peso saludable minimo es: "+df.format(PSMIN)+ " kg");
            psmax.setText("Tu peso saludable máximo es: "+df.format(PSMax)+ " kg");
        }
    }
}
