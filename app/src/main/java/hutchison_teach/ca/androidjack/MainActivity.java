package hutchison_teach.ca.androidjack;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {
    private Button btnHit,btnStick;
    private ImageView imCard1, imCard2, imCard3, imCard4, imCard5;
    private Deck deck;
    private Hand hand;
    private Hand dealer;
    private int MAX_CARDS=5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        imCard1 = (ImageView) findViewById(R.id.card_1);
        imCard2 = (ImageView) findViewById(R.id.card_2);
        imCard3 = (ImageView) findViewById(R.id.card_3);
        imCard4 = (ImageView) findViewById(R.id.card_4);
        imCard5 = (ImageView) findViewById(R.id.card_5);

        deck = new Deck(this);
        hand = new Hand();

        btnHit = (Button) findViewById(R.id.btn_hit);
        btnStick = (Button) findViewById(R.id.btn_stick);

        btnHit.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){

                if (hand.numCards()<= MAX_CARDS && hand.value()<=21) {

                    hand.add(deck.takeCard());
                    Card card = hand.lastCard();
                    if (hand.numCards() == 1) {
                        imCard1.setImageBitmap(card.getImage());
                    } else if (hand.numCards() == 2) {
                        imCard2.setImageBitmap(card.getImage());
                    } else if (hand.numCards() == 3) {
                        imCard3.setImageBitmap(card.getImage());
                    } else if (hand.numCards() == 4) {
                        imCard4.setImageBitmap(card.getImage());
                    } else if (hand.numCards() == 5) {
                        imCard5.setImageBitmap(card.getImage());
                    }
                }
                if (hand.value()>21){
                    Toast.makeText(MainActivity.this, "BUSTED: The hand is worth " + String.valueOf(hand.value()),Toast.LENGTH_LONG).show() ;
                }
                else if (hand.value()==21){
                    Toast.makeText(MainActivity.this, "BlackJack!!",Toast.LENGTH_LONG).show() ;
                    btnStick.setVisibility(View.INVISIBLE);
                }
                else {
                    Toast.makeText(MainActivity.this, "Your hand is worth " + String.valueOf(hand.value()),Toast.LENGTH_LONG).show() ;
                }

            }
        });

        btnStick.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                btnHit.setVisibility(View.INVISIBLE);
                btnStick.setVisibility(View.INVISIBLE);
                boolean done=false;
                dealer = new Hand();
                dealer.add(deck.takeCard()); // get first card
                while (!done){
                    if (dealer.value()<17){
                        dealer.add(deck.takeCard());
                    }
                    else {
                        done = true;
                    }
                }
                if (dealer.value()<22 && (dealer.value()>hand.value())){
                    Toast.makeText(MainActivity.this, "Dealer Won with a hand worth " + String.valueOf(hand.value()),Toast.LENGTH_LONG).show() ;
                }
                else if (dealer.value()>21){
                    Toast.makeText(MainActivity.this, "Dealer BUSTED!!",Toast.LENGTH_LONG).show() ;
                }
                else {
                    Toast.makeText(MainActivity.this, "Dealer Wins with BlackJack!!",Toast.LENGTH_LONG).show() ;
                }
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
