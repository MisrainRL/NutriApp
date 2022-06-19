package com.ruiz.proyecto;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthUserCollisionException;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;

public class RegistroUsuario extends AppCompatActivity {
    private EditText editnombre;
    private  EditText ediApellido;
    private EditText editemail;
    private EditText editpass;
    private  EditText celular;
    private Button registrar;
    //Variables para registrar
    private  String name="";
    private  String Apellido="";
    private  String correo="";
    private  String password="";
    private  String telefono="";
    FirebaseAuth mAuth;
    DatabaseReference mDatabase;
    private ProgressDialog progressDialog;
    @SuppressLint("SourceLockedOrientationActivity")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_usuario);
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.mipmap.ic_launcher_round);
         editnombre=(EditText)findViewById(R.id.edtNombre);
         ediApellido=(EditText)findViewById(R.id.edtApellido);
         editemail=(EditText)findViewById(R.id.edtCorreo);
         editpass=(EditText)findViewById(R.id.edtPass);
         celular=(EditText)findViewById(R.id.editTelefono);
         registrar=(Button)findViewById(R.id.btnRegistrar);
         mAuth = FirebaseAuth.getInstance();
         mDatabase = FirebaseDatabase.getInstance().getReference();

         registrar.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                name=editnombre.getText().toString();
                Apellido=ediApellido.getText().toString();
                correo=editemail.getText().toString();
                password=editpass.getText().toString();
                telefono=celular.getText().toString();

                if (!name.isEmpty() && !correo.isEmpty() && !password.isEmpty()){

                    if(password.length() >=6){
                        if (telefono.length()==10){
                            Toast.makeText(RegistroUsuario.this,"Realizando el registro",Toast.LENGTH_SHORT).show();
                            registrarUser();

                        }else{
                            Toast.makeText(RegistroUsuario.this,"Su número de telefono no es válido",Toast.LENGTH_LONG).show();
                        }
                    }else{
                        Toast.makeText(RegistroUsuario.this,"Su contraseña debe tener al menos 6 caracteres",Toast.LENGTH_LONG).show();
                    }
                }else{
                    Toast.makeText(RegistroUsuario.this,"Debe completar los datos",Toast.LENGTH_LONG).show();
                }
             }
         });
    }


    private  void  registrarUser(){

    mAuth.createUserWithEmailAndPassword(correo,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
        @Override
        public void onComplete(@NonNull Task<AuthResult> task) {
            if (task.isSuccessful()){
                Map<String,Object> map = new HashMap<>();
                map.put("Nombre",name);
                map.put("Apellido",Apellido);
                map.put("Telefono",telefono);
                map.put("Correo",correo);
                String id=mAuth.getCurrentUser().getUid();
                mDatabase.child("Usuarios").child(id).setValue(map).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task2) {
                        if (task2.isSuccessful()){
                            startActivity(new Intent(RegistroUsuario.this,WellcomeActivity.class));
                            finish();
                        }else{
                            Toast.makeText(RegistroUsuario.this, "No se pudo registrar este usuario", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }else {
                if (task.getException() instanceof FirebaseAuthUserCollisionException) {//si se presenta una colisión
                    Toast.makeText(RegistroUsuario.this, "El correo ya existe  ", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(RegistroUsuario.this, "No se pudo registrar el usuario ", Toast.LENGTH_LONG).show();
                }
            }
        }
    });
    }
}
