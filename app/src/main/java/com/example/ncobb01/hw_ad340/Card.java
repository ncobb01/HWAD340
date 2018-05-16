package com.example.ncobb01.hw_ad340;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class Card {
    private String imgURL;
    private String title;

//    public Card(String imgURL, String title) {
//        this.imgURL = imgURL;
//        this.title = title;



        public String getImgURL () {
            return imgURL;
        }

        public void setImgURL (String imgURL){
            this.imgURL = imgURL;
        }

        public String getTitle () {
            return title;
        }

        public void setTitle (String title){
            this.title = title;
        }


    }

