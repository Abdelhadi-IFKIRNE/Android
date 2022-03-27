package com.ifkirne.myweather;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;

import java.util.List;

public class MainActivity extends AppCompatActivity {
     private ImageButton btnOk;
     private EditText cityName;
     private ListView listItems;
     private List<WeatherClass> data;
     private ModelAdapteur modelAdapteur;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
         btnOk=findViewById(R.id.btnOk);
         cityName=findViewById(R.id.editTextCityName);
         listItems=findViewById(R.id.listMeteo);
        modelAdapteur=new ModelAdapteur(getApplicationContext(),R.layout.itemlist,data);
        listItems.setAdapter(modelAdapteur);


    }
}