package com.example.myfirstapplication;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    Button btnClickMe;
    TextView hello;
    EditText txtName;
    EditText txtEmail;
    CheckBox cbRemember;
    SharedPreferences mypref;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnClickMe=(Button) findViewById(R.id.btnClick);

        txtName=(EditText)findViewById(R.id.editTextText);
        txtEmail=(EditText)findViewById(R.id.editTextText2);

        mypref=this.getSharedPreferences("profile",MODE_PRIVATE);

        txtEmail.setText(mypref.getString("myEmail",""));
        txtName.setText(mypref.getString("myName",""));
        cbRemember=(CheckBox)findViewById(R.id.cbRemember);
        btnClickMe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*hello.setText("I AM WALI. Welcome to my class");
                Toast.makeText(MainActivity.this,"My First android app. YAYYY!",Toast.LENGTH_LONG).show()*/;
                String Email = txtEmail.getText().toString();
                String Name= txtName.getText().toString();
                Intent intent = new Intent(MainActivity.this,secondActivity.class);
                intent.putExtra("NameData",Name);
                intent.putExtra("EmailData",Email);
                if (cbRemember.isChecked()){
                    mypref.edit().putString("myEmail",Email).apply();
                    mypref.edit().putString("myName",Name).apply();

                }
                 startActivity(intent);
            }
        });
        /*cbRemember.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(cbRemember.isChecked()){
                    Toast.makeText(MainActivity.this, "mein hogaya check", Toast.LENGTH_SHORT).show();
                }
                else if(!cbRemember.isChecked()){
                    Toast.makeText(MainActivity.this, "Mera check hut gaya", Toast.LENGTH_SHORT).show();
                }
            }
        });*/
    }


}