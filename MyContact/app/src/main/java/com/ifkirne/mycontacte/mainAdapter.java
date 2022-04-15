package com.ifkirne.mycontacte;



import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupMenu;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.ifkirne.mycontacte.entities.Appdatabase;
import com.ifkirne.mycontacte.entities.contact;
import com.ifkirne.mycontacte.entities.contactDao;


import java.util.List;

public class mainAdapter extends RecyclerView.Adapter<mainViewHolder> {

    private List<contact> contacts;
    private Context context;

    public mainAdapter(List<contact> contacts, Context context) {
        this.contacts = contacts;
        this.context = context;
    }




    @NonNull
    @Override
    public mainViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new mainViewHolder(LayoutInflater.from(context).inflate(R.layout.activity_itemcontact,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull mainViewHolder holder,  int position) {
               holder.nom.setText(contacts.get(position).nom);
               holder.tele.setText(contacts.get(position).phone);

               if(contacts.get(position).genre.equals("Homme")){
                     holder.img.setImageResource(R.drawable.homme);
               }else{
                   holder.img.setImageResource(R.drawable.femme);
               }

               holder.itemView.setOnClickListener((evt)->{
                   Intent callintent=new Intent(Intent.ACTION_CALL);
                   callintent.setData(Uri.parse("tel:"+String.valueOf(contacts.get(position).phone)));
                   context.startActivity(callintent);
               });

               holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
                   @Override
                   public boolean onLongClick(View view) {
                       PopupMenu popupMenu=new PopupMenu(context,view);
                       popupMenu.getMenu().add("Delete");
                       popupMenu.getMenu().add("Rename");
                       popupMenu.getMenu().add("Move");

                       popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {

                           @Override
                           public boolean onMenuItemClick(MenuItem menuItem) {
                               if(menuItem.getTitle().equals("Delete")){
                                   RoomDatabase.Builder<Appdatabase> db= Room.databaseBuilder(context,Appdatabase.class,"contact").allowMainThreadQueries();
                                   contactDao contactDao=db.build().contactDao();
                                    contactDao.delete(contacts.get(position));
                                     notifyItemRemoved(position);
                               }
                               if(menuItem.getTitle().equals("Rename")){

                               }
                               if(menuItem.getTitle().equals("Move")){

                               }
                               return true;
                           }
                       });
                       popupMenu.show();
                       return true;
                   }
               });
    }

    @Override
    public int getItemCount() {
        return contacts.size();
    }
}
