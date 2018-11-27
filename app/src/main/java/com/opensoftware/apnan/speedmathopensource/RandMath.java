package com.opensoftware.apnan.speedmathopensource;

public class RandMath {
    private boolean mult;
    private int right, wrong;
    public RandMath()
    {
        mult = true;
        right = 0;
        wrong = 0;
    }
    public String getEquation()
    {
        return "4 x 4";
    }
    public boolean checkEquation(int answer)
    {
        return true;
    }
}
