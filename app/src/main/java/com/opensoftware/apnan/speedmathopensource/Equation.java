package com.opensoftware.apnan.speedmathopensource;


import java.io.Serializable;

/**
 * This class holds a single unscored equation and its answer
 */
public class Equation implements Serializable {

    private int left;// Left number of the equation
    private int right;// Right number of the equation
    private int operator; // number that signifies what operation is being done
    private int answer;// Generated answer to the equation
    private String equation; // The equation turned into a string for display purposes

    /**
     * Default constructor
     */
public Equation()
{

}

    /**
     * This function tests the viability of the equation contained as well as calling
     * createEquationString() and createAnswer() if it is viable;
     * @return true if the object contains a viable equation, false otherwise
     */
    public boolean checkPossibleEquation()
    {
        boolean good = true;
        switch(operator) {
            case 2:
                if(left < right) // Makes sure that you will not get a negative number during subtraction
                {
                    good = false;
                }
                break;
            case 3:
                if(left % right != 0) // Makes sure that you will not division with an answer with a decimal point
                {
                    good = false;
                }
                break;
        }
       return good;
    }
    public int getOperator() {
        return operator;
    }
    public int getLeft() {
        return left;
    }
    public int getRight() {
        return right;
    }

    /**
     * This function translates the int in answer to a certain operation and then solves the equation
     * and assigns the answer to the answer field.
     */
    public void createAnswer()
    {
        switch(operator) {
            case 1: answer = left + right;
                break;
            case 2: answer = left - right;
                break;
            case 3: answer = left / right;
                break;
            case 4: answer = left * right;
                break;
        }
    }

    /**
     * This function creates a displayable string without the answer for the user, and then assigns that
     * string to the equation field.
     */
    public void createEquationString()
    {
        StringBuilder built = new StringBuilder();
        built.append(left);
        switch(operator) {
            case 1: built.append(" + ");
                break;
            case 2: built.append(" - ");
                break;
            case 3: built.append(" / ");
                break;
            case 4: built.append(" * ");
                break;

        }
        built.append(right);
        equation = built.toString();

    }

    /**
     * @param left The int you want to use as the left side of the equation
     */
    public void setLeft(int left) {
        this.left = left;
    }

    /**
     * @param right the int you want to use as the right side of the equation
     */
    public void setRight(int right) {
        this.right = right;
    }

    /**
     * @param operator The int that you want to use as the ooperator for the equation
     */
public void setOperator(int operator)
{
    this.operator = operator;
}

    /**
     * @return The answer to the equation contained in the answer field
     */
    public int getAnswer()
    {
        return answer;
    }

    /**
     * @return The equation field which contains the equation without the answer
     */
    public String getEquation() {
        return equation;
    }

    /**
     * @return The entire equation including the answer converted into a string
     */
public String toString() {
    return equation + "=" + Integer.toString(answer);
}
}

