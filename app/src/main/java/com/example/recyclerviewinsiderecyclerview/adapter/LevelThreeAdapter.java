package com.example.recyclerviewinsiderecyclerview.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recyclerviewinsiderecyclerview.listener.CustomListener;
import com.example.recyclerviewinsiderecyclerview.R;
import com.example.recyclerviewinsiderecyclerview.model.LevelThreeModel;

import java.util.ArrayList;

/**
 * Created by Bagwan Akib on 12/17/2019.
 */
public class LevelThreeAdapter extends RecyclerView.Adapter<LevelThreeAdapter.LevelThreeViewHolder> {
    Context mContext;
    ArrayList<LevelThreeModel> models;
    private CustomListener listener;

    public LevelThreeAdapter(Context mContext, ArrayList<LevelThreeModel> models, CustomListener listener) {
        this.mContext = mContext;
        this.models = models;
        this.listener = listener;
    }

    @NonNull
    @Override
    public LevelThreeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.level_three, parent, false);
        return new LevelThreeViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final LevelThreeViewHolder holder, int position) {
        holder.tvText.setText(models.get(position).getText());
        holder.tvText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onItemClickListener(holder.tvText.getText().toString());
            }
        });
    }

    @Override
    public int getItemCount() {
        return models.size();
    }

    public class LevelThreeViewHolder extends RecyclerView.ViewHolder {
        TextView tvText;

        public LevelThreeViewHolder(@NonNull View itemView) {
            super(itemView);
            tvText = itemView.findViewById(R.id.tv_level_three);
        }
    }
}
