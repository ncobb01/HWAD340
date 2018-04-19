package com.example.ncobb01.hw_ad340;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;
import android.view.View;

public class ConfirmationPage extends AppCompatActivity {

    private static final String TAG = ConfirmationPage.class.getSimpleName();
    TextView textView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirmation_page);
        //textView = findViewById(R.id.textView);

        StringBuilder msg = new StringBuilder("Hello \n");
        Intent intent = getIntent();
        Bundle b = intent.getExtras();

        assert b != null;
        if (b.containsKey(Constants.KEY_NAME)) {
            String name = b.getString(Constants.KEY_NAME);
            msg.append(name).append("\n");
            Log.i(TAG, "Username: " + name);
        }


//        if (b.containsKey(Constants.KEY_AGE)) {
//            int age = b.getInt(Constants.KEY_AGE);
//            msg.append(age).append(" years old");
//            Log.i(TAG, "Age: " + age);
//        }

        textView.setText(msg);

        Log.i(TAG, "onCreate()");
    }

    public void goToFirstActivity(View view) {


        Intent intent = new Intent(ConfirmationPage.this, MainActivity.class );

        startActivity(intent);
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