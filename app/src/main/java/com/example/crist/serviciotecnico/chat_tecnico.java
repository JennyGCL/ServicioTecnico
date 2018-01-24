package com.example.crist.serviciotecnico;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.io.IOException;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.zip.Inflater;

public class chat_tecnico extends AppCompatActivity {
    EditText txtTecnico;
    EditText txtCliente;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat_tecnico);
        /*crearServidor();*/

        /*DisplayMetrics metrics = new DisplayMetrics();

        /*LinearLayout lay = findViewById(R.id.linearLayout);
        int ancho, alto, filas;
        filas= 10;
        ancho = metrics.widthPixels - 75;
        alto = 100;
        for (int i=0; i < filas; i++){
            txtTecnico = new EditText(this);

            txtTecnico.setLayoutParams(new ViewGroup.LayoutParams(ancho, alto));
            txtTecnico.setText("Mensaje "+i);
        }*/


    }

/*
    private void crearServidor(){
        try {
            ServerSocket servidor = new ServerSocket(50000);
            Socket socketCliente = servidor.accept();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_tecnico, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int seleccion = item.getItemId();

        switch (seleccion){
            case R.id.obtenerIP:
                Toast toast = Toast.makeText(this, "Direccion IP: "+getIP(), Toast.LENGTH_LONG);
                toast.show();

                break;
        }


        return super.onOptionsItemSelected(item);
    }


    public static String getIP(){
        List<InetAddress> addrs;
        String address = "";
        try{
            List<NetworkInterface> interfaces = Collections.list(NetworkInterface.getNetworkInterfaces());
            for(NetworkInterface intf : interfaces){
                addrs = Collections.list(intf.getInetAddresses());
                for(InetAddress addr : addrs){
                    if(!addr.isLoopbackAddress() && addr instanceof Inet4Address){
                        address = addr.getHostAddress().toUpperCase(new Locale("es", "ES"));
                    }
                }
            }
        }catch (Exception e){

        }
        return address;
    }*/
}
