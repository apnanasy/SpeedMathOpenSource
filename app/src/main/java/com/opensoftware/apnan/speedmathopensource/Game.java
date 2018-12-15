package com.opensoftware.apnan.speedmathopensource;

import java.util.ArrayList;
import java.util.Random;

public class Game {

    private ArrayList<Equation> equations;
    private Score score;

    public Game()
    {
        equations = new ArrayList<Equation>();
        score = new Score();
        createEquation();
    }
    private void createEquation()
    {
        int ctr = 0;
        while(ctr < 50) {
            equations.add(ctr,new Equation());
            equations.get(ctr).setOperator(generateNum(4));
            do {
                equations.get(ctr).setLeft(generateNum(50));
                equations.get(ctr).setRight(generateNum(50));

            } while (!equations.get(ctr).checkPossibleEquation());
            ctr++;
        }



    }
    private int generateNum(int max)
    {
        Random rand = new Random();
        return rand.nextInt(max) + 1;
    }
    public String getEquation()
    {
        score.addEquation(equations.get(0));
        equations.remove(0);
        return score.getEquationString();
    }
    public String getScore()
    {
        return Integer.toString(score.getTries());
    }
    public boolean checkEquation(int answer)
    {
        if(score.attempt(answer))
        {
            return true;
        } else {
            return false;
        }
    }
}