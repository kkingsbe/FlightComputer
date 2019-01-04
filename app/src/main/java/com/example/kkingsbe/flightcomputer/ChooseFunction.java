package com.example.kkingsbe.flightcomputer;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class ChooseFunction extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private FunctionAdapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_function);

        populateRecyclerView();
    }

    private void populateRecyclerView(){
        final ArrayList<FunctionItem> functionItems = new ArrayList<>();
        functionItems.add(new FunctionItem(R.drawable.ic_pressure_altitude_white_24dp, "Pressure & Density Altitude Calculator"));
        functionItems.add(new FunctionItem(R.drawable.ic_flight_wandb_24dp, "Weight and Balance"));
        functionItems.add(new FunctionItem(R.drawable.ic_local_gas_station_white, "Max Fuel Calculator"));
        functionItems.add(new FunctionItem(R.drawable.ic_cloud_white_24dp, "Weather / TAF"));
        functionItems.add(new FunctionItem(R.drawable.ic_ruler_white_24dp, "Unit Conversions"));

        mRecyclerView = findViewById(R.id.functionsRecyclerView);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        mAdapter = new FunctionAdapter(functionItems);

        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdapter);
        mAdapter.setOnItemClickListener(new FunctionAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                if(functionItems.get(position).getText().equals("Pressure & Density Altitude Calculator")){
                    Intent intent = new Intent(ChooseFunction.this, PressureAndDensityAlt.class);
                    startActivity(intent);
                } else if(functionItems.get(position).getText().equals("Weight and Balance")){
                    Intent intent = new Intent(ChooseFunction.this, WeightAndBalance.class);
                    startActivity(intent);
                }
            }
        });
    }
}
