package com.example.crist.serviciotecnico;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
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
    private static final int PERMISO = 1;
    TextView txtDireccionIP;
    ImageButton btn_tecnico;
    ImageButton btn_cliente;
    ImageButton btn_wifi;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Solicita permiso de ubicación en caso de que no este ya concedido.
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) == PackageManager.PERMISSION_GRANTED) {

        } else {
            solicitarPermiso();
        }

        txtDireccionIP = findViewById(R.id.txt_ip);
        btn_tecnico = findViewById(R.id.btn_tecnico);
        btn_cliente = findViewById(R.id.btn_cliente);
        btn_wifi = (ImageButton)findViewById(R.id.btn_wifi);

        btn_wifi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                        Intent wifiList;
                        wifiList = new Intent(getApplicationContext(), Wifi.class);
                        startActivity(wifiList);
            }
        });


    }

    public void onClickTecnico(View v){
        Intent intent = new Intent(this, acceso_tecnico.class);
        startActivity(intent);
    }

    public void onClickCliente(View v){
        Intent intent = new Intent(this, acceso_cliente.class);
        startActivity(intent);
    }
    private void solicitarPermiso() {
        //Pide el permiso con un cuadro de dialogo del sistema
        ActivityCompat.requestPermissions(this,
                new String[]{Manifest.permission.ACCESS_COARSE_LOCATION}, PERMISO);
    }

}
