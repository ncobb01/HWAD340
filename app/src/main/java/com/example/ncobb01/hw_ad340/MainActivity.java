package com.example.ncobb01.hw_ad340;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button btnlogin;
    private EditText age;
    private EditText birthDate;
    private EditText username;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        LoginButton();
    }


    public void LoginButton(){
        btnlogin = (Button) findViewById(R.id.btnlogin);
        age = (EditText) findViewById(R.id.age);
       birthDate = (EditText) findViewById(R.id.birthDate);
       birthDate = (EditText) findViewById(R.id.username);


    }







}
