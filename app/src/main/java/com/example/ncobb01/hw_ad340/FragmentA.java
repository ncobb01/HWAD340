package com.example.ncobb01.hw_ad340;


import android.support.v4.app.Fragment;
import android.content.Intent;
import android.widget.EditText;
import android.widget.TextView;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;


public class FragmentA extends Fragment {

    private static final String TAG = FragmentA.class.getSimpleName();
//    String mParam1;


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Log.i(TAG, "onAttach()");
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }




    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        Log.i(TAG, "onCreate()");



        View view = inflater.inflate(R.layout.fragment_a, container, false);

        Bundle extras = getActivity().getIntent().getExtras();
        String message = extras.getString(Constants.KEY_NAME);
        Integer message2 = extras.getInt(Constants.KEY_AGE);
        String message3 = extras.getString(Constants.KEY_OCCUPATION);
        String message4 = extras.getString(Constants.KEY_OCCUPATION2);
        TextView textViewTab1 = view.findViewById(R.id.msg1);
        textViewTab1.setText(message + ("\n") + ("\n") + message2  + ("\n") + message3 + ("\n") + message4);


        return view;



    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Log.i(TAG, "onActivityCreated()");
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.i(TAG, "onStart()");
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.i(TAG, "onResume()");
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.i(TAG, "onPause()");
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.i(TAG, "onStop()");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.i(TAG, "onDestroyView()");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.i(TAG, "onDestroy()");
    }

    @Override
    public void onDetach() {
        super.onDetach();
        Log.i(TAG, "onDetach()");
    }

}