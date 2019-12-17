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
import com.example.recyclerviewinsiderecyclerview.model.LevelOneModel;

import java.util.ArrayList;

/**
 * Created by Bagwan Akib on 12/17/2019.
 */
public class LevelOneAdapter extends RecyclerView.Adapter<LevelOneAdapter.LevelOneViewHolder> {

    private Context mContext;
    private ArrayList<LevelOneModel> models;
    private LevelTwoAdapter adapterTwo;
    private CustomListener listener;

    public LevelOneAdapter(Context mContext, ArrayList<LevelOneModel> models, CustomListener listener) {
        this.mContext = mContext;
        this.models = models;
        this.listener = listener;
    }

    @NonNull
    @Override
    public LevelOneViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.level_one, parent, false);
        return new LevelOneViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull LevelOneViewHolder holder, int position) {
        holder.tvLevelOne.setText(models.get(position).getText());
        adapterTwo = new LevelTwoAdapter(holder.rvLevelOne.getContext(), models.get(position).getLevelTwoModels(), listener);
        holder.rvLevelOne.setAdapter(adapterTwo);
    }

    @Override
    public int getItemCount() {
        return models.size();
    }

    public class LevelOneViewHolder extends RecyclerView.ViewHolder {
        RecyclerView rvLevelOne;
        TextView tvLevelOne;

        public LevelOneViewHolder(@NonNull View itemView) {
            super(itemView);
            tvLevelOne = itemView.findViewById(R.id.tv_level_one);
            rvLevelOne = itemView.findViewById(R.id.rv_one);
            LinearLayoutManager manager = new LinearLayoutManager(itemView.getContext());
            manager.setOrientation(RecyclerView.VERTICAL);
            rvLevelOne.setLayoutManager(manager);
        }
    }
}
