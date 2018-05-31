package com.example.ncobb01.hw_ad340.Model;

import com.example.ncobb01.hw_ad340.Model.Matches;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.firebase.database.IgnoreExtraProperties;

@IgnoreExtraProperties
public class Matches implements Parcelable {

    public String uid;
    public String imageUrl;
    public String name;
    public boolean liked;
    public String lat;
    public String longitude;

    public Matches() {

    }


    public static final Creator<Matches> CREATOR = new Creator<Matches>() {

        @Override
        public Matches createFromParcel(Parcel in) {
            return new Matches();
        }

        @Override
        public Matches[] newArray(int size) {
            return new Matches[size];
        }
    };


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(imageUrl);
        dest.writeString(lat);
        dest.writeByte((byte) (liked ? 1 : 0));
        dest.writeString(longitude);
        dest.writeString(name);
        dest.writeString(uid);
    }
}