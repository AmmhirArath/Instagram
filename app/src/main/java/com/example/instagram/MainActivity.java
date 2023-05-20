package com.example.instagram;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.instagram.Helper.InstagramListViewAdapter;
import com.example.instagram.Models.Chats;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    InstagramListViewAdapter adapterComp;
    ListView lstChats;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lstChats = (ListView)findViewById(R.id.lstChatsIg) ;
        //Adapter sencillo
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                getApplicationContext(),
                android.R.layout.simple_list_item_1,
                LlenarListViewSimple()
        );
        //Adapter Complejo

        Bundle b = getIntent().getExtras();
        if(b!=null){

            Chats chat = new Chats().restoreBundle(b);
            List<Chats> chats = LlenarListViewCompuesto();
            chats.add(chat);
            adapterComp = new InstagramListViewAdapter(
                    getApplicationContext(),
                    chats
            );
        }else{
            adapterComp = new InstagramListViewAdapter (
                    getApplicationContext(),
                    LlenarListViewCompuesto()
            );
        }

        lstChats.setAdapter(adapterComp);
    }
    //Llenar ListView de forma simple.
    private List<String> LlenarListViewSimple(){
        List<String> chats = new ArrayList<String>();
        chats.add("Cristobal Colón");
        chats.add("Diomedez Diaz");
        chats.add("Cristofer Robin");

        return chats;
    }
    //Llenar List View de forma compleja.
    private List<Chats> LlenarListViewCompuesto(){
        List<Chats> chats = new ArrayList<Chats>();
        chats.add(new Chats( R.drawable.p1,"Ammhir","No estoy","Hace 1h"));
        chats.add(new Chats( R.drawable.p2,"Cristofer","Hola","Hace 2h"));
        chats.add(new Chats( R.drawable.p3,"Ramiro","Habla","Hace 4h"));
        chats.add(new Chats( R.drawable.p4,"Lucia","Ramiro no vino","Hace 5h"));
        return chats;
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu,menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        if(item.getItemId()==R.id.miNew){
            Intent i = new Intent(getApplicationContext(), InstagramActivity.class);
            startActivity(i);
        }
        else{
            Toast.makeText(this, "Opción no habilitada",Toast.LENGTH_SHORT).show();
        }
        return super.onOptionsItemSelected(item);
    }
}