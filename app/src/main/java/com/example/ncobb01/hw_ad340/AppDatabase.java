package com.example.ncobb01.hw_ad340;



    import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

    import com.example.ncobb01.hw_ad340.Entity.Settings;
    import com.example.ncobb01.hw_ad340.Dao.settingsDao;

@Database(entities = {Settings.class}, version = 1)
    public abstract class AppDatabase extends RoomDatabase {
        public abstract settingsDao settingsDao();
}
