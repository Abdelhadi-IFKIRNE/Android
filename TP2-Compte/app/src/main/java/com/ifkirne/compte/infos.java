package com.ifkirne.compte;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class infos extends AppCompatActivity {
    private TextView username, userPassword;
    private ImageButton home;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_infos);
        home=findViewById(R.id.returnHome);
        username=findViewById(R.id.nom);
        userPassword=findViewById(R.id.motdepasse);
        String name=this.getIntent().getExtras().getString("name");
        String password=this.getIntent().getExtras().getString("password");
        username.setText(getString(R.string.NmUs)+" : "+name);
        userPassword.setText(getString(R.string.mdp)+" : "+password);
        home.setOnClickListener((evt)->{
            finish();
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        Toast toast=Toast.makeText(getApplicationContext(),"onstart()",Toast.LENGTH_SHORT);
        toast.show();
    }

    @Override
    protected void onResume() {
        super.onResume();
        Toast toast=Toast.makeText(getApplicationContext(),"onResume()",Toast.LENGTH_SHORT);
        toast.show();
    }

    @Override
    protected void onPause() {
        super.onPause();
        Toast toast=Toast.makeText(getApplicationContext(),"onpause()",Toast.LENGTH_SHORT);
        toast.show();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Toast toast=Toast.makeText(getApplicationContext(),"onRestart()",Toast.LENGTH_SHORT);
        toast.show();
    }

    @Override
    protected void onStop() {
        super.onStop();
        Toast toast=Toast.makeText(getApplicationContext(),"onStope()",Toast.LENGTH_SHORT);
        toast.show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Toast toast=Toast.makeText(getApplicationContext(),"onDestroy()",Toast.LENGTH_SHORT);
        toast.show();
    }
}