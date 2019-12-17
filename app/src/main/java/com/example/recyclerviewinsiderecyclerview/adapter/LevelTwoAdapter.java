package com.example.recyclerviewinsiderecyclerview.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recyclerviewinsiderecyclerview.listener.CustomListener;
import com.example.recyclerviewinsiderecyclerview.R;
import com.example.recyclerviewinsiderecyclerview.model.LevelTwoModel;

import java.util.ArrayList;

/**
 * Created by Bagwan Akib on 12/17/2019.
 */
public class LevelTwoAdapter extends RecyclerView.Adapter<LevelTwoAdapter.LevelTwoViewHolder> {

    Context mContext;
    ArrayList<LevelTwoModel> models;
    LevelThreeAdapter threeAdapter;
    private CustomListener listener;

    public LevelTwoAdapter(Context mContext, ArrayList<LevelTwoModel> models,CustomListener listener) {
        this.mContext = mContext;
        this.models = models;
        this.listener = listener;
    }

    @NonNull
    @Override
    public LevelTwoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.level_two, parent, false);
        return new LevelTwoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull LevelTwoViewHolder holder, int position) {
        holder.tvLevelTwo.setText(models.get(position).getText());
        threeAdapter = new LevelThreeAdapter(holder.rvLevelTwo.getContext(), models.get(position).getLevelThreeModels(),listener);
        holder.rvLevelTwo.setAdapter(threeAdapter);
    }

    @Override
    public int getItemCount() {
        return models.size();
    }

    public class LevelTwoViewHolder extends RecyclerView.ViewHolder {
        RecyclerView rvLevelTwo;
        TextView tvLevelTwo;

        public LevelTwoViewHolder(@NonNull View itemView) {
            super(itemView);
            rvLevelTwo = itemView.findViewById(R.id.rv_two);
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(itemView.getContext());
            linearLayoutManager.setOrientation(RecyclerView.HORIZONTAL);
            rvLevelTwo.setLayoutManager(linearLayoutManager);
            tvLevelTwo = itemView.findViewById(R.id.tv_level_two);
        }
    }
}
