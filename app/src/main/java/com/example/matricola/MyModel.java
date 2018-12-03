package com.example.matricola;

import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class MyModel{
        private static MyModel instance = null;
        //Il costruttore private impedisce l'istanza di oggetti da parte di
        //classi esterne
        private ArrayList<Student> students=new ArrayList<Student>();
        private MyModel() {}
        public ArrayList<Student> studenti(){
            ArrayList<Student> result=new ArrayList<>();
            for(int i=0;i<students.size();i++){
                result.add(students.get(i));
            }
            return result;
        }


        // Metodo della classe impiegato per accedere al singleton
        public static synchronized MyModel getMyModel() {
            if (instance == null) {
                instance = new MyModel();
            }
            return instance;
        }

        public void addStudente(Student s){
           students.add(s);
        }

    public ArrayList<String> FromTesto(String s){
        ArrayList<String> lista=new ArrayList<String>();
        for(int i=0;i<students.size();i++){
            if(students.get(i).getMatricola().contains(s) || students.get(i).getNome().contains(s) || students.get(i).getCognome().contains(s)){
                lista.add(students.get(i).getString());
            }
        }
        return lista;
    }

    public boolean existMatricola(String s){
        for(int i=0;i<students.size();i++){
            if(students.get(i).getMatricola().equals(s)){
                return true;
            }
        }
        return false;
    }


    public ArrayList<String> getElenco(){
        ArrayList<String> lista=new ArrayList<String>();
        for(int i=0;i<students.size();i++){
                lista.add(students.get(i).getString());
        }
        return lista;
    }

   public ArrayList<Student> getStudentFromServer(String url){
        Log.d("Fake request", "Getting data from: " + url);
        students.add(new Student("Andrea", "Andrei", "111"));
        students.add(new Student("Bruno", "Bruni", "222"));
        students.add(new Student("Carlo", "Carli", "333"));
        students.add(new Student("Diego", "Dieghi", "444"));
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return students;
    }


}
//MyModel model1=MyModel.getIstance()
