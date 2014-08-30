package co.cvmaster.studio;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.graphics.Color;
import android.view.View;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by silve_000 on 20/08/2014.
 */
public class Player {

    private static MainActivity mainActivity;

    static ArrayList<Card> deck;
    static ArrayList<Card> hand;
    static ImageView[] handImages;
    static Card vanguard;
    static Card[] rearguard;
    Card[] damageZone;
    int damage = 0;
    static Phase phase;

    public Player(Deck d, MainActivity ma) {
        mainActivity = ma;
        deck = d.deck;
        hand = new ArrayList<Card>();
        handImages = new ImageView[50];
        vanguard = new Card();
        rearguard = new Card[5];
        damageZone = new Card[6];
        shuffle();
    }

    public void draw() {
        try {
            hand.add(deck.remove(0));
            MainActivity.deckSize.setText(String.valueOf(60));
            MainActivity.deckSize.setText(String.valueOf(deck.size()));
            MainActivity.deckSize.setTextColor(Color.RED);
        } catch (ArrayIndexOutOfBoundsException aioobe) {
            aioobe.printStackTrace();
        } catch (IndexOutOfBoundsException ioobe) {
            ioobe.printStackTrace();
        }
    }

    public void takeDamage() {
        try {
            damageZone[damage] = deck.remove(0);
            MainActivity.damageZone[damage].setImageResource(damageZone[damage].getDrawableResourceRest());
            damage++;
        } catch (ArrayIndexOutOfBoundsException aioobe) {
            AlertDialog.Builder builder = new AlertDialog.Builder(mainActivity);
            builder.setMessage("You have taken 6 damage and lost.")
                    .setTitle("You Lost!")
                    .setPositiveButton("Exit", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            mainActivity.finish();
                        }
                    });
            AlertDialog dialog = builder.create();
            dialog.show();
        }
    }


    public void shuffle() {
        Collections.shuffle(deck);
    }

    public static Card searchDeck(String name) {
        Card card = null;

        for (Card c : deck) {
            try {
                if (c.getName() != null && c.getName().equals(name)) {
                    int index = deck.indexOf(c);
                    card = deck.get(index);
                    deck.remove(index);
                    break;
                }
            } catch (NullPointerException npe) {
            }
        }

        return card;
    }

    public void ride(int handPosition) {
        vanguard.setCard(hand.remove(handPosition).getName());
        MainActivity.vanguard.setImageResource(vanguard.getDrawableResource());
        MainActivity.vanguardPower.setText(String.valueOf(vanguard.getPower()));
        setPhase(Phase.MP);
        Field.setPositions();
    }

    public void call(int handPosition) {
        for (int i = 0; i < 5; i++) {
            MainActivity.rearguard[i].setOnClickListener(new OnRearguardClickListener(handPosition, mainActivity));
        }
    }

    public void attack(boolean vanguardAttacking, int rearguardPosition) {
        if (vanguardAttacking) {
            MainActivity.enemyVanguard.setOnClickListener(new OnEnemyVanguardClickListener(vanguardAttacking, rearguardPosition, mainActivity));
            for (int i = 0; i < 2; i++) {
                MainActivity.enemyRearguard[i].setOnClickListener(new OnEnemyRearguardClickListener(vanguardAttacking, rearguardPosition, mainActivity));
            }
        } else {
            this.rearguard[rearguardPosition].setResting(true);
            MainActivity.rearguard[rearguardPosition].setImageResource(this.rearguard[rearguardPosition].getDrawableResourceRest());
            MainActivity.enemyVanguard.setOnClickListener(new OnEnemyVanguardClickListener(vanguardAttacking, rearguardPosition, mainActivity));
            for (int i = 0; i < 2; i++) {
                MainActivity.enemyRearguard[i].setOnClickListener(new OnEnemyRearguardClickListener(vanguardAttacking, rearguardPosition, mainActivity));
            }
        }
    }

    public static Phase getPhase() {
        return phase;
    }

    public static void setPhase(Phase p) {
        phase = p;
        for (int i = 0; i < 6; i++) {
            MainActivity.phases[i].setVisibility(View.INVISIBLE);
            if (MainActivity.phases[i].getText() == phase.toString()) {
                MainActivity.phases[i].setVisibility(View.VISIBLE);
                MainActivity.phases[i].setEnabled(false);
                MainActivity.phases[i].setTextColor(Color.BLUE);
                mainActivity.invalidateOptionsMenu();
            }
        }
        if (phase == Phase.RP) {
            if (vanguard.isResting()) {
                MainActivity.vanguard.setImageResource(vanguard.getDrawableResource());
                vanguard.setResting(false);
            }
            for (int i = 0; i < 5; i++) {
                if (rearguard[i].isResting()) {
                    MainActivity.rearguard[i].setImageResource(rearguard[i].getDrawableResource());
                    rearguard[i].setResting(false);
                }
            }
            setPhase(Phase.DP);
        }  else if (phase == Phase.EP) {
            Field.setTurn(false);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ie) {
                ie.printStackTrace();
            }
            Enemy.setPhase(Phase.RP);
        }
    }
}
