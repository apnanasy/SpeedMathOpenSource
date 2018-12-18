package com.opensoftware.apnan.speedmathopensource;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Random;

public class Game implements Serializable {

    private ArrayList<Equation> equations;
    private Score score;
    private GameCreation creator;

    public Game(GameCreation creator)
    {
        this.creator = creator;
        equations = new ArrayList<Equation>();
        score = new Score(creator);
        createEquation();
        score.addEquation(equations.get(0));
        equations.remove(0);
    }
    private void createEquation()
    {
        int ctr = 0;
        while(ctr < creator.getAmount()) {
            equations.add(ctr,new Equation());
            equations.get(ctr).setOperator(generateNum(4));
            do {
                equations.get(ctr).setLeft(generateRange());
                equations.get(ctr).setRight(generateRange());

            } while (!equations.get(ctr).checkPossibleEquation());
            ctr++;
        }



    }
    public int getAmount() {
        return score.getAmount();
    }
    private int generateRange()
    {
        Random rand = new Random();
        return rand.nextInt((creator.getHigh() - creator.getLow()) + 1) + creator.getLow();
    }
    private int generateNum(int max)
    {
        Random rand = new Random();
        return rand.nextInt(max) + 1;
    }
    public String getEquation()
    {
        //score.addEquation(equations.get(0));
        //equations.remove(0);
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
            score.addEquation(equations.get(0));
            equations.remove(0);
            return true;
        } else {
            return false;
        }
    }


}
