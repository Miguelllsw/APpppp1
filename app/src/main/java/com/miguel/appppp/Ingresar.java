package com.miguel.appppp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

public class Ingresar extends AppCompatActivity {


    Button boton1;
    TextView text;
    EditText et;
    ImageButton bt1;
    private FirebaseFirestore mFirebase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ingresar);

        bt1 = findViewById(R.id.imageButtonVolverIngre);
        mFirebase = FirebaseFirestore.getInstance();
        boton1 = findViewById(R.id.btn_guardar);
        et = findViewById(R.id.et_ingresar);

        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent ie = new Intent(Ingresar.this, PrincipalActivity.class);
                startActivity(ie);
                return;
            }
        });




        boton1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
               String id = et.getText().toString().trim();
               String nam = new String("miguel");
                String apell = new String("hernandez");

                if (id.isEmpty()) {

                    Toast.makeText(getApplicationContext(), "ingresar datos", Toast.LENGTH_LONG).show();

                }else{
                    
                    post(id,nam,apell);


                }

            }



            private void post(String id,String name, String apell) {
                Map<String, Object> map = new HashMap<>();
                map.put("Apellido", apell);
                map.put("Nombre", name);
                map.put("idClass", id);

                mFirebase.collection( "id").add(map).addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                    @Override
                    public void onSuccess(DocumentReference documentReference) {
                        Toast.makeText(getApplicationContext(), "Creado", Toast.LENGTH_LONG).show();
                        //finish();
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(getApplicationContext(), "Error", Toast.LENGTH_LONG).show();
                    }
                });
            }

        });

    }

}