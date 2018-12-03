package com.example.matricola;

public class Student {
    private String nome;
    private String cognome;
    private String matricola;

    public Student(String n, String c,String matricola ){
        this.nome=n;
        this.cognome=c;
        this.matricola=matricola;
    }
    public String getNome(){
        return nome;
    }
    public String getCognome(){
        return cognome;
    }
    public String getMatricola(){
        return matricola;
    }
    public String getString(){
        return nome+" "+cognome+" "+matricola;
    }




}

