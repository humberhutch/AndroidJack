package hutchison_teach.ca.androidjack;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Created by Mr. Hutchison on 2016-05-27.
 */
public class Hand {
    private ArrayList<Card> cards;

    public Hand() {
        cards = new ArrayList<Card>();
    }

    public void add(Card card) {
        cards.add(card);
    }

    public int value() {
        int value = 0;
        for (Card card : cards) {
            value += card.getValue();
        }
        return value;
    }
    public Card lastCard(){
        return cards.get(cards.size()-1);
    }
    public int numCards(){
        return cards.size();
    }
}

