package com.example.instagram;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.instagram.Models.Chats;

public class InstagramActivity extends AppCompatActivity {

    EditText nombre, chat, hora;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_instagram);
        InicizalizarControles();
    }
    private void InicizalizarControles(){
        nombre = (EditText)findViewById(R.id.txtNombre);
        chat = (EditText)findViewById(R.id.txtChat1);
        hora = (EditText)findViewById(R.id.txtHora1);

    }
    public void AgregarChat (View view){

        try {
            Chats newChat = new Chats(
                    R.drawable.p1,
                    nombre.getText().toString(),
                    chat.getText().toString(),
                    hora.getText().toString()
            );
            Intent i = new Intent(getApplicationContext(),MainActivity.class);
            i.putExtras(newChat.ChatToBundle());
            startActivity(i);
        }catch(Exception e){

        }
    }
}