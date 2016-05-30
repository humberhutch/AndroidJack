package hutchison_teach.ca.androidjack;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;


import java.util.ArrayList;
import java.util.Random;

/**
 * Created by Mr. Hutchison on 2016-05-27.
 */
public class Deck {

    private ArrayList<Card> cards;
    private Context context;

    public Deck(Context ctx){
        cards = new ArrayList<>();
        context = ctx;
        String tmpName="";
        int [] rIDs = {R.mipmap.d_1, R.mipmap.d_2, R.mipmap.d_3,R.mipmap.d_4,R.mipmap.d_5,R.mipmap.d_6,R.mipmap.d_7,R.mipmap.d_8,R.mipmap.d_9
        ,R.mipmap.d_10,R.mipmap.d_11,R.mipmap.d_12,R.mipmap.d_13};
        int val=0;
        for (int i = 0; i< rIDs.length; i++) {
            Bitmap cardBMP = BitmapFactory.decodeResource(context.getResources(), rIDs[i]);
            switch (i){
            case 0:
                tmpName="Ace";
                val=1;
                break;
            case 1:
                tmpName = "Two";
                val=2;
                break;
            case 2:
                tmpName = "Three";
                val=3;
                break;
            case 3:
                tmpName = "Four";
                val=4;
                break;
            case 4:
                tmpName = "Five";
                val=5;
                break;
            case 5:
                tmpName = "Six";
                val=6;
                break;
            case 6:
                tmpName = "Seven";
                val=7;
                break;
            case 7:
                tmpName = "Eight";
                val=8;
                break;
            case 8:
                tmpName = "Nine";
                val=9;
                break;
            case 9:
                tmpName = "Ten";
                val=10;
                break;
            case 10:
                tmpName = "Jack";
                val=10;
                break;
            case 11:
                tmpName = "Queen";
                val=10;
                break;
            case 12:
                tmpName = "King";
                val=10;
                break;

            }

            Card card = new Card(val, tmpName, Suit.Diamonds, cardBMP);
            cards.add(card);
        }
    }
    public Card takeCard(){
        Random rnd = new Random();
        int index = rnd.nextInt(cards.size());
        Card card = cards.get(index);
        cards.remove(index);
        return card;
    }
}
