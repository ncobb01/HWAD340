package com.example.ncobb01.hw_ad340;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.Toast;


public class ConfirmationPage extends AppCompatActivity {
    private static final String TAG = ConfirmationPage.class.getSimpleName();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_confirmation_page);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        TabLayout tabLayout = (TabLayout) findViewById(R.id.tab_layout);
        ViewPager viewPager = (ViewPager) findViewById(R.id.pager);

        if (toolbar != null) {
            setSupportActionBar(toolbar);
        }

        viewPager.setAdapter(new SectionPagerAdapter(getSupportFragmentManager()));
        tabLayout.setupWithViewPager(viewPager);





        Intent intent = getIntent();
        Bundle b = intent.getExtras();




        assert b != null;
        if (b.containsKey(Constants.KEY_NAME)) {
            String name = b.getString(Constants.KEY_NAME);

            Log.i(TAG, "Name: " + name);
        }

        if (b.containsKey(Constants.KEY_OCCUPATION)) {
            String occupation = b.getString(Constants.KEY_OCCUPATION);

            Log.i(TAG, "Occupation: " + occupation);
        }

        if (b.containsKey(Constants.KEY_AGE)) {
            int age = b.getInt(Constants.KEY_AGE);

            Log.i(TAG, "Age: " + age);
        }



        if (b.containsKey(Constants.KEY_OCCUPATION2)) {
            String occupation2 = b.getString(Constants.KEY_OCCUPATION2);

            Log.i(TAG, "Occupation2: " + occupation2);
        }





        Log.i(TAG, "onCreate()");





    }
    public class SectionPagerAdapter extends FragmentPagerAdapter {

        public SectionPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 0:
                    return new FragmentA();
                case 1:

                    return new FragmentB();

                case 2:
                default:
                    return new FragmentC();

            }
        }

        @Override
        public int getCount() {
            return 3;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0:
                    return "Profile";
                case 1:

                    return "Matches";

                case 2:
                default:
                    return "Settings";
            }
        }
    }

}