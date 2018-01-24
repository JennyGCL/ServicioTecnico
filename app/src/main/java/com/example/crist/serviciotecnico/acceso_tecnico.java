package com.example.crist.serviciotecnico;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class acceso_tecnico extends AppCompatActivity {

    EditText txt_nombre;
    EditText txt_contrasenia;
    Button btn_acceder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_acceso_tecnico);

        txt_nombre = findViewById(R.id.txt_nombre);
        txt_contrasenia = findViewById(R.id.txt_contrasenia);
        btn_acceder = findViewById(R.id.btn_acceder);
    }

    public void onClickTecnicoo(View v){
        Intent intent = new Intent(this, chat_tecnico.class);
        startActivity(intent);
    }
}
