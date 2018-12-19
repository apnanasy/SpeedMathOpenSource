package com.opensoftware.apnan.speedmathopensource;

import java.io.Serializable;
import java.util.ArrayList;

public class AllScores implements Serializable {
    private ArrayList<Score> completed;

    public AllScores() {
        completed = new ArrayList<Score>();
    }

    public void addScore(Score score) {
        completed.add(score);
    }
    public int getAmount() {
        return completed.size();
    }
}
