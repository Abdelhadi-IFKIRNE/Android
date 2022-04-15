package com.ifkirne.mycontacte.entities;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface contactDao {
    @Query("SELECT * FROM contact")
    List<contact> getAll();
    @Insert
    void insert(contact contact);
    @Delete
    void delete(contact contact);
}
