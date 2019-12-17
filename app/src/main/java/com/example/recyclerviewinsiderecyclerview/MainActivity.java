package com.example.recyclerviewinsiderecyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.example.recyclerviewinsiderecyclerview.adapter.LevelOneAdapter;
import com.example.recyclerviewinsiderecyclerview.listener.CustomListener;
import com.example.recyclerviewinsiderecyclerview.model.LevelOneModel;
import com.example.recyclerviewinsiderecyclerview.model.LevelThreeModel;
import com.example.recyclerviewinsiderecyclerview.model.LevelTwoModel;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements CustomListener {

    RecyclerView rvMain;
    LevelOneAdapter adapter;
    ArrayList<LevelOneModel> models;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        initValue();
        initAdapter();
    }

    private void initAdapter() {
        adapter = new LevelOneAdapter(this, models,this);
        rvMain.setAdapter(adapter);
    }

    private void initValue() {
        models = new ArrayList<>();
        LevelOneModel model1;
        LevelTwoModel model2;
        LevelThreeModel model3;
        for (int j = 0; j < 4; j++) {
            model1 = new LevelOneModel();
            model1.setText("Level 1 - " + (j + 1));
            for (int i = 0; i < j + 2; i++) {
                model2 = new LevelTwoModel();
                model2.setText("Stack - " + (i + 1));
                for (int k = 0; k < i + 2; k++) {
                    model3 = new LevelThreeModel();
                    model3.setText("Block - " + (k + 1));
                    model2.getLevelThreeModels().add(model3);
                }
                model1.getLevelTwoModels().add(model2);
            }
            models.add(model1);
        }
    }

    private void init() {
        rvMain = findViewById(R.id.rv_main);
        rvMain.setLayoutManager(new LinearLayoutManager(this));

    }

    @Override
    public void onItemClickListener(String text) {
        Toast.makeText(this, text, Toast.LENGTH_SHORT).show();
    }
}
