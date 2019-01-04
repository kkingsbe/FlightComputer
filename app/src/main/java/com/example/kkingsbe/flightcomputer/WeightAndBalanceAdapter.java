package com.example.kkingsbe.flightcomputer;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import java.util.ArrayList;

public class WeightAndBalanceAdapter extends RecyclerView.Adapter<WeightAndBalanceAdapter.WeightAndBalanceViewHolder> {
    private ArrayList<WeightAndBalanceItem> mWeightAndBalanceList;

    public static class WeightAndBalanceViewHolder extends RecyclerView.ViewHolder{
        public EditText mNameEditText;
        public EditText mWeightEditText;
        public EditText mArmEditText;

        public WeightAndBalanceViewHolder(View itemView) {
            super(itemView);
            mNameEditText = itemView.findViewById(R.id.nameEditText);
            mWeightEditText = itemView.findViewById(R.id.weightEditText);
            mArmEditText = itemView.findViewById(R.id.armEditText);
        }
    }

    public WeightAndBalanceAdapter(ArrayList<WeightAndBalanceItem> weightAndBalanceList){
        mWeightAndBalanceList = weightAndBalanceList;
    }

    @NonNull
    @Override
    public WeightAndBalanceViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.weightbalance_item, parent, false);
        WeightAndBalanceViewHolder wvh = new WeightAndBalanceViewHolder(v);
        return wvh;
    }

    @Override
    public void onBindViewHolder(@NonNull WeightAndBalanceViewHolder holder, int position) {
        WeightAndBalanceItem currentItem = mWeightAndBalanceList.get(position);
    }

    @Override
    public int getItemCount() {
        return mWeightAndBalanceList.size();
    }
}
