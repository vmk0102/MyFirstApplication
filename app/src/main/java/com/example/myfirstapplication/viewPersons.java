package com.example.myfirstapplication;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class viewPersons extends AppCompatActivity {
    ListView lvPersons;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_view_persons);
        lvPersons=(ListView)findViewById(R.id.lvView);
        SQLiteDatabase db = openOrCreateDatabase("Records",MODE_PRIVATE,null);
        Cursor c = db.rawQuery("select FirstName,LastName,age,gender from person",null);
        c.moveToFirst();
        ArrayList<Person> persons = new ArrayList<>();
        while(c.moveToNext()){
            Person p = new Person();
            p.FirstName=c.getString(0);
            p.LastName=c.getString(1);
            p.age=c.getInt(2);
            p.Gender=c.getString(3);
            persons.add(p);
        }
        c.close();
        db.close();
        PersonAdapter adapter = new PersonAdapter(viewPersons.this,persons);
        lvPersons.setAdapter(adapter);
    }
}