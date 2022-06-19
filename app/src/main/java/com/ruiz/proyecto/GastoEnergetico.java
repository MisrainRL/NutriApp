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

import java.text.DecimalFormat;

public class GastoEnergetico extends AppCompatActivity {
    TextView Informacion,Titulo,resultado;
    RadioButton hombre, mujer;
    EditText altura,peso,edad;
    DecimalFormat df = new DecimalFormat("#.00");
    @SuppressLint("SourceLockedOrientationActivity")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gasto_energetico);
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.mipmap.ic_launcher_round);

        Informacion=(TextView)findViewById(R.id.GEInfo);
        Titulo=(TextView)findViewById(R.id.GETitulo);
        resultado=(TextView)findViewById(R.id.GEResultado);
        hombre=(RadioButton)findViewById(R.id.radioButtonHombre);
        mujer=(RadioButton)findViewById(R.id.radioButtonMujer);
        altura=(EditText)findViewById(R.id.GEEstatura);
        peso=(EditText)findViewById(R.id.GEPeso);
        edad=(EditText)findViewById(R.id.GEEdad);

        Titulo.setText("Cálculo de gasto energetico Basal");
        Informacion.setText("El gasto energético es la relación entre el consumo de energía y la energía que necesita el organismo. Para mantener el organismo en equilibrio la energía consumida debe de ser igual a la utilizada, o sea que las necesidades energéticas diarias han de ser igual al gasto energético total diario. Si se consume más energía de la necesaria se engorda y si se consume por debajo de las necesidades se entra en desnutrición y por ende se adelgaza al utilizar las reservas de energía del organismo. El organismo no es una excepción al primer principio de la termodinámica. ");
    }

    public void CalcularGE(View view){
        if (altura.getText().toString().trim().equalsIgnoreCase("") ||peso.getText().toString().trim().equalsIgnoreCase("") ||edad.getText().toString().trim().equalsIgnoreCase("")){
            Toast toast1 = Toast.makeText(getApplicationContext(), "Es necesario ingresar todos los datos", Toast.LENGTH_SHORT);
            toast1.show();
        }else {
            double estatura = Double.parseDouble(altura.getText().toString());
            double PESO = Double.parseDouble(peso.getText().toString());
            double años = Double.parseDouble(edad.getText().toString());
            if (hombre.isChecked() == true) {

                Double calculo = 66.5+(13.75*PESO)+(5.003*estatura)-(6.775*años);

                resultado.setText("Su gasto energetico es :  "+df.format(calculo)+ " Kcal/dia");
            } else if (mujer.isChecked() == true) {

               Double calculo= 655.1+(9.563*PESO)+(1.85*estatura)-(4.676*años);
                String imprimir = String.valueOf(calculo);

                resultado.setText("Su gasto energetico es :  "+df.format(calculo)+ " Kcal/dia");
            } else {
                Toast toast2 = Toast.makeText(getApplicationContext(), "Seleccione su sexo", Toast.LENGTH_SHORT);
                toast2.show();
            }

        }
}
}
