package com.example.crist.serviciotecnico;

import java.io.DataInputStream;
import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

/**
 * Created by Crist on 15/01/2018.
 */

public class ClienteHilo extends Thread{
    private Socket cliente;

    public ClienteHilo(Socket cliente) {
        this.cliente = cliente;
    }

    @Override
    public void run() {
        try {
            DataOutputStream out = new DataOutputStream(cliente.getOutputStream());
            DataInputStream in = new DataInputStream(cliente.getInputStream());

            String mensajeCliente = "", mensaje="";
            while(!mensajeCliente.equals("SUPERCALIFRAGILISTICO")){
                mensajeCliente = in.readUTF();

            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
