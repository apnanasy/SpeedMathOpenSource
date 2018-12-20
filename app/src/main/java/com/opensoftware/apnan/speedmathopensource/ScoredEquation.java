package com.opensoftware.apnan.speedmathopensource;

import java.io.Serializable;

public class ScoredEquation implements Serializable {
    private Equation equation;
    private int tries;

    public ScoredEquation(Equation eq, int tries) {
        this.tries = tries;
        equation = eq;
    }
    public String toString() {
        return equation.toString() + " Attempts: " + Integer.toString(tries);
    }
}
