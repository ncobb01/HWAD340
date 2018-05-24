package com.example.ncobb01.hw_ad340;


import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;

import com.example.ncobb01.hw_ad340.Entity.Settings;


import java.lang.ref.WeakReference;
import java.util.List;

public class FragmentC extends Fragment {

    public Spinner minute, hour, isAfternoon, radius,  rangeLow, rangeHigh, sexuality, gender;
    public TextView settingsError;
    public Switch privacy;
    public Button save;



    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View SettingsView = inflater.inflate(R.layout.fragment_c, container, false);

        hour = SettingsView.findViewById(R.id.hour);
        minute = SettingsView.findViewById(R.id.minute);
        isAfternoon = SettingsView.findViewById(R.id.isAfternoon);
        radius = SettingsView.findViewById(R.id.radius);
        sexuality = SettingsView.findViewById(R.id.sexuality);
        gender = SettingsView.findViewById(R.id.gender);
        rangeLow = SettingsView.findViewById(R.id.rangeLow);
        rangeHigh = SettingsView.findViewById(R.id.rangeHigh);
        privacy = SettingsView.findViewById(R.id.privacy);
        save = SettingsView.findViewById(R.id.save);
        settingsError = SettingsView.findViewById(R.id.settingsError);

        save.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {

                int low = getIntValue(rangeLow);
                int high = getIntValue(rangeHigh);

                if(low < high) {
                    settingsError.setText("");
                    updateDatabase(v);
                }else {
                    settingsError.setText("Bad Range");
                }
            }
        });

        new GetSettings(this,0).execute();

        return SettingsView;
    }

    public void updateDatabase(View view) {
        Settings newSettings = new Settings();

        int hour = (int) this.hour.getSelectedItem();
        int minute = (int) this.minute.getSelectedItem();
        int radius = (int) this.radius.getSelectedItem();
        int rangeLow = (int) this.rangeLow.getSelectedItem();
        int rangeHigh = (int) this.rangeHigh.getSelectedItem();

        boolean isAfternoon;
        if (this.isAfternoon.getSelectedItem() == "PM") {
            isAfternoon = true;
        }else {
            isAfternoon = false;
        }
        boolean privacy = this.privacy.isChecked();

        String sexuality = (String) this.sexuality.getSelectedItem();
        String gender = (String) this.gender.getSelectedItem();

        newSettings.setId(0);
        newSettings.setHour(hour);
        newSettings.setMinute(minute);
        newSettings.setRadius(radius);
        newSettings.setRangeLow(rangeLow);
        newSettings.setRangeHigh(rangeHigh);
        newSettings.setAfternoon(isAfternoon);
        newSettings.setPrivacy(privacy);
        newSettings.setSexuality(sexuality);
        newSettings.setGender(gender);

        new UpdateSettings(this, newSettings).execute();
    }

    public static int getIndex(Spinner spinner, String myString){
        for (int i=0;i<spinner.getCount();i++){
            if (spinner.getItemAtPosition(i).toString().equalsIgnoreCase(myString)){
                return i;
            }
        }

        return 0;
    }

    public static int getIndex(Spinner spinner, int myInt){
        for (int i=0;i<spinner.getCount();i++){
            if (spinner.getItemAtPosition(i).equals(myInt)){
                return i;
            }
        }

        return 0;
    }

    public static int getIntValue(Spinner mySpinner) {
        int value = (int) mySpinner.getSelectedItem();
        return value;
    }

    public static String getStringValue(Spinner mySpinner) {
        String value = mySpinner.getSelectedItem().toString();
        return value;
    }

    private static class GetSettings extends AsyncTask<Void, Void, Settings> {
        private WeakReference<Fragment> weakFragment;
        private int id;

        public GetSettings(Fragment fragment, int id){
            weakFragment = new WeakReference<>(fragment);
            this.id = id;
        }

        @Override
        protected Settings doInBackground(Void... voids){
            Fragment fragment = weakFragment.get();
            if(fragment == null){
                return null;
            }

            AppDatabase db = AppDatabaseSingleton.getDatabase(fragment.getContext());

            List<Settings> settings = db.settingsDao().getSettingsById(id);

            if(settings.size() <= 0 || settings.get(0) == null){
                return null;
            }

            return settings.get(0);
        }

        @Override
        protected void onPostExecute(Settings settings) {
            FragmentC fragment = (FragmentC) weakFragment.get();
            if(settings == null || fragment == null) {
                return;
            }
            fragment.hour.setSelection(getIndex(fragment.hour,settings.getHour()));
            fragment.minute.setSelection(getIndex(fragment.minute,settings.getMinute()));
            fragment.isAfternoon.setSelected(settings.isAfternoon());
            fragment.radius.setSelection(getIndex(fragment.isAfternoon,settings.getRadius()));
            fragment.sexuality.setSelection(getIndex( fragment.sexuality,settings.getSexuality()));
            fragment.gender.setSelection(getIndex(fragment.gender,settings.getGender()));
            fragment.rangeLow.setSelection(getIndex(fragment.rangeLow,settings.getRangeLow()));
            fragment.rangeHigh.setSelection(getIndex(fragment.rangeHigh,settings.getRangeHigh()));
            fragment.privacy.setSelected(settings.isPrivacy());
        }
    }

    private static class UpdateSettings extends AsyncTask<Void,Void,Settings> {
        private WeakReference<Fragment> weakFragment;
        private Settings settings;

        public UpdateSettings(Fragment fragment, Settings settings) {
            weakFragment = new WeakReference<>(fragment);
            this.settings = settings;
        }

        @Override
        protected Settings doInBackground(Void... voids) {
            Fragment fragment = weakFragment.get();
            if(fragment == null) {
                return null;
            }

            AppDatabase db = AppDatabaseSingleton.getDatabase(fragment.getContext());

            db.settingsDao().updateSettings(settings);
            return settings;
        }

        @Override
        protected void onPostExecute(Settings settings) {
            FragmentC fragment = (FragmentC) weakFragment.get();
            if(settings == null || fragment == null) {
                return;
            }

            fragment.hour.setSelection(getIndex(fragment.hour,settings.getHour()));
            fragment.minute.setSelection(getIndex(fragment.minute,settings.getMinute()));
            fragment.isAfternoon.setSelected(settings.isAfternoon());
            fragment.radius.setSelection(getIndex(fragment.isAfternoon,settings.getRadius()));
            fragment.sexuality.setSelection(getIndex( fragment.sexuality,settings.getSexuality()));
            fragment.gender.setSelection(getIndex(fragment.gender,settings.getGender()));
            fragment.rangeLow.setSelection(getIndex(fragment.rangeLow,settings.getRangeLow()));
            fragment.rangeHigh.setSelection(getIndex(fragment.rangeHigh,settings.getRangeHigh()));
            fragment.privacy.setSelected(settings.isPrivacy());

        }
    }


}

