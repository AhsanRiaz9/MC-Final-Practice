package com.example.mcfinalpractice;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class FragmentActivity extends AppCompatActivity {
    Button fr1Btn, fr2Btn;
    //frameLayout
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment);
        fr1Btn = findViewById(R.id.fr1Btn);
        fr2Btn = findViewById(R.id.fr2Btn);
        fr1Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment1 fr1 = new Fragment1();
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.frameLayout, fr1);
                transaction.commit();
            }
        });

        fr2Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment2 fr2 = new Fragment2();
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.frameLayout,fr2);
                transaction.commit();
            }
        });
    }
}