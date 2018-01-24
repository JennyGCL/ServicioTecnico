package com.example.crist.serviciotecnico;
import android.content.DialogInterface;
import android.os.Environment;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.webkit.WebView;
import android.widget.Adapter;
import android.widget.EditText;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.Socket;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class chat_cliente extends AppCompatActivity {
    private Socket socket = null;
    private DataOutputStream out = null;
    private String mensaje = null;
    private EscuchadorMensajes escuchador = null;
    private EditText cajaTexto = null;
    private RecyclerView rvChatList;
    private List<String> dataset = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat_cliente);
        rvChatList = findViewById(R.id.rv_chat);
        try {
            socket = new Socket("172.20.0.166",50000);
            out = new DataOutputStream(socket.getOutputStream());
            escuchador = new EscuchadorMensajes(rvChatList, socket);
            escuchador.start();
        } catch (IOException ex) {

        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_cliente, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        AlertDialog alert;
        AlertDialog.Builder dialog;

        switch (item.getItemId()) {
            case R.id.descargar:
                final String[] items = {"Samsung Galaxy S8", "Samsung Galaxy S7", "Samsung Galaxy S8"};
                dialog = new AlertDialog.Builder(this);
                dialog.setTitle("Manuales")
                        .setItems(items, new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int item) {
                                Log.i("Dialogos", "Opción elegida: " + items[item]);
                                if (item == 0) {
                                    try {
                                        URL url = new URL("http://org.downloadcenter.samsung.com/downloadfile/ContentsFile.aspx?CDSite=UNI_ES&CttFileID=6943797&CDCttType=UM&ModelType=N&ModelName=SM-G950F&VPath=UM/201711/20171115142241613/SM-G95X_UM_Open_Nougat_Spa_Rev.1.2_171018.pdf&OriginYN=N");
                                        //establecemos la conexión con el destino
                                        HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();

                                        //establecemos el método get para nuestra conexión
                                        //el método setdooutput es necesario para este tipo de conexiones
                                        urlConnection.setRequestMethod("GET");
                                        urlConnection.setDoOutput(true);

                                        //por último establecemos nuestra conexión y cruzamos los dedos 😛
                                        urlConnection.connect();

                                        //vamos a establecer la ruta de destino para nuestra descarga
                                        //para hacerlo sencillo en este ejemplo he decidido descargar en
                                        //la raíz de la tarjeta SD
                                        File SDCardRoot = Environment.getExternalStorageDirectory();

                                        //vamos a crear un objeto del tipo de fichero
                                        //donde descargaremos nuestro fichero, debemos darle el nombre que
                                        //queramos, si quisieramos hacer esto mas completo
                                        //cogeríamos el nombre del origen
                                        File file = new File(SDCardRoot,"SM-G95X_UM_Open_Nougat_Spa_Rev.1.2_171018.pdf");

                                        //utilizaremos un objeto del tipo fileoutputstream
                                        //para escribir el archivo que descargamos en el nuevo
                                        FileOutputStream fileOutput = new FileOutputStream(file);

                                        //leemos los datos desde la url
                                        InputStream inputStream = urlConnection.getInputStream();

                                        //creamos un buffer y una variable para ir almacenando el
                                        //tamaño temporal de este
                                        byte[] buffer = new byte[1024];
                                        int bufferLength = 0;

                                        //ahora iremos recorriendo el buffer para escribir el archivo de destino
                                        //siempre teniendo constancia de la cantidad descargada y el total del tamaño
                                        //con esto podremos crear una barra de progreso
                                        while ( (bufferLength = inputStream.read(buffer)) > 0 ) {

                                            fileOutput.write(buffer, 0, bufferLength);

                                        }
                                        //cerramos
                                        fileOutput.close();
                                    } catch (MalformedURLException e) {
                                        e.printStackTrace();
                                    } catch (IOException e) {
                                        e.printStackTrace();
                                    }
                                }
                            }

                        });

                dialog.setPositiveButton("Volver", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialogInterface, int i) {

                        dialogInterface.cancel();
                    }
                });

                alert = dialog.create();
                alert.show();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

}
