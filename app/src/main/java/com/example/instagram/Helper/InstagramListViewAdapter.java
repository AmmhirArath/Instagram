package com.example.instagram.Helper;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.instagram.Models.Chats;
import com.example.instagram.R;

import java.util.List;

public class InstagramListViewAdapter extends ArrayAdapter<Chats> {
    List<Chats> opciones;
    public InstagramListViewAdapter (Context context, List<Chats> datos){
        super(context, R.layout.listview_layout_template, datos);

        opciones=datos;
    }
    public View getView (int position, View convertView, ViewGroup parent){
        LayoutInflater inflater = LayoutInflater.from(getContext());
        View item = inflater.inflate(R.layout.listview_layout_template,null);

        ImageView foto = (ImageView)item.findViewById(R.id.imvFoto);
        foto.setImageResource(opciones.get(position).getImagen());

        TextView nombre = (TextView)item.findViewById(R.id.txtNombre);
        nombre.setText(opciones.get(position).getNombre());

        TextView chat = (TextView)item.findViewById(R.id.txtChat);
        chat.setText(opciones.get(position).getChat());

        TextView hora = (TextView)item.findViewById(R.id.txtChatHora);
        hora.setText(opciones.get(position).getHora());

        ImageView f = (ImageView)item.findViewById(R.id.imvFoto);
        f.setImageResource(opciones.get(position).getImagen());



        return item;
    }
}