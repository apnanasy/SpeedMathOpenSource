package com.opensoftware.apnan.speedmathopensource;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * This class keeps all the scored equations as well as a reference to gamecreation for when that contains fields for it.
 */
public class Score implements Serializable {
    private Equation equate; //Equation that is being worked on
    private GameCreation details; // Details about how to score the match
    private ArrayList<ScoredEquation> equations;// All the completed equations
    private int tries;//Attempts on this equation
    private int overallTries;// attempts for the entire game

    /**
     * @param details details on how to score the game
     */
    public Score(GameCreation details)
    {
        tries = 0;
        equations = new ArrayList<ScoredEquation>();
        this.details = details;
    }

    /**
     * @return all attempts for the match
     */
    public int getOverallTries() {
        return overallTries;
    }

    /**
     * @return The arraylist of scoreed equations
     */
    public ArrayList<ScoredEquation> getEquations() {
        return equations;
    }

    /**
     * @return int amount of equations in the match
     */
    public int getAmount() {
        return equations.size();
    }

    /**
     * @param e the next equation to work on
     */
    public void addEquation(Equation e)
    {
        equate = e;
        tries = 0;
    }

    /**
     * @param answer the answer to check
     * @return boolean indicating if it is corect
     */
    public boolean attempt(int answer)
    {
        tries++;
        overallTries++;
        if(answer == equate.getAnswer())
        {
            ScoredEquation done = new ScoredEquation(equate,tries);
            equations.add(done);
            return true;
        } else {
            return false;
        }
    }

    /**
     * @return int of tries on this equation
     */
    public int getTries()
    {
        return tries;
    }

    /**
     * @return the equation in string format
     */
    public String getEquationString()
    {
        return equate.getEquation();
    }

    public String toString() {
        return "Amount of equations: " +Integer.toString(getAmount()) + "Overall Attempts: " + Integer.toString(getOverallTries());
    }


}
