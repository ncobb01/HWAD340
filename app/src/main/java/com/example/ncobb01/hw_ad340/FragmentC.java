package com.example.ncobb01.hw_ad340;

import android.os.AsyncTask;
import android.support.v4.app.Fragment;
import android.content.Intent;
import android.app.Activity;
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
import java.lang.ref.WeakReference;
import java.util.Objects;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;


public class FragmentC extends Fragment {

    private static final String TAG = FragmentA.class.getSimpleName();

    public TextView email;
    public TextView reminderTime;
    public TextView maxDistance;
    public TextView gender;
    public TextView profileType;
    public TextView ageRange;


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Log.i(TAG, "onAttach()");
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        email = findViewById(R.id.email);
        displayName = findViewById(R.id.displayName);
        photoUrl = findViewById(R.id.photoUrl);

        new GetUserTask(this, "test@gmail.com").execute();
    }


    public void updateDatabase(View view) {
        User fakeNewUser = new User();
        String email = this.email.getText().toString();
        if(email.equals("")) {
            email = "fakeuser@google.com";
        }
        fakeNewUser.setEmail(email);
        fakeNewUser.setReminderTime("12pm");
        fakeNewUser.setMaxDistance("20");
        fakeNewUser.setGender("Male");
        fakeNewUser.setProfileType("Public");
        fakeNewUser.setAgeRange("20-45");

        new UpdateUserTask(this, fakeNewUser).execute();
    }


    @Override
    protected User doInBackground(Void... voids) {
        Activity activity = weakActivity.get();
        if(activity == null) {
            return null;
        }

        AppDatabase db = AppDatabaseSingleton.getDatabase(activity.getApplicationContext());

        db.userDao().delete(user);
        return user;
    }









    @Override
    protected void onPostExecute(User user) {
        FragmentC activity = (FragmentC) weakActivity.get();
        if(user == null || activity == null) {
            return;
        }

        activity.email.setText("");
        activity.reminderTime.setText("");
        activity.maxDistance.setText("");
        activity.gender.setText("");
        activity.profileType.setText("");
        activity.ageRange.setText("");
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





    private static class UpdateUserTask extends AsyncTask<Void, Void, User> {

        private WeakReference<Activity> weakActivity;
        private User user;

        public UpdateUserTask(Activity activity, User user) {
            weakActivity = new WeakReference<>(activity);
            this.user = user;
        }

        @Override
        protected User doInBackground(Void... voids) {
            Activity activity = weakActivity.get();
            if(activity == null) {
                return null;
            }


            AppDatabase db = AppDatabaseSingleton.getDatabase(activity.getApplicationContext());

            db.userDao().updateUsers(user);
            return user;
        }

        @Override
        protected void onPostExecute(User user) {
            RoomPersistenceExampleActivity activity = (RoomPersistenceExampleActivity) weakActivity.get();
            if(user == null || activity == null) {
                return;
            }

            activity.email.setText(user.getEmail());
            activity.displayName.setText(String.format("%s %s", user.getFirstName(), user.getLastName()));
            activity.photoUrl.setText(user.getPhotoUrl());
        }
    }

    private static class GetUserTask extends AsyncTask<Void, Void, User> {

        private WeakReference<Activity> weakActivity;
        private String userEmail;

        public GetUserTask(Activity activity, String userEmail) {
            weakActivity = new WeakReference<>(activity);
            this.userEmail = userEmail;
        }

        @Override
        protected User doInBackground(Void... voids) {
            Activity activity = weakActivity.get();
            if(activity == null) {
                return null;
            }

            AppDatabase db = AppDatabaseSingleton.getDatabase(activity.getApplicationContext());

            String[] emails = { userEmail };

            List<User> users = db.userDao().loadAllByIds(emails);

            if(users.size() <= 0 || users.get(0) == null) {
                return null;
            }
            return users.get(0);
        }

        @Override
        protected void onPostExecute(User user) {
            RoomPersistenceExampleActivity activity = (RoomPersistenceExampleActivity) weakActivity.get();
            if(user == null || activity == null) {
                return;
            }

            activity.email.setText(user.getEmail());
            activity.displayName.setText(String.format("%s %s", user.getFirstName(), user.getLastName()));
            activity.photoUrl.setText(user.getPhotoUrl());
        }
    }
}

