package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView myRecyclerView;
    private RecyclerView.LayoutManager myLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myRecyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        myRecyclerView.setHasFixedSize((true));
        myLayoutManager = new LinearLayoutManager(this);
        myRecyclerView.setLayoutManager(myLayoutManager);

        ArrayList<department> departmentsInfo = new ArrayList<>();
        departmentsInfo.add(new department(R.drawable.parrot,"공과대학",
                "https://engineer.dongguk.edu/","woongsup@dongguk.edu","02-2260-3861"));
        departmentsInfo.add(new department(R.drawable.parrot, "이과대학",
                "http://science.doungguk.edu/","woongsup@dongguk.edu","02-2260-3786"));
        departmentsInfo.add(new department(R.drawable.parrot,
                "경찰사법대학", "https://justice.dongguk.edu/","policeadmin@dongguk.edu","02-2260-3370"));
        departmentsInfo.add(new department(R.drawable.parrot,
                "경영대학", "http://sba.dongguk.edu/","woongsup@dongguk.edu","02-2260-8886"));
        departmentsInfo.add(new department(R.drawable.parrot,
                "바이오시스템대학","https://life.dongguk.edu/","woongsup@dongguk.edu","031-961-5103"));
        // 목록을 어댑터에 연결해 준다.
        MyAdapter myAdapter = new MyAdapter(departmentsInfo);
        // 어댑터를 뷰에 연결해 준다.
        myRecyclerView.setAdapter(myAdapter);


    }
}