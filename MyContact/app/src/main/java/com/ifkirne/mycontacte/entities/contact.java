package com.ifkirne.mycontacte.entities;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class contact {
    @PrimaryKey(autoGenerate = true)
    public int id;
    public String nom;
    public String phone;
    public String genre;

    public contact() {
    }

    public contact(String nom, String phone, String genre) {
        this.nom = nom;
        this.phone = phone;
        this.genre = genre;
    }


}
