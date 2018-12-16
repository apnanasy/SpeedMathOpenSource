package com.opensoftware.apnan.speedmathopensource;

import android.os.Parcel;
import android.os.Parcelable;

public class GameCreation implements Parcelable {

    public static final Parcelable.Creator<GameCreation> CREATOR = new Parcelable.Creator<GameCreation>()
    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {

    }
}
