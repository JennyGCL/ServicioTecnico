package com.example.crist.serviciotecnico;

import android.os.AsyncTask;
import android.os.HandlerThread;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by Crist on 15/01/2018.
 */

public class ServidorHilo extends Thread {
    private ServerSocket servidor;
    private boolean finalizar;

    public ServidorHilo(ServerSocket servidor) {
        this.servidor = servidor;
        finalizar = false;
    }

    public ServerSocket getServidor() {
        return servidor;
    }

    public void setServidor(ServerSocket servidor) {
        this.servidor = servidor;
    }

    public boolean isFinalizar() {
        return finalizar;
    }

    public void setFinalizar(boolean finalizar) {
        this.finalizar = finalizar;
    }

    @Override
    public void run() {

            try  {
                while (!finalizar) {
                    Socket cliente = servidor.accept();
                    ClienteHilo hiloCliente = new ClienteHilo(cliente);
                    hiloCliente.start();
                }
                servidor.close();
            } catch (IOException e) {
                e.printStackTrace();
            }


    }
}
