package com.opensoftware.apnan.speedmathopensource;

import java.util.Random;

public class RandMath {
    private int left, right, operator;
    private String equation;

    public RandMath()
    {

    }
    private void createEquation()
    {
        operator = generateNum(4);
        do {
            left = generateNum(50);
            right = generateNum(50);

        } while(checkPossibleEquation() != true);
        createEquationString();

    }
    private void createEquationString()
    {
        StringBuilder built = new StringBuilder();
        built.append(left);
        switch(operator) {
            case 1: built.append(" + ");
                break;
            case 2: built.append(" - ");
                break;
            case 3: built.append(" x ");
                break;
            case 4: built.append(" / ");
                break;

        }
        built.append(right);
        equation = built.toString();

    }
    private boolean checkPossibleEquation()
    {
        boolean good = true;
        switch(operator) {
            case 2:
                if(left < right)
                {
                    good = false;
                }
                break;
            case 4:
                if(left % right != 0)
                {
                    good = false;
                }
                break;
        }
        return good;
    }
    private int generateNum(int max)
    {
        Random rand = new Random();
        return rand.nextInt(max) + 1;
    }
    public String getEquation()
    {
        createEquation();
        return equation;
    }
    public boolean checkEquation(int answer)
    {
        return true;
    }
}
