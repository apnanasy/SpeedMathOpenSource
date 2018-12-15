package com.opensoftware.apnan.speedmathopensource;

public class Score {
    private Equation equate;
    private int tries;
    public Score()
    {
        tries = 0;
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
