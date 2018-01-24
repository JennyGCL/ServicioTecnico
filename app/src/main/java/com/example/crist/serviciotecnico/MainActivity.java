package com.example.crist.serviciotecnico;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.UnknownHostException;
import java.util.Collections;
import java.util.List;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    TextView txtDireccionIP;
    ImageButton btn_tecnico;
    ImageButton btn_cliente;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtDireccionIP = findViewById(R.id.txt_ip);

        btn_tecnico = findViewById(R.id.btn_tecnico);
        btn_cliente = findViewById(R.id.btn_cliente);


    }

    public void onClickTecnico(View v){
        Intent intent = new Intent(this, acceso_tecnico.class);
        startActivity(intent);
    }

    public void onClickCliente(View v){
        Intent intent = new Intent(this, acceso_cliente.class);
        startActivity(intent);
    }

}
