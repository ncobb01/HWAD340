package com.example.ncobb01.hw_ad340;

import android.widget.DatePicker;
import android.app.DatePickerDialog;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import java.util.Calendar;
import java.util.GregorianCalendar;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity  {

    private static final String TAG = MainActivity.class.getSimpleName();

    private Button loginBtn;
    private EditText editTextName;
    private EditText editTextOcc;
    private TextView textView;
    private EditText editTextOcc2;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        loginBtn = findViewById(R.id.loginBtn);
        editTextName = findViewById(R.id.nameEditText);
        editTextOcc = findViewById(R.id.occupationEditText);
        textView = findViewById(R.id.textView);
        editTextOcc2 = findViewById(R.id.occupation2EditText);




        Log.i(TAG, "onCreate()");
    }





    public void goToSecondActivity(View view) throws InterruptedException{
        ageValidate();


        Intent intent = new Intent(MainActivity.this, ConfirmationPage.class);
        intent.putExtra(Constants.KEY_NAME, editTextName.getText().toString());
        intent.putExtra(Constants.KEY_OCCUPATION, editTextOcc.getText().toString());


        intent.putExtra(Constants.KEY_OCCUPATION2, editTextOcc2.getText().toString());
        intent.putExtra(Constants.KEY_AGE, calculateAge());
        startActivity(intent);

    }




    public int calculateAge () {
        DatePicker datePicker = (DatePicker) findViewById(R.id.dp);

        int day = datePicker.getDayOfMonth();
        int month = datePicker.getMonth();
        int year = datePicker.getYear();

        Calendar dob = Calendar.getInstance();
        Calendar today = Calendar.getInstance();

        dob.set(Calendar.DAY_OF_MONTH, day);
        dob.set(Calendar.MONTH, month);
        dob.set(Calendar.YEAR, year);

        long dif = today.getTimeInMillis() - dob.getTimeInMillis();
        Calendar difference = Calendar.getInstance();
        difference.setTimeInMillis(dif);

        int difYear = difference.get(Calendar.YEAR);
        int difMonth = difference.get(Calendar.MONTH);

        int difDays = difference.get(Calendar.DAY_OF_MONTH);

        int age = (difYear + (difMonth + difDays / 30) / 12) - 1970;
        return age;
    }


    public void ageValidate() throws InterruptedException{

        DatePicker datePicker = (DatePicker) findViewById(R.id.dp);

        int day = datePicker.getDayOfMonth();
        int month = datePicker.getMonth();
        int year = datePicker.getYear();

        Calendar dob = Calendar.getInstance();
        Calendar today = Calendar.getInstance();

        dob.set(Calendar.DAY_OF_MONTH, day);
        dob.set(Calendar.MONTH, month);
        dob.set(Calendar.YEAR, year);

        long dif = today.getTimeInMillis() - dob.getTimeInMillis();
        Calendar difference = Calendar.getInstance();
        difference.setTimeInMillis(dif);

        int difYear = difference.get(Calendar.YEAR);
        int difMonth = difference.get(Calendar.MONTH);

        int difDays = difference.get(Calendar.DAY_OF_MONTH);


        int age = (difYear + (difMonth + difDays / 30) / 12) - 1970;

        if (age < 18) {

            Toast.makeText(this, "Users should be 18 years old.", Toast.LENGTH_SHORT).show();


        }



    }




    public void onLogin(View view) {
        loginBtn.setText(R.string.Logout);
        textView.setText(String.format(getString(R.string.Welcome), editTextName.getText()));
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i(TAG, "onRestart()");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i(TAG, "onStart()");
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        Log.i(TAG, "onRestoreInstanceState()");
        if (savedInstanceState.containsKey(Constants.KEY_NAME)) {
            textView.setText((String)savedInstanceState.get(Constants.KEY_NAME));
        }

        if (savedInstanceState.containsKey(Constants.KEY_OCCUPATION)) {
            textView.setText((String)savedInstanceState.get(Constants.KEY_OCCUPATION));
        }




        if (savedInstanceState.containsKey(Constants.KEY_BUTTON_TXT)) {
            loginBtn.setText((String) savedInstanceState.get(Constants.KEY_BUTTON_TXT));
        }


        if (savedInstanceState.containsKey(Constants.KEY_OCCUPATION2)) {
            textView.setText((String)savedInstanceState.get(Constants.KEY_OCCUPATION2));
        }


    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        Log.i(TAG, "onSaveInstanceState()");
        outState.putString(Constants.KEY_NAME, textView.getText().toString());
        outState.putString(Constants.KEY_OCCUPATION, textView.getText().toString());


        outState.putString(Constants.KEY_BUTTON_TXT, loginBtn.getText().toString());


        outState.putString(Constants.KEY_OCCUPATION2, textView.getText().toString());
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i(TAG, "onResume()");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i(TAG, "onPause()");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i(TAG, "onStop()");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(TAG, "onDestroy()");
    }



}