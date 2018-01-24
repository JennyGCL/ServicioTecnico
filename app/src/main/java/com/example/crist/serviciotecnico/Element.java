package com.example.crist.serviciotecnico;


public class Element {
    private String ssid;
    private String seguridad
            ;

    public Element(String t, String s){
        this.ssid=t;
        this.seguridad =s;
    }

    public String getTitle(){
        return this.ssid;
    }

    public String getSeguridad(){
        return this.seguridad;
    }
}
