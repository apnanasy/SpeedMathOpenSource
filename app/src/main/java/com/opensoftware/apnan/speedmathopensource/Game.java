package com.opensoftware.apnan.speedmathopensource;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.Random;

public class Game implements Parcelable {

    private ArrayList<Equation> equations;
    private Score score;
    private GameCreation creator;

    public Game(GameCreation creator)
    {
        this.creator = creator;
        equations = new ArrayList<Equation>();
        score = new Score(creator);
        createEquation();
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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeTypedList(this.equations);
        dest.writeParcelable(this.score, flags);
        dest.writeParcelable(this.creator, flags);
    }

    protected Game(Parcel in) {
        this.equations = in.createTypedArrayList(Equation.CREATOR);
        this.score = in.readParcelable(Score.class.getClassLoader());
        this.creator = in.readParcelable(GameCreation.class.getClassLoader());
    }

    public static final Parcelable.Creator<Game> CREATOR = new Parcelable.Creator<Game>() {
        @Override
        public Game createFromParcel(Parcel source) {
            return new Game(source);
        }

        @Override
        public Game[] newArray(int size) {
            return new Game[size];
        }
    };
}
