package com.example.matricola;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class DisplayActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);
        MyModel m = MyModel.getMyModel();
        final ArrayList<Student> results = m.studenti();
        final ListView output = (ListView) findViewById(R.id.lista);
        //per cliccabilità

        final MyAdapter myAdapter = new MyAdapter(this, android.R.layout.list_content, results);
        output.setAdapter(myAdapter);
        output.setOnItemClickListener(
                new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                        Student c = results.get(i);
                        Log.d("ItemClickistener", c.getNome() + ": " + c.getMatricola());
                        //fino a qui funziona
                       // startActivity(new Intent(DisplayActivity.this,Utente.class))
                        Intent intent=new Intent(DisplayActivity.this, Utente.class);
                        intent.putExtra("nome",c.getNome());
                        intent.putExtra("matricola",c.getMatricola());
                        startActivity(intent);

                    }
                }
        );

    }
}
