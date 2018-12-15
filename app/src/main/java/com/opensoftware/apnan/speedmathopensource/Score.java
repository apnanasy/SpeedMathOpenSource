package com.opensoftware.apnan.speedmathopensource;

import java.util.ArrayList;

public class Score {
    private Equation equate;
    private ArrayList<Equation> equations;
    private ArrayList<Integer> tried;
    private int tries;
    public Score()
    {
        tries = 0;
        equations = new ArrayList<Equation>();
        tried = new ArrayList<Integer>();
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
