package com.ruiz.proyecto;

import android.annotation.SuppressLint;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MostrarAlimento extends AppCompatActivity {
private TextView titulo,prote,kcal,gra,porcio,carbos,ejercicio,cami,bici,corr;
private ImageView alimento;
private String fruta;

    @SuppressLint("SourceLockedOrientationActivity")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mostrar_alimento);
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.mipmap.ic_launcher_round);

        prote=(TextView)findViewById(R.id.proteina);
        kcal=(TextView)findViewById(R.id.calorias);
        gra=(TextView)findViewById(R.id.grasa);
        porcio=(TextView)findViewById(R.id.porcion);
        carbos=(TextView)findViewById(R.id.carbo);
        ejercicio=(TextView)findViewById(R.id.como);
        cami=(TextView)findViewById(R.id.caminar);
        bici=(TextView)findViewById(R.id.bicicleta);
        corr=(TextView) findViewById(R.id.Correr);

        alimento=(ImageView)findViewById(R.id.imagenFruta);
        fruta = getIntent().getExtras().getString("nombre");
        titulo=(TextView)findViewById(R.id.nombreFruta);
        titulo.setText(fruta);
        mostras();
    }
    public void mostras(){
        switch (fruta){
            case "Fresa":
                alimento.setImageResource(R.mipmap.fresa);
                porcio.setText("Porción(100 gram/ml)");
                kcal.setText("Calorías: 36 kcal");
                gra.setText("Grasa (total): 0.50 g");
                prote.setText("Proteína: 0.70 g");
                carbos.setText("Carbohidrato: 7.00 g");
                ejercicio.setText("¿Cómo quemar 36 calorías?");
                cami.setText("7 min");
                bici.setText("5 min");
                corr.setText("2 min");
                break;
            case "Manzana":
                alimento.setImageResource(R.mipmap.manzana);
                porcio.setText("Porción(100 gram/ml)");
                kcal.setText("Calorías: 50 kcal");
                gra.setText("Grasa (total): 0.00 g");
                prote.setText("Proteína: 0.30 g");
                carbos.setText("Carbohidrato: 12.00 g");
                ejercicio.setText("¿Cómo quemar 50 calorías?");
                cami.setText("10 min");
                bici.setText("7 min");
                corr.setText("3 min");
                break;
            case "Piña":
                alimento.setImageResource(R.mipmap.pina);
                porcio.setText("Porción(100 gram/ml)");
                kcal.setText("Calorías: 49 kcal");
                gra.setText("Grasa (total): 0.00 g");
                prote.setText("Proteína: 0.50 g");
                carbos.setText("Carbohidrato: 11.50 g");
                ejercicio.setText("¿Cómo quemar 49 calorías?");
                cami.setText("9 min");
                bici.setText("7 min");
                corr.setText("3 min");
                break;
            case "Sandia":
                alimento.setImageResource(R.mipmap.sandia);
                porcio.setText("Porción(100 gram/ml)");
                kcal.setText("Calorías: 20 kcal");
                gra.setText("Grasa (total): 0.00 g");
                prote.setText("Proteína: 0.40 g");
                carbos.setText("Carbohidrato: 4.50 g");
                ejercicio.setText("¿Cómo quemar 20 calorías?");
                cami.setText("4 min");
                bici.setText("3 min");
                corr.setText("2 min");
                break;
            case "Platano":
                alimento.setImageResource(R.mipmap.banana);
                porcio.setText("Porción(100 gram/ml)");
                kcal.setText("Calorías: 89 kcal");
                gra.setText("Grasa (total): 0.30 g");
                prote.setText("Proteína: 1.20 g");
                carbos.setText("Carbohidrato: 20.00 g");
                ejercicio.setText("¿Cómo quemar 89 calorías?");
                cami.setText("17 min");
                bici.setText("13 min");
                corr.setText("5 min");
                break;
            case "Pera":
                alimento.setImageResource(R.mipmap.pera);
                porcio.setText("Porción(100 gram/ml)");
                kcal.setText("Calorías: 45 kcal");
                gra.setText("Grasa (total): 0.00 g");
                prote.setText("Proteína: 0.40 g");
                carbos.setText("Carbohidrato: 10.60 g");
                ejercicio.setText("¿Cómo quemar 45 calorías?");
                cami.setText("9 min");
                bici.setText("7 min");
                corr.setText("3 min");
                break;
            case "Kiwi":
                alimento.setImageResource(R.mipmap.kiwi);
                porcio.setText("Porción(100 gram/ml)");
                kcal.setText("Calorías: 52 kcal");
                gra.setText("Grasa (total): 0.50 g");
                prote.setText("Proteína: 1.10 g");
                carbos.setText("Carbohidrato: 10.60 g");
                ejercicio.setText("¿Cómo quemar 52 calorías?");
                cami.setText("10 min");
                bici.setText("8 min");
                corr.setText("2 min");
                break;
            case "Mango":
                alimento.setImageResource(R.mipmap.mango);
                porcio.setText("Porción(70 gram/ml)");
                kcal.setText("Calorías: 40 kcal");
                gra.setText("Grasa (total): 0.32 g");
                prote.setText("Proteína: 0.44 g");
                carbos.setText("Carbohidrato: 8.96 g");
                ejercicio.setText("¿Cómo quemar 40 calorías?");
                cami.setText("8 min");
                bici.setText("6 min");
                corr.setText("3 min");
                break;
                case "Melón":
                alimento.setImageResource(R.mipmap.melon);
                porcio.setText("Porción(250 gram/ml)");
                kcal.setText("Calorías: 75 kcal");
                gra.setText("Grasa (total): 0.25 g");
                prote.setText("Proteína: 2.50 g");
                carbos.setText("Carbohidrato: 10.25 g");
                ejercicio.setText("¿Cómo quemar 75 calorías?");
                cami.setText("14 min");
                bici.setText("11 min");
                corr.setText("4 min");
                break;
            case "Naranja":
                alimento.setImageResource(R.mipmap.naranja);
                porcio.setText("Porción(100 gram/ml)");
                kcal.setText("Calorías: 38 kcal");
                gra.setText("Grasa (total): 0.00 g");
                prote.setText("Proteína: 0.80 g");
                carbos.setText("Carbohidrato: 8.60 g");
                ejercicio.setText("¿Cómo quemar 38 calorías?");
                cami.setText("7 min");
                bici.setText("6 min");
                corr.setText("2 min");
                break;
            case "Cereza":
                alimento.setImageResource(R.mipmap.cereza);
                porcio.setText("Porción(100 gram/ml)");
                kcal.setText("Calorías: 62 kcal");
                gra.setText("Grasa (total): 0.50 g");
                prote.setText("Proteína: 0.80 g");
                carbos.setText("Carbohidrato: 13.50 g");
                ejercicio.setText("¿Cómo quemar 62 calorías?");
                cami.setText("12 min");
                bici.setText("9 min");
                corr.setText("4 min");
                break;
            case "Uva":
                alimento.setImageResource(R.mipmap.uva);
                porcio.setText("Porción(50 gram/ml)");
                kcal.setText("Calorías: 55 kcal");
                gra.setText("Grasa (total): 0.13 g");
                prote.setText("Proteína: 0.58 g");
                carbos.setText("Carbohidrato: 14.48 g");
                ejercicio.setText("¿Cómo quemar 55 calorías?");
                cami.setText("10 min");
                bici.setText("8 min");
                corr.setText("3 min");
                break;
        }
    }
}
