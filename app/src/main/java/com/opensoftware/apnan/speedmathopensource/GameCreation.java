package com.opensoftware.apnan.speedmathopensource;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;

public class GameCreation implements Serializable {
    private int low, high, amount;
    public String checkGame(int low, int high, int amount) {
        if(low > high){
            return "Low must be lower than high";
        } else {
            return null;
        }
    }
    public String getHighStr() {
        return Integer.toString(high);
    }
    public String getLowStr() {
        return Integer.toString(low);
    }
    public int getAmount() {
        return amount;
    }
    public int getLow() {
        return low;
    }

    public void setLow(int low) {
        this.low = low;
    }

    public int getHigh() {
        return high;
    }

    public void setHigh(int high) {
        this.high = high;
    }

    public GameCreation() {
        low = 1; //Default values
        high = 12;//Default Values
        amount = 10;//default values
    }


}
