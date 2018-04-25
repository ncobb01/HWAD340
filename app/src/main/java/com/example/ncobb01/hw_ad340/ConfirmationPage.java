package com.example.ncobb01.hw_ad340;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

public class ConfirmationPage extends AppCompatActivity {

    private static final String TAG = ConfirmationPage.class.getSimpleName();
    TextView textView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_confirmation_page);



        textView = findViewById(R.id.textView);

        StringBuilder msg = new StringBuilder("");
        Intent intent = getIntent();
        Bundle b = intent.getExtras();

        assert b != null;
        if (b.containsKey(Constants.KEY_NAME)) {
            String name = b.getString(Constants.KEY_NAME);
            msg.append(name).append("\n");
            Log.i(TAG, "Name: " + name);
        }

        if (b.containsKey(Constants.KEY_OCCUPATION)) {
            String occupation = b.getString(Constants.KEY_OCCUPATION);
            msg.append(occupation).append("\n");
            Log.i(TAG, "Occupation: " + occupation);
        }

        if (b.containsKey(Constants.KEY_AGE)) {
            int age = b.getInt(Constants.KEY_AGE);
            msg.append(age).append(" years old \n\n");
            Log.i(TAG, "Age: " + age);
        }



        if (b.containsKey(Constants.KEY_OCCUPATION2)) {
            String occupation2 = b.getString(Constants.KEY_OCCUPATION2);
            msg.append(occupation2).append("\n");
            Log.i(TAG, "Occupation2: " + occupation2);
        }



        textView.setText(msg);

        Log.i(TAG, "onCreate()");
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


