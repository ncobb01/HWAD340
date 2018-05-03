package com.example.ncobb01.hw_ad340;


import android.support.v4.app.Fragment;
import android.content.Intent;

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
    String mParam1;


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Log.i(TAG, "onAttach()");
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);





        if (getArguments() != null) {
            mParam1 = getArguments().getString("params");


            TextView t = (TextView) getView().findViewById(R.id.msg1);
            t.setText(mParam1);

        }
    }



//
//    public static FragmentA newInstance(String valueToPass) {
//
//        FragmentA f = new FragmentA();
//
//        Bundle b = new Bundle();
//        b.putString("key", valueToPass);
//        f.setArguments(b);
//
//        return f;
//    }






    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        Log.i(TAG, "onCreate()");



       View view = inflater.inflate(R.layout.fragment_a, container, false);
        TextView output= (TextView)view.findViewById(R.id.msg1);
        output.setText("Fragment One");
        return view;




       // return inflater.inflate(R.layout.fragment_a, container, false);




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