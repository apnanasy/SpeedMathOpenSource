package com.opensoftware.apnan.speedmathopensource;

import java.io.Serializable;
import java.util.ArrayList;

public class Score implements Serializable {
    private Equation equate;
    private GameCreation details;
    private ArrayList<ScoredEquation> equations;
    private int tries;
    private int overallTries;
    public Score(GameCreation details)
    {
        tries = 0;
        equations = new ArrayList<ScoredEquation>();
        this.details = details;
    }
    public int getOverallTries() {
        return overallTries;
    }
    public ArrayList<ScoredEquation> getEquations() {
        return equations;
    }
    public int getAmount() {
        return equations.size();
    }
    public void addEquation(Equation e)
    {
        equate = e;
        tries = 0;
    }
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
    public int getTries()
    {
        return tries;
    }
    public String getEquationString()
    {
        return equate.getEquation();
    }


}
