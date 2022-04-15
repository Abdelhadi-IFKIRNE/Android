package com.ifkirne.mycontacte;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.ifkirne.mycontacte.entities.Appdatabase;
import com.ifkirne.mycontacte.entities.contact;
import com.ifkirne.mycontacte.entities.contactDao;

public class formAdd extends AppCompatActivity {
      private EditText nom;
      private EditText phone;
      private EditText genre;
      private ImageButton btnsave;
      private ImageButton btnHome;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_add);

        nom=findViewById(R.id.nom);
        phone=findViewById(R.id.tele);
        genre=findViewById(R.id.genre);
        btnsave=findViewById(R.id.save);
        btnHome=findViewById(R.id.home);
        RoomDatabase.Builder<Appdatabase> db= Room.databaseBuilder(getApplicationContext(),Appdatabase.class,"contact").allowMainThreadQueries();
        contactDao contactDao=db.build().contactDao();
        btnsave.setOnClickListener((evt)->{
            contact contact=new contact(nom.getText().toString(),phone.getText().toString(),genre.getText().toString());
            contactDao.insert(contact);
            clean(nom,phone,genre);
            Toast.makeText(getApplicationContext(),"le contact a été ajouté",Toast.LENGTH_LONG).show();
        });

        btnHome.setOnClickListener((evt)->{
            Intent intent=new Intent(getApplicationContext(),MainActivity.class);
            startActivity(intent);
        });

    }

    public  void clean(TextView nom, TextView tele, TextView genre){
        nom.setText("");
        tele.setText("");
        genre.setText("");
    }
}