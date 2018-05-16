package com.example.ncobb01.hw_ad340;


import com.google.firebase.auth.FirebaseAuth;

import java.io.Serializable;

public class FirebaseAuthGetter implements Serializable {

    private static FirebaseAuth firebaseAuth;

    public static FirebaseAuth getFirebaseAuth() {
        if(firebaseAuth != null) {
            return firebaseAuth;
        }

        return FirebaseAuth.getInstance();
    }

    public static void setFirebaseAuth(FirebaseAuth firebaseAuthLoc) {
        firebaseAuth = firebaseAuthLoc;
    }
}