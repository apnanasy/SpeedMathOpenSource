package com.opensoftware.apnan.speedmathopensource;

import java.io.Serializable;

/**
 * This class contains an equation that has been processed by the score class
 * This most likely should be refactored to extend the equation class instead of just
 * contining an instance of it.
 */
public class ScoredEquation implements Serializable {
    private Equation equation;
    private int tries;
    private int time;
    private int answered;
    private int score = 100;

    /**
     * @param eq the equation that has been processed
     * @param tries The amount of tries that it took the user to answer the question
     */
    public ScoredEquation(Equation eq, int tries, int time) {
        this.tries = tries;
        this.time = time;
        equation = eq;
        score = score - time - (tries * 10); // Numeric score calculator for when wrong answers are not accepted
        if(score < 0) { //Make sure that no score is below 0
            score = 0;
        }
    }
    public ScoredEquation(Equation eq, int tries, int time, int ans) {
        this.tries = 0; // setting tries to 0 so that tostring knows to choose the right string type
        this.time = time;
        equation = eq;
        answered = ans;
        if(answered != eq.getAnswer()) {
            score = 0;
        } else {
            score = score - time;
        }
    }
    public int getScore() {
        return score;
    }

    /**
     * @return String that contains the original equation string and the amount of tries to answer it
     */
    public String toString() {
        if(tries == 0) {
            return equation.toString() + " Answered: " + Integer.toString(answered) + " Time: " + Integer.toString(time) + " Score: " + Integer.toString(score);
        } else {
            return equation.toString() + " Attempts: " + Integer.toString(tries) + " Time: " + Integer.toString(time) + " Score: " + Integer.toString(score);
        }
    }
}
