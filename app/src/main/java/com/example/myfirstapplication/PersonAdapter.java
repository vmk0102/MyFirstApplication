package com.example.myfirstapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
public class PersonAdapter extends BaseAdapter {
    Context context;
    ArrayList<Person> personList;

    public PersonAdapter(Context context, ArrayList<Person> personList) {
        this.context = context;
        this.personList = personList;

    }

    @Override
    public int getCount() {
        return personList.size();
    }

    @Override
    public Person getItem(int position) {
     return personList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        try {

            convertView = LayoutInflater.from(context).inflate(R.layout.person_layout, parent,false);
            TextView firstName = (TextView) convertView.findViewById(R.id.txtlfirstName);
            TextView lastName = (TextView) convertView.findViewById(R.id.txtllastName);
            TextView age = (TextView) convertView.findViewById(R.id.txtlage);
            TextView gender = (TextView) convertView.findViewById(R.id.txtlGender);
            Person p = getItem(position);


            firstName.setText(p.FirstName);
            lastName.setText(p.LastName);
            age.setText(String.valueOf(p.age));
            gender.setText(p.Gender);
            return convertView;
        }catch (Exception e){
            Toast.makeText(context, "Please add some items to the list", Toast.LENGTH_SHORT).show();
        }
        return convertView;
    }
}
