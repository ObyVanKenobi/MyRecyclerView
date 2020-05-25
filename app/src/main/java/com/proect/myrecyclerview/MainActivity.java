package com.proect.myrecyclerview;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    private RecyclerView nubberList;

    private  NumbersAdapter numbersAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nubberList = findViewById(R.id.rv_numbers);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        nubberList.setLayoutManager(layoutManager);

        nubberList.setHasFixedSize(true);
        numbersAdapter = new NumbersAdapter(100, this);
        nubberList.setAdapter(numbersAdapter);



    }
}
