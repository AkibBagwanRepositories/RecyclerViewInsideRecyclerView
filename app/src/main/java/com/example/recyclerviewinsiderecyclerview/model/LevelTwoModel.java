package com.example.recyclerviewinsiderecyclerview.model;

import java.util.ArrayList;

/**
 * Created by Bagwan Akib on 12/17/2019.
 */
public class LevelTwoModel {
    String text;
    ArrayList<LevelThreeModel> levelThreeModels;

    public LevelTwoModel() {
        levelThreeModels = new ArrayList<>();
    }

    public LevelTwoModel(String text, ArrayList<LevelThreeModel> levelThreeModels) {
        this.text = text;
        this.levelThreeModels = levelThreeModels;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public ArrayList<LevelThreeModel> getLevelThreeModels() {
        return levelThreeModels;
    }

    public void setLevelThreeModels(ArrayList<LevelThreeModel> levelThreeModels) {
        this.levelThreeModels = levelThreeModels;
    }
}
