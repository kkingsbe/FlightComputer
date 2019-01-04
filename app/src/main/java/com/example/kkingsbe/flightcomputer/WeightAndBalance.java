package com.example.kkingsbe.flightcomputer;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.ArrayList;

public class WeightAndBalance extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private ArrayList<WeightAndBalanceItem> weightAndBalanceList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weight_and_balance);
        setTitle("Weight and Balance");
        /*
        RecyclerView of different W&B items that changes size with a add new button on the bottom
         */

        mRecyclerView = findViewById(R.id.weightAndBalanceRecyclerView);
        mRecyclerView.setHasFixedSize(false); //Posibly change this
        mLayoutManager = new LinearLayoutManager(this);
        mAdapter = new WeightAndBalanceAdapter(weightAndBalanceList);

        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdapter);
    }

    public void newItem(View v){
        weightAndBalanceList.add(new WeightAndBalanceItem());
        mAdapter.notifyDataSetChanged();
    }
}
