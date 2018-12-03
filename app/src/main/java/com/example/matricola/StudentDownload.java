package com.example.matricola;

import android.os.AsyncTask;
import android.widget.TextView;
import android.widget.Toast;

import com.example.matricola.MyModel;
import com.example.matricola.R;
import com.example.matricola.Student;

import java.util.ArrayList;

public class StudentDownload extends AsyncTask<Void, Void, ArrayList<Student>> {

    @Override
    protected ArrayList<Student> doInBackground(Void... voids) {
        ArrayList<Student> scaricati=new ArrayList<Student>();
        MyModel m=MyModel.getMyModel();
        scaricati=m.getStudentFromServer("download");
        return scaricati;
    }

    //per creare il context devo passsarlo come oggetto dall'adapter
    protected void onPostExecute() {

    }
}
