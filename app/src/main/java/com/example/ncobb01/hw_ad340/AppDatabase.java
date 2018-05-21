package com.example.ncobb01.hw_ad340;



    import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import com.example.ncobb01.hw_ad340.UserDao;
import com.example.ncobb01.hw_ad340.User;

    @Database(entities = {User.class}, version = 3)
    public abstract class AppDatabase extends RoomDatabase {
        public abstract UserDao userDao();
}
