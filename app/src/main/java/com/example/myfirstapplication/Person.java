package com.example.myfirstapplication;

import androidx.annotation.NonNull;

public class Person {
    String FirstName;
    String LastName;
    String Gender;
    int age;


    @NonNull
    @Override
    public String toString(){
        return FirstName.toString()+"\n"+LastName.toString()+"\n"+Gender+"\n"+age;
    }
}
