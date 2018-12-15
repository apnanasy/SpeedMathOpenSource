package com.opensoftware.apnan.speedmathopensource;

import java.util.Random;

public class Game {
    private String equation;
    private Equation equate;

    public Game()
    {
        equate = new Equation();
    }
    private void createEquation()
    {
        equate.setOperator(generateNum(4));
        do {
            equate.setLeft(generateNum(50));
            equate.setRight(generateNum(50));

        } while(equate.checkPossibleEquation() != true);



    }
    private int generateNum(int max)
    {
        Random rand = new Random();
        return rand.nextInt(max) + 1;
    }
    public String getEquation()
    {
        createEquation();
        return equate.getEquation();
    }
    public boolean checkEquation(int answer)
    {
        if(equate.getAnswer() == answer)
        {
            return true;
        } else {
            return false;
        }
    }
}
