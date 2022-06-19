package com.ruiz.proyecto;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class ListarAlimentos extends AppCompatActivity {

    @SuppressLint("SourceLockedOrientationActivity")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listar_alimentos);
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.mipmap.ic_launcher_round);
    }

    public void MostrarFresa(View view) {
        Intent fresa= new Intent(this,MostrarAlimento.class);
        fresa.putExtra("nombre", "Fresa");
        startActivity(fresa);

    }
    public void MostrarManzana(View view) {
        Intent manzana= new Intent(this,MostrarAlimento.class);
        manzana.putExtra("nombre", "Manzana");
        startActivity(manzana);

    }

    public void MostrarPina(View view) {
        Intent piña= new Intent(this,MostrarAlimento.class);
        piña.putExtra("nombre", "Piña");
        startActivity(piña);
    }
    public void MostrarSandia(View view) {
        Intent sandia= new Intent(this,MostrarAlimento.class);
        sandia.putExtra("nombre", "Sandia");
        startActivity(sandia);
    }
    public void MostrarBanana(View view) {
        Intent banana= new Intent(this,MostrarAlimento.class);
        banana.putExtra("nombre", "Platano");
        startActivity(banana);
    }
    public void MostrarPera(View view) {
        Intent pera= new Intent(this,MostrarAlimento.class);
        pera.putExtra("nombre", "Pera");
        startActivity(pera);
    }
    public void MostrarKiwi(View view) {
        Intent kiwi= new Intent(this,MostrarAlimento.class);
        kiwi.putExtra("nombre", "Kiwi");
        startActivity(kiwi);
    }
    public void MostrarMango(View view) {
        Intent mango= new Intent(this,MostrarAlimento.class);
        mango.putExtra("nombre", "Mango");
        startActivity(mango);
    }
    public void MostrarMelon(View view) {
        Intent melon= new Intent(this,MostrarAlimento.class);
        melon.putExtra("nombre", "Melón");
        startActivity(melon);
    }
    public void MostrarNaranja(View view) {
        Intent naranja= new Intent(this,MostrarAlimento.class);
        naranja.putExtra("nombre", "Naranja");
        startActivity(naranja);
    }
    public void MostrarCereza(View view) {
        Intent cereza= new Intent(this,MostrarAlimento.class);
        cereza.putExtra("nombre", "Cereza");
        startActivity(cereza);
    }
    public void MostrarUva(View view) {
        Intent uva= new Intent(this,MostrarAlimento.class);
        uva.putExtra("nombre", "Uva");
        startActivity(uva);
    }
}
