package com.opensoftware.apnan.speedmathopensource;

import java.io.Serializable;

/**
 * This class contains an equation that has been processed by the score class
 * This most likely should be refactored to extend the equation class instead of just
 * contining an instance of it.
 */
public class ScoredEquation implements Serializable {
    private Equation equation;
    private int tries;
    private int time;

    /**
     * @param eq the equation that has been processed
     * @param tries The amount of tries that it took the user to answer the question
     */
    public ScoredEquation(Equation eq, int tries, int time) {
        this.tries = tries;
        this.time = time;
        equation = eq;
    }

    /**
     * @return String that contains the original equation string and the amount of tries to answer it
     */
    public String toString() {
        return equation.toString() + " Attempts: " + Integer.toString(tries) + " Time: " + Integer.toString(time);
    }
}
