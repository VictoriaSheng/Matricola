package com.example.matricola;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.matricola.R;
import com.example.matricola.SearchActivity;
import com.example.matricola.Student;

import java.util.List;

public class MyAdapter extends ArrayAdapter<Student> {
    //devo definire questi due costruttori
    public MyAdapter(Context context, int textViewResourceId) {
        super(context, textViewResourceId);
    }
    public MyAdapter(Context context, int resource, List<Student> items) {
        super(context, resource, items);
    }
//
@Override
public View getView(int position, View convertView, ViewGroup parent) {
    View v = convertView;
    if (v == null) {
        LayoutInflater vi;
        vi = LayoutInflater.from(getContext());
        v = vi.inflate(R.layout.elements, null);
    }
    Student p = getItem(position);
    if (p != null) {
        TextView tt1 = (TextView) v.findViewById(R.id.nome);
        TextView tt2 = (TextView) v.findViewById(R.id.matricola);
        tt1.setText(p.getNome());
        tt2.setText(p.getMatricola());
    }
    return v;
}// End of method (getView) che ritorna la view modificata?
}//End of class (ContactsAdapter)