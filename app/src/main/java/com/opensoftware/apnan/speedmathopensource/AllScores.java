package com.opensoftware.apnan.speedmathopensource;

import java.io.Serializable;
import java.util.ArrayList;

public class AllScores implements Serializable {
    private ArrayList<Score> completed; //Stores all completed single player matches

    /**
     * Constructor that creates a new Arraylist completed
     */
    public AllScores() {
        completed = new ArrayList<Score>();
    }

    /**
     * @param pos the position of the score to be retrieved
     * @return The score object contained in the arraylist
     */
    public Score getScore(int pos) {
        return completed.get(pos);
    }

    /**
     * @param score A score object that is to be added to the completed arraylist
     */
    public void addScore(Score score) {
        completed.add(score);
    }

    /**
     * @return the amount of attempts made turned into a string
     */
    public String getQuestionAmount() {
        int total = 0;
        for(Score score: completed) {
            total += score.getOverallTries();
        }
        return Integer.toString(total);
    }

    /**
     * @return The total amount of equations turned into a string
     */
    public String getEquationCount() {
        int total = 0;
        for(Score score: completed) {
            total += score.getAmount();
        }
        return Integer.toString(total);
    }

    /**
     * @return the amount of matches
     */
    public int getAmount() {
        return completed.size();
    }

    public ArrayList<Score> getCompleted() {
        return completed;
    }
}
