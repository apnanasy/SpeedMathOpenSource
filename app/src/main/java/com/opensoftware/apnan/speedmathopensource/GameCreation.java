package com.opensoftware.apnan.speedmathopensource;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;

/**
 * This class sets the game parameters
 */
public class GameCreation implements Serializable {
    private int low, high, amount;

    /**
     * @param low the low range
     * @param high the high range
     * @param amount the amount of questions
     * @return The string error, null if correct
     */
    public String checkGame(int low, int high, int amount) {
        if(low > high){
            return "Low must be lower than high";
        } else {
            this.low = low;
            this.high = high;
            this.amount = amount;
            return null;
        }
    }

    /**
     * @return high range converted into string
     */
    public String getHighStr() {
        return Integer.toString(high);
    }

    /**
     * @return low range converted into string
     */
    public String getLowStr() {
        return Integer.toString(low);
    }

    /**
     * @return return the count of equations to create
     */
    public int getAmount() {
        return amount;
    }

    /**
     * @return the low range int
     */
    public int getLow() {
        return low;
    }

    /**
     * @param low set low range to this
     */
    public void setLow(int low) {
        this.low = low;
    }

    public int getHigh() {
        return high;
    }

    /**
     * @param high set high range int
     */
    public void setHigh(int high) {
        this.high = high;
    }

    /**
     * @return Amount of equations turned into string
     */
    public String getAmountStr() {
        return Integer.toString(amount);
    }

    /**
     * Default constructor that sets the amount, low, high to default values;
     */
    public GameCreation() {
        low = 1; //Default values
        high = 12;//Default Values
        amount = 10;//default values
    }


}
