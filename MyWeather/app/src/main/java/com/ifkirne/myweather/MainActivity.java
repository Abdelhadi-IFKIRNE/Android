package com.ifkirne.myweather;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MainActivity extends AppCompatActivity {
     private ImageButton btnOk;
     private EditText cityName;
     private ListView listItems;
     private List<WeatherClass> data=new ArrayList<>();
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

        RequestQueue queue= Volley.newRequestQueue(getApplicationContext());

        btnOk.setOnClickListener((evt)->{
            data.clear();
            modelAdapteur.notifyDataSetChanged();
            String Ville=cityName.getText().toString();
            String url="";
            StringRequest stringRequest=new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {
                    try {
                        JSONObject jsonObject = new JSONObject(response);
                        JSONArray jsonArray = jsonObject.getJSONArray("list");
                        for (int i = 0; i < jsonArray.length(); i++) {
                            WeatherClass weatherClass = new WeatherClass();
                            JSONObject jsonObjectOfArray = jsonArray.getJSONObject(i);
                            Date date = new Date(jsonObjectOfArray.getLong("dt") * 1000);
                            SimpleDateFormat sdf = new SimpleDateFormat("dd/mmm/yyyy");
                            weatherClass.date = sdf.format(date);
                            JSONObject main = jsonObjectOfArray.getJSONObject("main");
                            weatherClass.Tmax = (int) (main.getDouble("temp_max") - 273.15);
                            weatherClass.Tmin = (int) (main.getDouble("temp_min") - 273.15);
                            weatherClass.Pression = (int) (main.getDouble("pressure"));
                            weatherClass.humidite = main.getInt("humidity");
                            JSONArray jsonArrayofArray = jsonObjectOfArray.getJSONArray("weather");
                            weatherClass.image = jsonArrayofArray.getJSONObject(0).getString("main");
                            data.add(weatherClass);
                        }
                        modelAdapteur.notifyDataSetChanged();
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    Log.i("i","Problème de connexion !!");
                }
            });
            queue.add(stringRequest);
        });
    }
}