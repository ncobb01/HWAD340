package com.example.ncobb01.hw_ad340;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.app.Activity;

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


        btnlogin = (Button) findViewById(R.id.form_submit);

        btnlogin.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                startActivity(new Intent(MainActivity.this, ConfirmationPage.class));
            }
        });




        age = (EditText) findViewById(R.id.form_age);
       birthDate = (EditText) findViewById(R.id.form_dob);
       username = (EditText) findViewById(R.id.form_username);

        //mText.setText("Welcome "+mEdit.getText().toString()+"!");

//
//        btnlogin.setOnClickListener(new View.OnClickListener() {
//
//            public void onClick( new View.OnClickListener)
//                                    }
//
//            LoginButtonClick(); }


//            public void LoginButtonClick() {
//
//        int ageInfo = age;
//
//        if birthDate < 18 {
//            String tooYoung = jObj.getString("Users must be at least 18 years old.");
//            }
//        else

           // Move user to completion page

            }
        }