package com.example.mcfinalpractice;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity{

    Button framgemntBtn, sqliteBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        framgemntBtn = findViewById(R.id.fragmentBtn);
        sqliteBtn = findViewById(R.id.sqliteBtn);
        framgemntBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), FragmentActivity.class);
                startActivity(intent);
            }
        });
        sqliteBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),SqliteDB_Activity.class);
                startActivity(intent);
            }
        });
    }

}