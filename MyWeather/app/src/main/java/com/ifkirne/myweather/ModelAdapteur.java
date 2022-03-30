package com.ifkirne.myweather;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ModelAdapteur extends ArrayAdapter {
   private List<WeatherClass> weatherClassList;
   private int ressource;

    private static Map<String,Integer> images=new HashMap<>();

    static {
        images.put("Clear",R.drawable.clear);
        images.put("Clouds",R.drawable.cloud);
        images.put("Rain",R.drawable.rain);
    }


    public ModelAdapteur(Context context,int ressource,List<WeatherClass> data){
        super(context,ressource,data);
        this.ressource=ressource;
        this.weatherClassList=data;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View item=convertView;
        if(item==null)
            item= LayoutInflater.from(getContext()).inflate(ressource,parent,false);
        TextView date=item.findViewById(R.id.textdate);
        TextView Tmin=item.findViewById(R.id.textViewtempMin);
        TextView Tmax=item.findViewById(R.id.textViewtempMax);
        TextView Pression=item.findViewById(R.id.textViewPression);
        TextView humidite=item.findViewById(R.id.textViewHumidite);
        ImageView image=item.findViewById(R.id.image);
        String imageWeather=weatherClassList.get(position).image;
        if(imageWeather!=null)
            image.setImageResource(images.get(imageWeather));
            date.setText(String.valueOf(weatherClassList.get(position).date));
            Tmin.setText(String.valueOf(weatherClassList.get(position).Tmin));
            Tmax.setText(String.valueOf(weatherClassList.get(position).Tmax));
            Pression.setText(String.valueOf(weatherClassList.get(position).Pression));
            humidite.setText(String.valueOf(weatherClassList.get(position).humidite));
        return item;
    }
}
