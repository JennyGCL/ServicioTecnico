package com.example.crist.serviciotecnico;

import android.app.Activity;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;


public class Wifi  extends AppCompatActivity {
    private Element[] nets;
    private WifiManager manWifi;
    private List<ScanResult> wifiList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        this.manWifi = (WifiManager)
                getApplicationContext().getSystemService(getApplicationContext().WIFI_SERVICE);
        this.manWifi.startScan();
        this.wifiList = this.manWifi.getScanResults();

        this.nets = new Element[wifiList.size()];


        for (int i = 0; i < wifiList.size() ; i++) {
            String item = wifiList.get(i).toString();
            String[]vector_item = item.split(",");
            String item_essid = vector_item[0];
            String item_capabilities = vector_item[2];
            String ssid = item_essid.split(":")[1];
            String security = item_capabilities.split(":")[1];
            nets[i] = new Element(ssid, security);

        }

        setContentView(R.layout.activity_wifi);
        AdapterElements adapter = new AdapterElements (this);
        ListView netlist = (ListView) findViewById(R.id.listView);
        netlist.setAdapter(adapter);




    }
    class AdapterElements extends ArrayAdapter<Object> {
        Activity context;
        public AdapterElements(Activity context){
            super(context, R.layout.items, nets);
            this.context = context;
        }
        public View getView(int position, View convertView, ViewGroup parent){
            LayoutInflater inflater = context.getLayoutInflater();
            View item = inflater.inflate(R.layout.items,null);
            TextView lbltitle =
                    (TextView)item.findViewById(R.id.strssid);
            lbltitle.setText(nets[position].getTitle());

            TextView lblSubtitle =
                    (TextView)item.findViewById(R.id.strsecurity);
            lblSubtitle.setText(nets[position].getSeguridad());
            return item;
        }
    }


}
