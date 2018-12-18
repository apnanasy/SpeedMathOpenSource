package com.opensoftware.apnan.speedmathopensource;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Random;

public class Game implements Serializable {

    private ArrayList<Equation> equations;
    private Score score;
    private GameCreation creator;
    //private Context context;
    private Activity activity;

    public Game(GameCreation creator, Activity activity)
    {
        this.creator = creator;
        //this.context = context;
        this.activity = activity;
        //context = activity.getBaseContext();
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
            if(equations.isEmpty()) {
                Intent intent = new Intent(activity.getBaseContext(),ScoreActivity.class);
                intent.putExtra("score", score);
                activity.startActivity(intent);
                return true;
            } else {
                score.addEquation(equations.get(0));
                equations.remove(0);
                return true;
            }
        } else {
            return false;
        }
    }


}
