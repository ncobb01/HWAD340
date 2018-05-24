package com.example.ncobb01.hw_ad340.Entity;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;




    @Entity
    public class Settings {
        @PrimaryKey
        @NonNull
        private int id = 0;

        @ColumnInfo(name = "hour")
        private int hour;

        @ColumnInfo(name = "minute")
        private int minute;

        @ColumnInfo(name = "afternoon")
        private boolean afternoon;

        @ColumnInfo(name = "radius")
        private int radius;

        @ColumnInfo(name = "sexuality")
        private String sexuality;

        @ColumnInfo(name = "gender")
        private String gender;

        @ColumnInfo(name = "rangeLow")
        private int rangeLow;

        @ColumnInfo(name = "rangeHigh")
        private int rangeHigh;

        @ColumnInfo(name = "privacy")
        private boolean privacy;

        @NonNull
        public int getId() {
            return id;
        }

        public void setId(@NonNull int id) {
            this.id = id;
        }

        public int getHour() {
            return hour;
        }

        public void setHour(int hour) {
            this.hour = hour;
        }

        public int getMinute() {
            return minute;
        }

        public void setMinute(int minute) {
            this.minute = minute;
        }

        public boolean isAfternoon() {
            return afternoon;
        }

        public void setAfternoon(boolean afternoon) {
            this.afternoon = afternoon;
        }

        public int getRadius() {
            return radius;
        }

        public void setRadius(int radius) {
            this.radius = radius;
        }

        public String getSexuality() {
            return sexuality;
        }

        public void setSexuality(String sexuality) {
            this.sexuality = sexuality;
        }

        public String getGender() {
            return gender;
        }

        public void setGender(String gender) {
            this.gender = gender;
        }

        public int getRangeLow() {
            return rangeLow;
        }

        public void setRangeLow(int rangeLow) {
            this.rangeLow = rangeLow;
        }

        public int getRangeHigh() {
            return rangeHigh;
        }

        public void setRangeHigh(int rangeHigh) {
            this.rangeHigh = rangeHigh;
        }

        public boolean isPrivacy() {
            return privacy;
        }

        public void setPrivacy(boolean privacy) {
            this.privacy = privacy;
        }
    }

