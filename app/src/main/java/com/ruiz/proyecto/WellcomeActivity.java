package com.ruiz.proyecto;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class WellcomeActivity extends AppCompatActivity  {
    public static final String user="names";
    TextView txtUser;
    private Button exit;

    private FirebaseAuth mAuth;

    private DatabaseReference mDatabase;

    @SuppressLint("SourceLockedOrientationActivity")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wellcome);
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.mipmap.ic_launcher_round);

        txtUser =(TextView)findViewById(R.id.textser);
        //String user = getIntent().getStringExtra("names");
       // txtUser.setText("¡Bienvenido "+ user +"!");

        mDatabase = FirebaseDatabase.getInstance().getReference();
        mAuth=FirebaseAuth.getInstance();
        ObtenerDatos();
        exit =(Button)findViewById(R.id.buttonSalir);
        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            mAuth.signOut();
            startActivity( new Intent(WellcomeActivity.this, MainActivity.class));
            finish();
            }
        });

    }

    private void ObtenerDatos(){
        String id =mAuth.getCurrentUser().getUid();
        mDatabase.child("Usuarios").child(id).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists()){
                    String name= dataSnapshot.child("Nombre").getValue().toString();
                    txtUser.setText("¡Bienvenid@ "+ name+"!");
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
    public void LanzarMaps(View view) {
        Intent maps= new Intent(this,Localizanos.class);
        startActivity(maps);

    }
    public void LanzarIMC(View view) {
        Intent imc= new Intent(this,CalculoImc.class);
        startActivity(imc);

    }

    public void LanzarPI(View view) {
        Intent Pi= new Intent(this,peso_ideal.class);
        startActivity(Pi);

    }

    public void LanzarPS(View view) {
        Intent PS= new Intent(this,PesoSaludable.class);
        startActivity(PS);

    }

    public void LanzarGE(View view) {
        Intent GE= new Intent(this,GastoEnergetico.class);
        startActivity(GE);
    }
    public void LanzarComida(View view) {
        Intent comida= new Intent(this,ListarAlimentos.class);
        startActivity(comida);
    }


}
