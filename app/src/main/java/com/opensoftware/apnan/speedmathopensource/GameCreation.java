package com.opensoftware.apnan.speedmathopensource;

import android.os.Parcel;
import android.os.Parcelable;

public class GameCreation implements Parcelable {
    private int low, high;
    public String checkGame(int low, int high) {
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
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.low);
        dest.writeInt(this.high);
    }

    protected GameCreation(Parcel in) {
        this.low = in.readInt();
        this.high = in.readInt();
    }

    public static final Creator<GameCreation> CREATOR = new Creator<GameCreation>() {
        @Override
        public GameCreation createFromParcel(Parcel source) {
            return new GameCreation(source);
        }

        @Override
        public GameCreation[] newArray(int size) {
            return new GameCreation[size];
        }
    };
}
