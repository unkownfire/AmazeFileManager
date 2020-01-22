package com.amaze.filemanager.database.daos;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.amaze.filemanager.database.models.utilities.List;

import static com.amaze.filemanager.database.UtilitiesDatabase.COLUMN_PATH;
import static com.amaze.filemanager.database.UtilitiesDatabase.TABLE_LIST;

@Dao
public interface ListEntryDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    public void insert(List instance);

    @Update
    public void update(List instance);

    @Query("SELECT " + COLUMN_PATH + " FROM " + TABLE_LIST)
    public String[] listPaths();

    @Query("DELETE FROM " + TABLE_LIST + " WHERE " + COLUMN_PATH + " = :path")
    public void deleteByPath(String path);
}
