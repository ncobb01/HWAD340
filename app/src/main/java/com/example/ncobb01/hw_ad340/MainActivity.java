package com.example.ncobb01.hw_ad340;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.DatePicker;
import android.support.v4.app.DialogFragment;


public class MainActivity extends AppCompatActivity  {

    private static final String TAG = MainActivity.class.getSimpleName();

    private Button loginBtn;
    private EditText name;
    private TextView textView;
    private EditText username;
    private EditText age;
    private DatePicker birthDate;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        loginBtn = findViewById(R.id.form_submit);


        name = findViewById(R.id.form_name);
        username = findViewById(R.id.form_username);
        age = findViewById(R.id.form_age);
        birthDate = findViewById(R.id.dp);

            Log.i(TAG, "onCreate()");


        loginBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, ConfirmationPage.class));
            }
        });
    }


    public void goToSecondActivity(View view) {


        Intent intent = new Intent(MainActivity.this, ConfirmationPage.class);
        intent.putExtra(Constants.KEY_NAME, username.getText().toString());
        startActivity(intent);
        finish();
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

        if (savedInstanceState.containsKey(Constants.KEY_BUTTON_TXT)) {
            loginBtn.setText((String) savedInstanceState.get(Constants.KEY_BUTTON_TXT));
        }
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        Log.i(TAG, "onSaveInstanceState()");
        outState.putString(Constants.KEY_NAME, textView.getText().toString());
        outState.putString(Constants.KEY_BUTTON_TXT, loginBtn.getText().toString());
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