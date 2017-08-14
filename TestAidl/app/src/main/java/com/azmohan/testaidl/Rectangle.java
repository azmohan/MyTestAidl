package com.azmohan.testaidl;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by azmohan on 17-8-14.
 */

public final class Rectangle implements Parcelable {
    public int left;
    public int top;
    public int right;
    public int bottom;

    public Rectangle() {

    }

    public Rectangle(int left, int top, int right, int bottom) {
        this.left = left;
        this.top = top;
        this.right = right;
        this.bottom = bottom;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(32);
        sb.append("Rectangle : ").append("left = ").append(left)
                .append(" , ").append("top = ").append(top).append(" , ")
                .append("right = ").append(right).append(" , ").append("bottom = ").append(bottom);
        return sb.toString();
    }

    public Rectangle(Parcel parcel) {
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

    public static final Parcelable.Creator<Rectangle> CREATOR = new Parcelable.Creator<Rectangle>() {
        @Override
        public Rectangle createFromParcel(Parcel parcel) {
            return new Rectangle(parcel);
        }

        @Override
        public Rectangle[] newArray(int size) {
            return new Rectangle[size];
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
