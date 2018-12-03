package com.example.matricola;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    //servono per ablitare il volley e serve creare le relative classi
   //private RequestQueue mRequestQueue;
    //private StringRequest mStringRequest;
    private String url = "http://www.mocky.io/v2/597c41390f0000d002f4dbd1";
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //identifico il bottone
        //Bottone ricerca collegato alla view

    }
    public void aggiungi(View v) {
        Intent intent=new Intent(MainActivity.this,AddActivity.class);//creo l'intent per colleare la classe NuovaMatricola
        startActivity(intent);
    }

    public void cerca(View view) {
        Intent intent=new Intent(MainActivity.this,SearchActivity.class);
        startActivity(intent);//creo l'intent per colleare la classe NuovaMatricola
    }
    public void elenco(View view) {
        Intent intent=new Intent(MainActivity.this,DisplayActivity.class);
        startActivity(intent);//creo l'intent per colleare la classe NuovaMatricola
    }





    /* public void scarica(final View view) {

       Thread thread = new Thread(new Runnable() {
            @Override
            public void run(){
                //richiamo il metodo creato sopra per creare una lista nel nuovo thread
                final List<Student> scolari= getStudentFromServer("download ok");
                View testo = findViewById(R.id.textView2);
                final boolean post = testo.post(new Runnable() {
                    public void run() {
                        Log.d("dowload","download completato");

                    }
                });
            }
        });*/
    }




