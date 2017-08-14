package com.azmohan.testaidl;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by azmohan on 17-8-14.
 */

public final class Rect implements Parcelable {
    public int left;
    public int top;
    public int right;
    public int bottom;

    public Rect() {

    }

    public Rect(Parcel parcel) {
        readFromParcel(parcel);
    }

    public void readFromParcel(Parcel parcel) {
        left = parcel.readInt();
        top = parcel.readInt();
        right = parcel.readInt();
        bottom = parcel.readInt();
    }

    public void writeToParcel(Parcel out) {
        out.writeInt(left);
        out.writeInt(top);
        out.writeInt(right);
        out.writeInt(bottom);
    }

    public static final Parcelable.Creator<Rect> CREATOR = new Parcelable.Creator<Rect>() {
        @Override
        public Rect createFromParcel(Parcel parcel) {
            return new Rect(parcel);
        }

        @Override
        public Rect[] newArray(int size) {
            return new Rect[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        writeToParcel(parcel);
    }
}
