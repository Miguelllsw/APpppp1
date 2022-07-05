package com.miguel.appppp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class PrincipalActivity extends AppCompatActivity {

    ImageButton bo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);

        bo = (ImageButton) findViewById(R.id.imageButton5);

        bo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(PrincipalActivity.this,Ingresar.class);
                startActivity(i);
                return;

            }
        });




    }public boolean onCreateOptionsMenu(Menu miMenu){

        getMenuInflater().inflate(R.menu.menu, miMenu);

        return true;

    }

    public boolean onOptionsItemSelected(MenuItem opcion_menu){
        int id =opcion_menu.getItemId();
        if(id==R.id.generar){
            Intent intent = new Intent(PrincipalActivity.this,Generar.class);
            startActivity(intent);

            return true;
        }
        if(id==R.id.ingres){

            Intent intent = new Intent(PrincipalActivity.this,Ingresar.class);
            startActivity(intent);
            return true;
        }

        if(id==R.id.salir){
            finish();
        }
        return super.onOptionsItemSelected(opcion_menu);
    }
}