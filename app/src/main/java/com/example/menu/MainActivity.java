package com.example.menu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button buttonNext;
    private Button buttonDelete;
    private Button buttonExit;
    private TextView textViewData;
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;

    public void init(){
        buttonNext = findViewById(R.id.buttonNext);
        buttonDelete = findViewById(R.id.buttonDelete);
        buttonExit = findViewById(R.id.buttonExit);
        textViewData = findViewById(R.id.textViewData);

        sharedPreferences = getSharedPreferences("Data",
                Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
        
        String helper = sharedPreferences.getString("adat", "Üres");
        textViewData.setText(helper);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();

        buttonNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //activity váltás
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                startActivity(intent);
                finish();
            }
        });
        
        buttonDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editor.clear();
                editor.apply();
                Toast.makeText(MainActivity.this, "Adatok törölve", Toast.LENGTH_SHORT).show();
            }
        });

        buttonExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}