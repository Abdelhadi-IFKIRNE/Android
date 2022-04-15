package com.ifkirne.mycontacte.entities;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {contact.class},version = 2)
public abstract class Appdatabase extends RoomDatabase {
    public abstract contactDao contactDao();
}
