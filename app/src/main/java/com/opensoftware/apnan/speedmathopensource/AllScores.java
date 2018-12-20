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
    public String getQuestionAmount() {
        int total = 0;
        for(Score score: completed) {
            total += score.getOverallTries();
        }
        return Integer.toString(total);
    }
    public String getEquationCount() {
        int total = 0;
        for(Score score: completed) {
            total += score.getAmount();
        }
        return Integer.toString(total);
    }
    public int getAmount() {
        return completed.size();
    }
}
