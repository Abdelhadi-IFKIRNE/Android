package com.ifkirne.manupulation_listview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private List<itemclass> data=new ArrayList<>();
    private ListView listView;
    private ImageButton btnCall;
    private model model;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView=findViewById(R.id.listItem);
        btnCall=findViewById(R.id.call);
        model=new model(getApplicationContext(),R.layout.itemlist,data);
        listView.setAdapter(model);
         filldata(data);
    }

    public String readfile(){
        String json=null;
        try {
            InputStream jsonFile=getAssets().open("jsonFile.json");
             int size=jsonFile.available();
             byte[] buffer =new byte[size];
             jsonFile.read(buffer);
             jsonFile.close();
             json=new String(buffer,"UTF-8");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return json;
    }

    public void filldata(List<itemclass> data){
        try {
            JSONObject jsonObject=new JSONObject(readfile());
            JSONArray jsonArray=jsonObject.getJSONArray("contacts");
            for (int i = 0; i <jsonArray.length() ; i++) {
                itemclass itemclass=new itemclass();
                JSONObject jsonObject1=jsonArray.getJSONObject(i);
                itemclass.firstname=jsonObject1.getString("first_name");
                itemclass.job=jsonObject1.getString("job");
                itemclass.phone=jsonObject1.getString("phone");
                data.add(itemclass);
            }
            model.notifyDataSetChanged();
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}