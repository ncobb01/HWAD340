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
import android.widget.DatePicker;



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

        btnlogin.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, ConfirmationPage.class));
            }
        });



        age = (EditText) findViewById(R.id.form_age);
       birthDate = (EditText) findViewById(R.id.form_dob);
       username = (EditText) findViewById(R.id.form_username);

       Intent i = new Intent(MainActivity.this, ConfirmationPage.class);


        Bundle bundle = new Bundle();

        bundle.putString("USERNAME", username.getText().toString());

        i.putExtras(bundle);
        startActivity(i);





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



    public static class DatePickerFragment extends AppCompatActivity
            implements DatePickerDialog.OnDateSetListener {

        @Override
        public Dialog onCreateDialog(Bundle savedInstanceState) {
            // Use the current date as the default date in the picker
            final Calendar c = Calendar.getInstance();
            int year = c.get(Calendar.YEAR);
            int month = c.get(Calendar.MONTH);
            int day = c.get(Calendar.DAY_OF_MONTH);

            // Create a new instance of DatePickerDialog and return it
            return new DatePickerDialog(getActivity(), this, year, month, day);
        }

        public void onDateSet(DatePicker view, int year, int month, int day) {
            // Do something with the date chosen by the user
        }
    }


    public void showDatePickerDialog(View v) {
        DialogFragment newFragment = new DatePickerFragment();
        newFragment.show(getSupportFragmentManager(), "datePicker");
    }
        }