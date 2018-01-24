package com.example.crist.serviciotecnico;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class acceso_cliente extends AppCompatActivity {

    EditText txt_nombre;
    Button btn_acceder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_acceso_cliente);

        txt_nombre = findViewById(R.id.txt_nombre);
        btn_acceder = findViewById(R.id.btn_acceder);
    }

    public void onClickCliente(View v){
        Intent intent = new Intent(this, chat_cliente.class);
        startActivity(intent);
    }

}
