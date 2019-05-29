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
     *
     * @param e The equation that is to be checked for duplicity
     * @return true if it is not a duplicate
     */
    private boolean checkDuplicate(Equation e)
    {
        int ctr = 0;//Used to track how many of this equation are in the arraylist
        for(int i = 0; i < equations.size(); i++){
            if(e.getOperator() == equations.get(i).getOperator() //This checks the operator and left and right terms if they are all the same it increments the counter
                    && e.getLeft() == equations.get(i).getLeft()
                    && e.getRight() == equations.get(i).getRight()){
                ctr++;
            }
        }
        if(ctr > 1) { //Ctr can and should be 1 because it will find the original equation
            return false;
        } else {
            return true;
        }

    }

    /**
     * This method creates all the equations and adds them to the arraylist
     */
    private void createEquation()
    {
        int ctr = 0;
        while(ctr < creator.getAmount()) {
            equations.add(ctr,new Equation());
            equations.get(ctr).setOperator(generateOperator(4));
            do {
                equations.get(ctr).setLeft(generateRange());
                equations.get(ctr).setRight(generateRange());

            } while (!equations.get(ctr).checkPossibleEquation()
                    || !checkDuplicate(equations.get(ctr)));

                equations.get(ctr).createEquationString();
                equations.get(ctr).createAnswer();
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
    private int generateOperator(int max)
    {
        Random rand = new Random();
        boolean goodOperator = false;
        int operator = -1;
        while(!goodOperator) {
            operator = rand.nextInt(max) + 1;
            switch(operator ) {
                case 1: if(creator.isAdd()){goodOperator = true;}
                break;
                case 2: if(creator.isSub()) {goodOperator = true;}
                break;
                case 3: if(creator.isDiv()) {goodOperator = true;}
                break;
                case 4: if(creator.isMul()) {goodOperator = true;}
                break;
            }
        }

        return operator;
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
    public void exit(int answer, int time) {
        score.quit(time, answer);
        score.addEquation(equations.get(0));
        equations.remove(0);
    }

    /**
     * if answer is correct and game doesnt have anymore equations this creates an intent and sends the score object to the next activity
     * @param answer This is the answer that you want checked
     * @return Boolean representing wether the answer was correct or not
     */
    public boolean checkEquation(int answer, int time)
    {
        if(score.attempt(answer, time))
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

    /**
     * @param answer to get the hint on
     * @return String mentioning wether it is high or low
     */
    public String getHint(int answer)
    {
        if(creator.isHint()) {
            return score.checkWrong(answer);
        } else {
            return null;
        }
    }

    public String toString() {
        return Integer.toString(score.getAmount()) + "/" + creator.getAmountStr();
    }


}
