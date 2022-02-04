package com.example.mcfinalpractice;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class RecylerViewActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    List<EmployeeModel> list = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recyler_view);
        list.add(new EmployeeModel(1,"Ahsan Riaz","Software Engineer",85000));
        list.add(new EmployeeModel(2,"Afaq Shoaib","Associate Software Engineer",65000));
        list.add(new EmployeeModel(3,"Suleman Sohail","Full Stack Web Developer",95000));
        recyclerView = findViewById(R.id.empRecyclerView);
        recyclerView.setHasFixedSize(true);
        // vertical by default
        layoutManager =new LinearLayoutManager(getApplicationContext());

        // horizontal
//        layoutManager =new LinearLayoutManager(getApplicationContext(),RecyclerView.HORIZONTAL,true);
        recyclerView.setLayoutManager(layoutManager);

        adapter = new MyRecyclerViewAdapter(list);
        recyclerView.setAdapter(adapter);

    }
}