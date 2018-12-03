package com.example.matricola;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class AddActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
    }

    public void add(View view) {
        //creo istanza delmodel
        MyModel m = MyModel.getMyModel();
        //creo lo studente da inserire
        String nome = ((EditText)findViewById(R.id.name)).getText().toString();
        String cognome = ((EditText)findViewById(R.id.surname)).getText().toString();
        String matricola = ((EditText)findViewById(R.id.matricola)).getText().toString();
        //cast EditText perchè getText si può usare solo con istanze di EditText
        Student s=new Student(nome,cognome, matricola);
        m.addStudente(s);//aggiungo il nuovo studente all'Array

        Log.d("msg", "studente inserito");
        Intent intent=new Intent(this, MainActivity.class);//l'intent crea il collegamento alla prima pagina
        startActivity(intent);//inizia l'activity
    }


}
