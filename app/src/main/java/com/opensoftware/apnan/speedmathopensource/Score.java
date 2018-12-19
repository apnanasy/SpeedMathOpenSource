package com.opensoftware.apnan.speedmathopensource;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;
import java.util.ArrayList;

public class Score implements Serializable {
    private Equation equate;
    private GameCreation details;
    private ArrayList<ScoredEquation> equations;
    //private ArrayList<Integer> tried;
    private int tries;
    public Score(GameCreation details)
    {
        tries = 0;
        equations = new ArrayList<ScoredEquation>();
        //tried = new ArrayList<Integer>();
        this.details = details;
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
        if(answer == equate.getAnswer())
        {
            ScoredEquation done = new ScoredEquation(equate,tries);
            equations.add(done);
            //tried.add(tries);
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
