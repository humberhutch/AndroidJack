package hutchison_teach.ca.androidjack;

import android.graphics.Bitmap;

/**
 * Created by Mr. Hutchison on 2016-05-27.
 */
public class Card {
    private int value;
    private String name;
    private Suit suit;
    private Bitmap cardImage;

    public Card( int aValue, String aName, Suit aSuit, Bitmap aCardImage){
        value = aValue;
        name = aName;
        suit = aSuit;
        cardImage = aCardImage;
    }
    public Bitmap getImage(){
        return cardImage;
    }

    public int getValue(){
        return value;
    }



}

