package com.opensoftware.apnan.speedmathopensource;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;

public class Equation implements Serializable {

    private int left;
    private int right;
    private int operator;
    private int answer;
    private String equation;

public Equation()
{

}
    public boolean checkPossibleEquation()
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
        if(good) {
            createEquationString();
            createAnswer();
            return good;
        } else {
            return good;
        }
    }
    private void createAnswer()
    {
        switch(operator) {
            case 1: answer = left + right;
                break;
            case 2: answer = left - right;
                break;
            case 3: answer = left * right;
                break;
            case 4: answer = left / right;
                break;
        }
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
    public void setLeft(int left) {
        this.left = left;
    }

    public void setRight(int right) {
        this.right = right;
    }

public void setOperator(int operator)
{
    this.operator = operator;
}
    public int getAnswer()
    {
        return answer;
    }
    public String getEquation() {
        return equation;
    }


}
