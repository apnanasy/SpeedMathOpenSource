package com.opensoftware.apnan.speedmathopensource;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

public class Score implements Parcelable {
    private Equation equate;
    private GameCreation details;
    private ArrayList<Equation> equations;
    private ArrayList<Integer> tried;
    private int tries;
    public Score(GameCreation details)
    {
        tries = 0;
        equations = new ArrayList<Equation>();
        tried = new ArrayList<Integer>();
        this.details = details;
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
            equations.add(equate);
            tried.add(tries);
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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeParcelable(this.equate, flags);
        dest.writeParcelable(this.details, flags);
        dest.writeTypedList(this.equations);
        dest.writeList(this.tried);
        dest.writeInt(this.tries);
    }

    protected Score(Parcel in) {
        this.equate = in.readParcelable(Equation.class.getClassLoader());
        this.details = in.readParcelable(GameCreation.class.getClassLoader());
        this.equations = in.createTypedArrayList(Equation.CREATOR);
        this.tried = new ArrayList<Integer>();
        in.readList(this.tried, Integer.class.getClassLoader());
        this.tries = in.readInt();
    }

    public static final Parcelable.Creator<Score> CREATOR = new Parcelable.Creator<Score>() {
        @Override
        public Score createFromParcel(Parcel source) {
            return new Score(source);
        }

        @Override
        public Score[] newArray(int size) {
            return new Score[size];
        }
    };
}
