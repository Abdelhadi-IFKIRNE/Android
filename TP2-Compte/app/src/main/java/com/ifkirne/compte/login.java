package com.ifkirne.compte;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class login extends AppCompatActivity {
    private Button identifier;
    private TextView username,userPassword;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        identifier=findViewById(R.id.identi);
        username=findViewById(R.id.editTextTextUserName);
        userPassword=findViewById(R.id.editTextTextUserPassword);
        identifier.setOnClickListener((evt)->{
            Intent intent=new Intent(getApplicationContext(),infos.class);
            intent.putExtra("name",username.getText().toString());
            intent.putExtra("password",userPassword.getText().toString());
            startActivity(intent);
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