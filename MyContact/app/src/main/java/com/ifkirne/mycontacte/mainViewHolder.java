package com.ifkirne.mycontacte;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

public class mainViewHolder extends RecyclerView.ViewHolder {
     public TextView nom;
     public TextView tele;
     public CardView cardView;
     public ImageView img;

    public mainViewHolder(@NonNull View itemView) {
        super(itemView);
        this.nom = itemView.findViewById(R.id.Name);
        this.tele = itemView.findViewById(R.id.tele);
        this.cardView = itemView.findViewById(R.id.dirCard);
        this.img = itemView.findViewById(R.id.img);
    }
}
