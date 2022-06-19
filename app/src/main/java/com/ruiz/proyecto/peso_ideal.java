package com.ruiz.proyecto;

import android.annotation.SuppressLint;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class peso_ideal extends AppCompatActivity {
   TextView Informacion,Titulo,resultado;
    RadioButton hombre, mujer;
    EditText altura;
    @SuppressLint("SourceLockedOrientationActivity")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_peso_ideal);
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.mipmap.ic_launcher_round);

        Titulo=(TextView)findViewById(R.id.textVTitulo);
        Informacion=(TextView)findViewById(R.id.textViewInfo);
        resultado=(TextView)findViewById(R.id.textViewResultado);
        altura=(EditText)findViewById(R.id.editTextTalla) ;
        hombre=(RadioButton)findViewById(R.id.radioButtonHombre);
        mujer=(RadioButton)findViewById(R.id.radioButtonMujer);
        Titulo.setText("Calculemos tu peso ideal");
        Informacion.setText("El peso ideal (PI) se entiende como el peso corporal que confiere " +
                "la mayor esperanza de vida a una persona. Para el cálculo del peso ideal se han " +
                "desarrollado a una serie de fórmulas matemáticas y tablas según estudios poblacionales");
    }

    public void CalcularPI(View view){
        if (altura.getText().toString().trim().equalsIgnoreCase("")){
            Toast toast1 = Toast.makeText(getApplicationContext(), "No ingreso el valor de su altura", Toast.LENGTH_SHORT);
            toast1.show();
        }else {
            int talla = Integer.parseInt(altura.getText().toString());
//PI = Talla (cm) - 100 - [(Talla(cm)-150)/k] K=4 para hombres k=2 para mujeres
            if (hombre.isChecked() == true) {

                int calculo = talla - 100 - ((talla - 150) / 4);
                String imprimir = String.valueOf(calculo);
                resultado.setText(String.format("Su peso ideal deberia ser :  %s", imprimir + " Kg"));
            } else if (mujer.isChecked() == true) {

                int calculo = talla - 100 - ((talla - 150) / 2);
                String imprimir = String.valueOf(calculo);
                resultado.setText(String.format("Su peso ideal deberia ser :  %s", imprimir));
            } else {
                Toast toast2 = Toast.makeText(getApplicationContext(), "Seleccione su sexo", Toast.LENGTH_SHORT);
                toast2.show();
            }
        }
    }
}
