package com.opensoftware.apnan.speedmathopensource;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;
import java.util.ArrayList;

public class Score implements Serializable {
    private Equation equate;
    private GameCreation details;
    private ArrayList<Equation> equations;
    private ArrayList<Integer> tried;
    private int tries;
    public Score(GameCreation details)
    {
        tries = 0;
        equations = new ArrayList<Equation>();
        tried = new ArrayList<Integer>();
        this.details = details;
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
            equations.add(equate);
            tried.add(tries);
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
