package com.example.ncobb01.hw_ad340.Dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import  com.example.ncobb01.hw_ad340.Entity.Settings;

import java.util.List;

@Dao
public interface settingsDao {
    @Query( "SELECT * FROM Settings WHERE id = :mId")
    List<Settings> getSettingsById(int mId);

    @Update
    void updateSettings(Settings... settings);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAll(Settings... settings);

    @Delete
    void delete(Settings... settings);

}
