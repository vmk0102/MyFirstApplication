package com.example.myfirstapplication;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.text.Editable;
import android.text.method.KeyListener;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class secondActivity extends AppCompatActivity {
    ListView lv;
    Button btn;
    Button viewButton;
    EditText firstName;
    EditText lastName;
    EditText Gender;
    EditText Age;
    Button btnDelete;
    Button btnUpdate;

    int updatePosition;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        lv=(ListView) findViewById(R.id.names);
        btn=(Button)findViewById(R.id.btnadd);
        firstName=(EditText)findViewById(R.id.etNames);
        lastName=(EditText)findViewById(R.id.lastName);
        Gender=(EditText)findViewById(R.id.gender);
        Age=(EditText)findViewById(R.id.txtage);
        btnDelete=(Button) findViewById(R.id.btndelete);
        btnUpdate=(Button)findViewById(R.id.btnUpdate);
        viewButton=(Button)findViewById(R.id.btnView);
        ArrayList<Person> persons =  new ArrayList<Person>();
        PersonAdapter listAdapter = new PersonAdapter(secondActivity.this, persons);

        /* Creating database */
        SQLiteDatabase db= openOrCreateDatabase("Records",MODE_PRIVATE,null);
        db.execSQL("CREATE TABLE IF NOT EXISTS person(ID integer primary key autoincrement,FirstName varchar(100),LastName varchar(100),Gender varchar(6),age int)");
        lv.setAdapter(listAdapter);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                /*String[] s = names.get(position).toString().split("\n");
                firstName.setText(s[0]);
                lastName.setText(s[1]);
                Gender.setText(s[2]);
                Age.setText(s[3]);
                updatePosition=position;*/
            }
        });

        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = persons.size()-1;
                persons.remove(position);
                listAdapter.notifyDataSetChanged();

            }
        });

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Person p = new Person();
                p.FirstName=firstName.getText().toString();
                p.LastName=lastName.getText().toString();
                p.Gender=Gender.getText().toString();
                p.age=Integer.valueOf(Age.getText().toString());
                db.execSQL("INSERT INTO person(firstname,lastname,gender,age) values" +
                        "('"+p.FirstName+"','"+p.LastName+"','"+p.Gender+"',"+p.age+")");

                persons.add(p);

                listAdapter.notifyDataSetChanged();
                firstName.setText("");
                lastName.setText("");
                Gender.setText("");
                Age.setText("");


            }
        });
      /*  btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Person p = new Person();
                p.FirstName=firstName.getText().toString();
                p.LastName=lastName.getText().toString();
                p.Gender=Gender.getText().toString();
                p.age=Integer.valueOf(Age.getText().toString());
                names.set(updatePosition,p.toString());
                listAdapter.notifyDataSetChanged();

            }
        });*/
        viewButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                db.close();
                Intent i = new Intent(secondActivity.this,viewPersons.class);
                startActivity(i);
                finish();
            }
        });






    }
}