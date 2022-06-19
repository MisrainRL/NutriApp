package com.ruiz.proyecto;

import android.annotation.SuppressLint;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.text.DecimalFormat;

public class CalculoImc extends AppCompatActivity {
    TextView textTitulo;
    TextView textInfo;
    TextView textResultadoIMC, textoObbservacion;
    EditText EdtPso, EdtEstatura;
    DecimalFormat df = new DecimalFormat("#.0");
    ImageView Informacion;

    @SuppressLint("SourceLockedOrientationActivity")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculo_imc);
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.mipmap.ic_launcher_round);

        textTitulo =(TextView)findViewById(R.id.txtTitulo);
        textTitulo.setText("Calculemos tu Indice de masa corporal");
        textResultadoIMC=(TextView)findViewById(R.id.txtResultadoimc);
        textInfo=(TextView)findViewById(R.id.txtInfo);
        textInfo.setText("El índice de masa corporal (IMC) es un método utilizado para estimar la cantidad de grasa corporal que " +
                "tiene una persona, y determinar por tanto si el peso está dentro del rango normal, o por el contrario, se tiene sobrepeso o " +
                "delgadez. Para ello, se pone en relación la estatura y el peso actual del individuo. Esta fórmula matemática fue ideada por el " +
                "estadístico belga Adolphe Quetelet, " +
                "por lo que también se conoce como índice de Quetelet o Body Mass Index (BMI)");
        textResultadoIMC=(TextView)findViewById(R.id.txtResultadoimc);
        EdtPso=(EditText)findViewById(R.id.ediPeso);
        EdtEstatura=(EditText)findViewById(R.id.ediTalla);
        textoObbservacion=(TextView)findViewById(R.id.textObservacion);
        Informacion=(ImageView)findViewById(R.id.imageInfo);
        Informacion.setVisibility(View.INVISIBLE);

    }
    public void CalcularIMC(View view){
        if (EdtPso.getText().toString().trim().equalsIgnoreCase("")){
            Toast toast1 = Toast.makeText(getApplicationContext(), "No ingreso su peso", Toast.LENGTH_SHORT);
            toast1.show();
        }

        else if (EdtEstatura.getText().toString().trim().equalsIgnoreCase("")){
            Toast toast2 = Toast.makeText(getApplicationContext(), "No ingreso su estatura", Toast.LENGTH_SHORT);
            toast2.show();

        }else{
        double peso = Double.parseDouble(EdtPso.getText().toString());
        double altura = Double.parseDouble(EdtEstatura.getText().toString());
        double resultado;

        resultado= peso/(Math.pow(altura,2));
        textResultadoIMC.setText("Su IMC ES:  "+df.format(resultado));
        Informacion.setVisibility(View.VISIBLE);
            /*double comparar;
            comparar=Math.rint(resultado*100)/100;
            textInfo.setText("ESTO ES"+comparar);

         if(comparar<=15.00){
             textoObbservacion.setText("Segun La OMS tu IMC arroja Delgadez muy severa");
         }
         else if((comparar>=15.00) && (comparar <=15.90)){
             textoObbservacion.setText("Segun La OMS tu IMC arroja Delgadez severa");
         }
         if((comparar >= 16.00) || (comparar <= 18.40)){
             textoObbservacion.setText("Segun La OMS tu IMC arroja Delgadez ");
         }
            else if((comparar >=18.50) || (comparar <= 24.90)){
             textoObbservacion.setText("Segun La OMS tu IMC arroja un peso saludable");
         }
            else if((comparar >= 25.00) || (comparar <= 28.90)){
             textoObbservacion.setText("Segun La OMS tu IMC arroja sobrepeso");
         }
            else if((comparar >= 30.00) || (comparar < 34.90)){
             textoObbservacion.setText("Segun La OMS tu IMC arroja obesidad moderada");
         }
            else if((resultado < 35.00) || (resultado > 39.90)){
             textoObbservacion.setText("Segun La OMS tu IMC arroja obesidad severa");
         }
            else if(comparar >=40.00){
             textoObbservacion.setText("Segun La OMS tu IMC arroja obesidad mórbida");
         }*/
        }
    }
}
