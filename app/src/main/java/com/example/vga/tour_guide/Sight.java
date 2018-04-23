package com.example.vga.tour_guide;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by vga on 17-Apr-18.
 */

public class Sight implements Parcelable {

    private int mSightImage;
    private int mSightTitle;
    private int mSightLocation;
    private int mSightCategory;
    private int mSightShortDesc;
    private int mSightDesc;

    /** Image resource ID for the word */
    private int mImageResourceId = NO_IMAGE_PROVIDED;

    /** Constant value that represents no image was provided for this word */
    private static final int NO_IMAGE_PROVIDED = -1;

    public Sight (int sightImage, int sightTitle,int sightShortDesc, int sightCategory,  int sightLocation, int sightDesc){

        mSightImage = sightImage;
        mSightTitle = sightTitle;
        mSightLocation = sightLocation;
        mSightCategory = sightCategory;
        mSightShortDesc = sightShortDesc;
        mSightDesc = sightDesc;




    }

    public int getSightDesc() {
        return mSightDesc;
    }

    public int getSightImage() {
        return mSightImage;
    }

    public int getSightTitle() {
        return mSightTitle;
    }

    public int getSightLocation() {
        return mSightLocation;
    }

    public int getSightCategory() {
        return mSightCategory;
    }

    public int getSightShortDesc() {
        return mSightShortDesc;
    }

    protected Sight(Parcel in) {
        mSightImage = in.readInt();
        mSightTitle = in.readInt();
        mSightLocation = in.readInt();
        mSightCategory = in.readInt();
        mSightShortDesc = in.readInt();
        mImageResourceId = in.readInt();
        mSightDesc=in.readInt();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(mSightImage);
        dest.writeInt(mSightTitle);
        dest.writeInt(mSightLocation);
        dest.writeInt(mSightCategory);
        dest.writeInt(mSightShortDesc);
        dest.writeInt(mImageResourceId);
        dest.writeInt(mSightDesc);
    }

    @SuppressWarnings("unused")
    public static final Parcelable.Creator<Sight> CREATOR = new Parcelable.Creator<Sight>() {
        @Override
        public Sight createFromParcel(Parcel in) {
            return new Sight(in);
        }

        @Override
        public Sight[] newArray(int size) {
            return new Sight[size];
        }
    };
}
