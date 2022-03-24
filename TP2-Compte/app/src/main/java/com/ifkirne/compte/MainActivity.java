package com.ifkirne.compte;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent=new Intent(getApplicationContext(),login.class);
                startActivity(intent);
            }
        },8000);
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