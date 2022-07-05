package com.miguel.appppp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import com.google.android.material.snackbar.Snackbar;

import java.util.Random;

public class Generar extends AppCompatActivity {

    Button boton;
    TextView respuesta,textView2;
    EditText ingreso;
    ImageButton bt2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_generar);

        //button = findViewById(R.id.button);
        boton = findViewById(R.id.btn_generar2);
        respuesta = findViewById(R.id.tv_codigo);
        //ingreso = findViewById(R.id.et_codigo);
        textView2 = findViewById(R.id.textView2);
        bt2 = findViewById(R.id.imageButtonGuard);

        final Random random = new Random();


        bt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent ie = new Intent(Generar.this, PrincipalActivity.class);
                startActivity(ie);
                return;
            }
        });


        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG);
                //.setAction("Action", null).show();

                String randomNumber = String.valueOf(random.nextInt(1000000));
                respuesta.setText(randomNumber);


            }
        });
    }
}