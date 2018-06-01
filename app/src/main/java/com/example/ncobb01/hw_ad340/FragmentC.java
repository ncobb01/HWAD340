package com.example.ncobb01.hw_ad340;


import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;
import com.example.ncobb01.hw_ad340.Entity.Settings;
import java.lang.ref.WeakReference;
import java.util.List;

public class FragmentC extends Fragment {

    public Spinner minute, hour, isAfternoon, radius,  rangeLow, rangeHigh, sexuality, gender;
    public TextView settingsError;
    public Switch privacy;
    public Button save;
    public ArrayAdapter genderAdapter;
    public ArrayAdapter hourAdapter;
    public ArrayAdapter minuteAdapter;
    public ArrayAdapter isAfternoonAdapter;
    public ArrayAdapter radiusAdapter;
    public ArrayAdapter sexualityAdapter;
    public ArrayAdapter rangeLowAdapter;
    public ArrayAdapter rangeHighAdapter;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View SettingsView = inflater.inflate(R.layout.fragment_c, container, false);


        gender = SettingsView.findViewById(R.id.gender);
        hour = SettingsView.findViewById(R.id.hour);
        minute = SettingsView.findViewById(R.id.minute);
        isAfternoon = SettingsView.findViewById(R.id.isAfternoon);
        radius = SettingsView.findViewById(R.id.radius);
        sexuality = SettingsView.findViewById(R.id.sexuality);
        rangeLow = SettingsView.findViewById(R.id.rangeLow);
        rangeHigh = SettingsView.findViewById(R.id.rangeHigh);
        privacy = SettingsView.findViewById(R.id.privacy);
        save = SettingsView.findViewById(R.id.save);
        settingsError = SettingsView.findViewById(R.id.settingsError);

        genderAdapter = ArrayAdapter.createFromResource(getActivity(), R.array.gender, R.layout.simple_dropdown_textview);
        genderAdapter.setDropDownViewResource(R.layout.simple_dropdown_textview);
        gender.setAdapter(genderAdapter);

        hourAdapter = ArrayAdapter.createFromResource(getActivity(), R.array.hours, R.layout.simple_dropdown_textview);
        hourAdapter.setDropDownViewResource(R.layout.simple_dropdown_textview);
        hour.setAdapter(hourAdapter);

        minuteAdapter = ArrayAdapter.createFromResource(getActivity(), R.array.minutes, R.layout.simple_dropdown_textview);
        minuteAdapter.setDropDownViewResource(R.layout.simple_dropdown_textview);
        minute.setAdapter(minuteAdapter);

        isAfternoonAdapter = ArrayAdapter.createFromResource(getActivity(), R.array.isAfternoon, R.layout.simple_dropdown_textview);
        isAfternoonAdapter.setDropDownViewResource(R.layout.simple_dropdown_textview);
        isAfternoon.setAdapter(isAfternoonAdapter);

        radiusAdapter = ArrayAdapter.createFromResource(getActivity(), R.array.radius, R.layout.simple_dropdown_textview);
        radiusAdapter.setDropDownViewResource(R.layout.simple_dropdown_textview);
        radius.setAdapter(radiusAdapter);

        sexualityAdapter = ArrayAdapter.createFromResource(getActivity(), R.array.sexuality, R.layout.simple_dropdown_textview);
        sexualityAdapter.setDropDownViewResource(R.layout.simple_dropdown_textview);
        sexuality.setAdapter(sexualityAdapter);

        rangeLowAdapter = ArrayAdapter.createFromResource(getActivity(), R.array.minAge, R.layout.simple_dropdown_textview);
        rangeLowAdapter.setDropDownViewResource(R.layout.simple_dropdown_textview);
        rangeLow.setAdapter(rangeLowAdapter);

        rangeHighAdapter = ArrayAdapter.createFromResource(getActivity(), R.array.maxAge, R.layout.simple_dropdown_textview);
        rangeHighAdapter.setDropDownViewResource(R.layout.simple_dropdown_textview);
        rangeHigh.setAdapter(rangeHighAdapter);


        save.setOnClickListener(v -> {

            int low = getIntValue(rangeLow);



//            int high = getIntValue(rangeHigh);

            if(low > 17) {
                settingsError.setText("");
                updateDatabase(v);
                Toast.makeText(getActivity(), "Thanks for saving.",
                        Toast.LENGTH_SHORT).show();
            }else {
                settingsError.setText(R.string.invalidRange);
            }
        });

        new GetSettings(this,0).execute();

        return SettingsView;
    }

    public void updateDatabase(View view) {
        Settings newSettings = new Settings();

        int hour = Integer.parseInt((String)this.hour.getSelectedItem());
        int minute = Integer.parseInt((String)this.minute.getSelectedItem());
        int radius = Integer.parseInt((String)this.radius.getSelectedItem());
        int rangeLow = Integer.parseInt((String)this.rangeLow.getSelectedItem());
        int rangeHigh = Integer.parseInt((String)this.rangeHigh.getSelectedItem());

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

//    public static int getIndex(Spinner spinner, String myString){
//        for (int i=0;i<spinner.getCount();i++){
//            if (spinner.getItemAtPosition(i).toString().equalsIgnoreCase(myString)){
//                return i;
//            }
//        }
//
//        return 0;
//    }

//    public static int getIndex(Spinner spinner, int myInt){
//        for (int i=0;i<spinner.getCount();i++){
//            if (spinner.getItemAtPosition(i).equals(myInt)){
//                return i;
//            }
//        }
//
//        return 0;
//    }

    public static int getIntValue(Spinner mySpinner) {
        int value = Integer.parseInt((String)mySpinner.getSelectedItem());
        return value;
    }

//    public static String getStringValue(Spinner mySpinner) {
//        String value = mySpinner.getSelectedItem().toString();
//        return value;
//    }

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

            AppDatabase db = AppDatabaseSingleton.getDatabase(fragment.getActivity());

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

            fragment.gender.setSelection(fragment.genderAdapter.getPosition(settings.getGender()));
            fragment.hour.setSelection(fragment.hourAdapter.getPosition("" + settings.getHour()));
            fragment.minute.setSelection(fragment.minuteAdapter.getPosition("" + settings.getMinute()));
            fragment.isAfternoon.setSelection(fragment.isAfternoonAdapter.getPosition(settings.isAfternoon() ? "PM" : "AM"));
            fragment.radius.setSelection(fragment.radiusAdapter.getPosition("" + settings.getRadius()));
            fragment.sexuality.setSelection(fragment.sexualityAdapter.getPosition("" + settings.getSexuality()));
            fragment.rangeLow.setSelection(fragment.rangeLowAdapter.getPosition("" + settings.getRangeLow()));
            fragment.rangeHigh.setSelection(fragment.rangeHighAdapter.getPosition("" + settings.getRangeHigh()));
            fragment.privacy.setChecked(settings.isPrivacy());

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

            db.settingsDao().insertAll(settings);
            return settings;
        }
    }


}

