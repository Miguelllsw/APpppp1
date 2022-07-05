package com.miguel.appppp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    Button boton, boton2;
    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TimerTask tarea = new TimerTask() {
            @Override
            public void run() {
                Intent intent = new Intent(MainActivity.this, PrincipalActivity.class);
                startActivity(intent);
                finish();
            }
        };
        Timer tiempo = new Timer();
        tiempo.schedule(tarea,5000);


    }
/*
    public boolean onCreateOptionsMenu(Menu miMenu){

        getMenuInflater().inflate(R.menu.menu, miMenu);

        return true;

    }

    public boolean onOptionsItemSelected(MenuItem opcion_menu){
        int id =opcion_menu.getItemId();
        if(id==R.id.generar){
            Intent intent = new Intent(MainActivity.this,Generar.class);
            startActivity(intent);

            return true;
        }
        if(id==R.id.ingres){

            Intent intent = new Intent(MainActivity.this,Ingresar.class);
            startActivity(intent);
            return true;
        }

        if(id==R.id.salir){
            finish();
        }
        return super.onOptionsItemSelected(opcion_menu);
    }*/

}