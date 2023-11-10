package com.example.menu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;

public class SecondActivity extends AppCompatActivity {

    private TextInputLayout editTextData;
    private Button buttonBack;

    public void init(){
        editTextData = findViewById(R.id.editTextData);
        buttonBack = findViewById(R.id.buttonBack);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        init();

        buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (editTextData.getEditText().getText().toString().isEmpty()){
                    editTextData.setError("Nem lehet üres");
                } else{
                    SharedPreferences sharedPreferences = getSharedPreferences("Data",
                            Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putString("adat", editTextData.getEditText().getText().toString());
                    editor.apply(); //commit helyett

                    Toast.makeText(SecondActivity.this, "Sikeres adat mentés", Toast.LENGTH_SHORT).show();

                    Intent intent = new Intent(SecondActivity.this, MainActivity.class);
                    startActivity(intent);
                    finish();
                }
            }
        });
    }
}