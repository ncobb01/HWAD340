package com.example.ncobb01.hw_ad340.Model;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.HashMap;
import java.util.Map;
import com.google.firebase.database.Exclude;
import com.google.firebase.database.IgnoreExtraProperties;



@IgnoreExtraProperties
public class Matches implements Parcelable {

    public String matchId;
    public String matchImageURL;
    public Boolean liked;
    public String named;


    public Matches() {

    }

    public Matches (String mId, String mURL, String mNamed, Boolean mLiked){
        this.matchId = mId;
        this.matchImageURL = mURL;
        this.liked = mLiked;
        this.named = mNamed;

    }

    public Matches(Parcel in) {
        matchImageURL = in.readString();
        liked = in.readByte() != 0;
        named = in.readString();
        matchId = in.readString();

    }

    public static final Creator<Matches> CREATOR = new Creator<Matches>() {

        @Override
        public Matches createFromParcel(Parcel in) {
            return new Matches(in);
        }

        @Override
        public Matches[] newArray(int size) {
            return new Matches[size];
        }
    };

    @Exclude
    public Map<String, Object> toMap() {
        HashMap<String, Object> result = new HashMap<>();
        result.put("matchId", matchId);
        result.put("named", named);
        result.put("liked", liked);
        result.put("matchImageURL", matchImageURL);

        return result;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(matchImageURL);
        dest.writeByte((byte) (liked ? 1 : 0));
        dest.writeString(named);
        dest.writeString(matchId);
    }
}