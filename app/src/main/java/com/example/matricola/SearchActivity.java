package com.example.matricola;

import android.content.Intent;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.Response.ErrorListener;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.android.volley.toolbox.StringRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.BreakIterator;
import java.util.ArrayList;

public class SearchActivity extends AppCompatActivity {
    private TextView mTextViewResult;
    private RequestQueue mQueue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        //creamolo nell'on create https://www.youtube.com/watch?v=y2xtLqP8dSQ
        Button buttonServer=findViewById(R.id.cercaServer);



        buttonServer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                jsonParse();
            }
        });

    }
    //metodo richiamato
    private void jsonParse(){
        String testo= ((EditText)findViewById(R.id.cerca)).getText().toString();
        String url="https://ewserver.di.unimi.it/mobicomp/exercises/getstudent.php?id="+testo;
        mQueue=Volley.newRequestQueue(this);
       final MyModel m = MyModel.getMyModel();

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest
                (Request.Method.GET, url, null, new Response.Listener<JSONObject>() {

                    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
                    @Override
                    public void onResponse(JSONObject response) {
                        TextView mTextView=(TextView) findViewById(R.id.scaricati);
                        mTextView.setText("Response: " + response.toString());
                        String result="";
                        try {
                            String nome1 = response.getString("name");
                            String cognome1 = response.getString("surname");
                            String matricola1 = response.getString("id");
                            Student s=new Student(nome1,cognome1, matricola1);
                            if(!m.existMatricola(matricola1)) {
                                m.addStudente(s);
                                result += "studente inserito: " + nome1 + " " + cognome1 + " " + matricola1;
                            }else{
                                result += "studente già inserito";
                            }

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }


                        Log.d("tag","ok ci siamo" );
                        Toast.makeText(getApplicationContext(),result, Toast.LENGTH_LONG).show();
                    }
                }, new Response.ErrorListener() {

                    @Override
                    public void onErrorResponse(VolleyError error) {
                        // TODO: Handle error
                        Log.d("tag","errore non va bene" );

                    }
                });
        mQueue.add(jsonObjectRequest);

    }


     public void cerca(View view){
         String testo= ((EditText)findViewById(R.id.cerca)).getText().toString();
         //se è un codice vuol dire che cerco in base alla matricola altrimenti in base al nome/cognome
         MyModel m = MyModel.getMyModel();

         ArrayList<String> result=new ArrayList<String>();
         result=m.FromTesto(testo);

         ListView output=(ListView) findViewById(R.id.textView);
         ArrayAdapter<String> myAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, result);
         output.setAdapter(myAdapter);
     }
}
