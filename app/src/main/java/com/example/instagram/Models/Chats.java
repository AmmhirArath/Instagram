package com.example.instagram.Models;

import android.os.Bundle;

import com.example.instagram.R;

public class Chats {
    private int imagen;
    private String Nombre;
    private String Chat;
    private String Hora;

    public Chats(){

    }
    public Chats(int f, String nombre, String chat, String hora) {
        imagen=f;
        Nombre = nombre;
        Chat = chat;
        Hora = hora;
    }
    public int getImagen() {
        return imagen;
    }

    public void setImagen(int imagen) {
        this.imagen = imagen;
    }
    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getChat() {
        return Chat;
    }

    public void setChat(String chat) {
        Chat = chat;
    }

    public String getHora() {
        return Hora;
    }

    public void setHora(String hora) {
        Hora = hora;
    }

    public Bundle ChatToBundle(){
        Bundle b = new Bundle();
        b.putString("nombre",this.getNombre());
        b.putString("chat",this.getChat());
        b.putString("hora","Hace "+this.getHora()+"h");

        return b;
    }

    public Chats restoreBundle(Bundle b){
        return new Chats(
                R.drawable.p1,
                b.getString("nombre"),
                b.getString("chat"),
                b.getString("hora")

        );
    }

}
