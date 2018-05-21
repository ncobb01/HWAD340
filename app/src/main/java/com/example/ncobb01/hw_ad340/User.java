package com.example.ncobb01.hw_ad340;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

@Entity
public class User {
    @PrimaryKey
    @NonNull
    private String email = "";
//
//    @ColumnInfo(name = "first_name")
//    private String firstName;


    @ColumnInfo(name = "reminder_time")
    private String reminderTime;

//
//    @ColumnInfo(name = "last_name")
//    private String lastName;


    @ColumnInfo(name = "max_distance")
    private String maxDistance;



//    @ColumnInfo(name = "photo_url")
//    private String photoUrl;


    @ColumnInfo(name = "gender")
   private String gender;


    @ColumnInfo(name = "profile_type")
    private String profileType;


    @ColumnInfo(name = "age_range")
    private String ageRange;





    @NonNull
    public String getEmail() {
        return email;
    }

    public void setEmail(@NonNull String email) {
        this.email = email;
    }

    public String getTime() {
        return reminderTime;
    }

    public void setTime(String reminderTime) {
        this.reminderTime = reminderTime;
    }

    public String getMaxDistance() {
        return maxDistance;
    }

    public void getMaxDistance(String maxDistance) {
        this.maxDistance = maxDistance;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }


    public String getProfileType() {
        return profileType;
    }

    public void setProfileType(String profileType) {
        this.profileType = profileType;
    }


    public String getAgeRange() {
        return ageRange;
    }

    public void setAgeRange(String ageRange) {
        this.ageRange = ageRange;
    }


}