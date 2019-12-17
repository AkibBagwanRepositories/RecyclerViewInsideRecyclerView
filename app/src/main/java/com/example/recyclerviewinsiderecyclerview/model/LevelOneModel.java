package com.example.recyclerviewinsiderecyclerview.model;

import java.util.ArrayList;

/**
 * Created by Bagwan Akib on 12/17/2019.
 */
public class LevelOneModel {
    String text;
    ArrayList<LevelTwoModel> levelTwoModels;

    public LevelOneModel() {
        levelTwoModels = new ArrayList<>();
    }

    public LevelOneModel(String text, ArrayList<LevelTwoModel> levelTwoModels) {
        this.text = text;
        this.levelTwoModels = levelTwoModels;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public ArrayList<LevelTwoModel> getLevelTwoModels() {
        return levelTwoModels;
    }

    public void setLevelTwoModels(ArrayList<LevelTwoModel> levelTwoModels) {
        this.levelTwoModels = levelTwoModels;
    }
}
