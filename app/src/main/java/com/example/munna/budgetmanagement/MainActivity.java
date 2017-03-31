package com.example.munna.budgetmanagement;


import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.Toast;;

public class MainActivity extends AppCompatActivity {

    DbHelper db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        db=new DbHelper(getApplicationContext());
        }
    public void InsertSpent(View v){

         Intent i=new Intent(MainActivity.this,DataInsert.class);
                startActivity(i);
    }

    public void Total(View v){

        Intent i =new Intent(getApplicationContext(),ViewTable.class);
        startActivity(i);
    }
    public void ChangeTable(View v){

        Toast.makeText(getApplicationContext(),"Sorry Service Under construction", Toast.LENGTH_LONG).show();
    }
}
