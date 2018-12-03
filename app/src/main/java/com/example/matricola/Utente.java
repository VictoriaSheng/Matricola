package com.example.matricola;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class Utente extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.elements);

        Intent i=getIntent();
        String nome=(String)i.getSerializableExtra("nome");
        String matricola=(String)i.getSerializableExtra("matricola");

        TextView name=(TextView)findViewById(R.id.nome);
        name.setText(nome);

        TextView matrix=(TextView)findViewById(R.id.matricola);
        matrix.setText(matricola);

        // public void name(View view){String nome = ((EditText)findViewById(R.id.name)).getText().toString();}
        // public void matricola(View view){String matricola = ((EditText)findViewById(R.id.matricola)).getText().toString();}
    }

}
