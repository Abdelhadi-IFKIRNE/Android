package com.ifkirne.manupulation_listview;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class model extends ArrayAdapter {
    private Context context; private int ressource; private List<itemclass> data;

    public model(Context context, int ressource, List<itemclass> data){
        super(context,ressource,data);
        this.context=context;
        this.ressource=ressource;
        this.data=data;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View item=convertView;
        if(convertView==null)
            item= LayoutInflater.from(context).inflate(ressource,parent,false);
            TextView fistname=item.findViewById(R.id.fistname);
            TextView job=item.findViewById(R.id.job);
            TextView phone=item.findViewById(R.id.phone);
            ImageButton btnok=item.findViewById(R.id.call);
            fistname.setText(String.valueOf(data.get(position).firstname));
            job.setText(String.valueOf(data.get(position).job));
            phone.setText(String.valueOf(data.get(position).phone));
        btnok.setOnClickListener((evt)->{
            Intent callintent=new Intent(Intent.ACTION_CALL);
            callintent.setData(Uri.parse("tel:"+String.valueOf(data.get(position).phone)));
            context.startActivity(callintent);
        });
           return  item;
    }
}
