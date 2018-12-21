package com.opensoftware.apnan.speedmathopensource;

import android.app.Activity;
import android.content.Intent;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Random;

/**
 * This game takes care of the actual match happening on your device
 */
public class Game implements Serializable {

    private ArrayList<Equation> equations; // Unanswered equations
    private Score score; // Contains the answered equations
    private GameCreation creator; //has the data needed to make the game
    private transient Activity activity; //Needed to call the next activity when all equations are answered

    /**
     * Creates the arraylist for the equations. It also creates all the equations and moves the first one to the score class
     * @param creator The gamecreation object that contains the specific parameters for the game
     * @param activity This is the calling activity, put here so that this class can call the next activity
     */
    public Game(GameCreation creator, Activity activity)
    {
        this.creator = creator;
        this.activity = activity;
        equations = new ArrayList<Equation>();
        score = new Score(creator);
        createEquation();
        score.addEquation(equations.get(0));
        equations.remove(0);
    }

    /**
     * @param act the activity that is using the object, this method has to be called when the object is created from memory
     */
    public void setActivity(Activity act) {
        activity = act;
    }

    /**
     * This method creates all the equations and adds them to the arraylist
     */
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

    /**
     * @return the amount of equations in the object
     */
    public int getAmount() {
        return score.getAmount();
    }

    /**
     * @return returns an int that is within the range specified by the GameCreation object
     */
    private int generateRange()
    {
        Random rand = new Random();
        return rand.nextInt((creator.getHigh() - creator.getLow()) + 1) + creator.getLow();
    }

    /**
     * @param max the highest number that should be returned
     * @return a random num that is no bigger than max
     */
    private int generateNum(int max)
    {
        Random rand = new Random();
        return rand.nextInt(max) + 1;
    }

    /**
     * @return the equation without answer put into a string
     */
    public String getEquation()
    {
        return score.getEquationString();
    }

    /**
     * @return String that is made from int of how many attempts on that question
     */
    public String getScore()
    {
        return Integer.toString(score.getTries());
    }

    /**
     * if answer is correct and game doesnt have anymore equations this creates an intent and sends the score object to the next activity
     * @param answer This is the answer that you want checked
     * @return Boolean representing wether the answer was correct or not
     */
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
