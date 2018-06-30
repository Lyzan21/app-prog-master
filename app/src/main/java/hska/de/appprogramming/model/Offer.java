package hska.de.appprogramming.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;

/**
 * This class represents a Offer with title all details and an image
 * This class needs to implement Parcelable because objects of this class are needed
 * for communication between the activities
 *
 * Created by Alina on 06.05.2018.
 */

public class Offer implements Parcelable {

    public String title;
    public int imageResource;
    public Category category;

    public String teacher;
    public String room;

    //normal constructor
    public Offer(String title, int resource, Category category, String room, String teacher) {
       this.title = title;
       this.imageResource = resource;
       this.category = category;

       this.room = room;
       this.teacher = teacher;
    }

    // ** this is stuff from the Parcelable interface  **
    public static final Parcelable.Creator CREATOR = new Parcelable.Creator() {
        public Offer createFromParcel(Parcel in) {
            return new Offer(in);
        }


        public Offer[] newArray(int size) {
            return new Offer[size];
        }
    };

    //Parcel constructor
    public Offer(Parcel in) {
        //TODO implement Parcel constructor.
        //title = in.readString();
    }

    @Override
    public int describeContents() {
        //TODO implement this method
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        //TODO implement parcel writing.
        //dest.writeString(title);
    }
}
