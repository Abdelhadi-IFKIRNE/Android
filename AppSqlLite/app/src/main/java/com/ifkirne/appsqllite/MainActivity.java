package com.ifkirne.appsqllite;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
      private TextView id;
      private TextView name;
      private Button btnsave;
      private ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        id=findViewById(R.id.ID);
        name=findViewById(R.id.name);
        btnsave=findViewById(R.id.save);
        listView=findViewById(R.id.listItem);
        List<TextView> listString=new ArrayList<>();
        dbConnexion db=new dbConnexion(getApplicationContext());
        SQLiteDatabase sqLiteDatabase=db.getWritableDatabase();
        btnsave.setOnClickListener((evt)->{
            ContentValues values=new ContentValues();
            values.put("id",Integer.parseInt(id.getText().toString()));
            values.put("name",name.getText().toString());
            sqLiteDatabase.insert("admin",null,values);
            TextView textView=new TextView(getApplicationContext());
            textView.setText(id.getText().toString()+"--"+name.getText().toString());
            ArrayAdapter adapter=new ArrayAdapter(getApplicationContext(),R.layout.itemslist,listString);
            listString.add(textView);
            listView.setAdapter(adapter);
            adapter.notifyDataSetChanged();

        });
    }
}