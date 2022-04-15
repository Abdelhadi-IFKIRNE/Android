package com.ifkirne.mycontacte;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.ifkirne.mycontacte.entities.Appdatabase;
import com.ifkirne.mycontacte.entities.contact;
import com.ifkirne.mycontacte.entities.contactDao;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class MainActivity extends AppCompatActivity {
     private List<contact> contactList=new ArrayList<>();
     private RecyclerView recyclerView;
     private ImageButton btnAdd;
    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       recyclerView=findViewById(R.id.rcContacts);
       btnAdd=findViewById(R.id.add);


       RoomDatabase.Builder<Appdatabase> db= Room.databaseBuilder(getApplicationContext(),Appdatabase.class,"contact").allowMainThreadQueries();
       contactDao contactDao=db.build().contactDao();

       contactList=contactDao.getAll();
     recyclerView.setLayoutManager(new GridLayoutManager(this,3));
     recyclerView.setAdapter(new mainAdapter(contactList,getApplicationContext()));
     btnAdd.setOnClickListener((evt)->{
         Intent  intent=new Intent(getApplicationContext(),formAdd.class);
         startActivity(intent);
     });

    }

}