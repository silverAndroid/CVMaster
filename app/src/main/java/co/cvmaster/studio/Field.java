package co.cvmaster.studio;

import android.annotation.TargetApi;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.widget.ImageView;

/**
 * Created by Rushil Perera on 31/07/2014.
 */

public class Field {

    static double playerHandY;
    static double enemyHandY;
    static boolean playerTurn;

    private static MainActivity ma;

    public Field(MainActivity mainActivity) {
        ma = mainActivity;
        playerHandY = 120074.95679177726695889909275865 * (MainActivity.densityFactor / 160); //1000px
        enemyHandY = 1200.7495679177726695889909275865 * (MainActivity.densityFactor / 160); //10px
    }

    public static void viewDetails(String location, int position) {
        Intent intent = new Intent(ma, DetailsActivity.class);
        intent.putExtra("location", location);
        intent.putExtra("position", position);
        ma.startActivity(intent);
    }

    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    public static void setPositions() {

        for (int i = 0; i < 5; i++) {
            if (MainActivity.rearguardPower[i].getText() == null || MainActivity.rearguardPower[i].getText() == "") {
                MainActivity.rearguardPower[i].setBackground(null);
            } else {
                MainActivity.rearguardPower[i].setBackgroundColor(Color.WHITE);
            }
        }

        for (int i = 0; i < 5; i++) {
            if (MainActivity.enemyRearguardPower[i].getText() == null || MainActivity.enemyRearguardPower[i].getText() == "") {
                MainActivity.enemyRearguardPower[i].setBackground(null);
            } else {
                MainActivity.enemyRearguardPower[i].setBackgroundColor(Color.WHITE);
            }
        }

        for (int i = 0; i <= Player.hand.size(); i++) {
            try {
                int tempImageX = (int) (((400 - (Player.hand.size() * 25)) / 0.00832813125) * (MainActivity.densityFactor / 160));
                if (Player.handImages[i] == null)
                    Player.handImages[i] = new ImageView(ma);
                if (Player.hand.size() == 0)
                    Player.handImages[i].setImageDrawable(null);
                else {
                    try {
                        Player.handImages[i].setImageResource(Player.hand.get(i).getDrawableResource());
                    } catch (NullPointerException npe) {

                    }
                }
                try {
                    Player.handImages[i + 1].setImageDrawable(null);
                } catch (ArrayIndexOutOfBoundsException aioobe) {
                    break;
                } catch (NullPointerException npe) {

                }
                if (i == 0)
                    Player.handImages[i].setX(tempImageX);
                else
                    Player.handImages[i].setX(tempImageX + (50 * i));
                Player.handImages[i].setY((float) playerHandY);
                Player.handImages[i].setId(i);
                Player.handImages[i].setAdjustViewBounds(true);
                Player.handImages[i].setOnClickListener(new OnHandClickListener(ma, MainActivity.player));
                MainActivity.rl.addView(Player.handImages[i]);
            } catch (IndexOutOfBoundsException ioobe) {
                break;
            } catch (IllegalStateException ise) {
                MainActivity.rl.removeView(Player.handImages[i]);
                MainActivity.rl.addView(Player.handImages[i]);
            }
            ma.setContentView(MainActivity.rl);
        }

        for (int i = 0; i < Enemy.hand.size(); i++) {
            try {
                int tempImageX = (int) (((400 - (Enemy.hand.size() * 25)) / 0.00832813125) * (MainActivity.densityFactor / 160));
                if (Enemy.handImages[i] == null)
                    Enemy.handImages[i] = new ImageView(ma);
                if (Enemy.hand.size() == 0)
                    Enemy.handImages[i].setImageDrawable(null);
                else {
                    try {
                        Enemy.handImages[i].setImageResource(Enemy.hand.get(i).getDrawableResource());
                    } catch (NullPointerException npe) {

                    }
                }
                try {
                    Enemy.handImages[i + 1].setImageDrawable(null);
                } catch (ArrayIndexOutOfBoundsException aioobe) {
                    break;
                } catch (NullPointerException npe) {

                }
                if (i == 0)
                    Enemy.handImages[i].setX(tempImageX);
                else
                    Enemy.handImages[i].setX(tempImageX + (50 * i));
                Enemy.handImages[i].setY((float) enemyHandY);
                Enemy.handImages[i].setId(i);
                Enemy.handImages[i].setAdjustViewBounds(true);
                MainActivity.rl.addView(Enemy.handImages[i]);
            } catch (IndexOutOfBoundsException ioobe) {
                break;
            } catch (IllegalStateException ise) {
                MainActivity.rl.removeView(Enemy.handImages[i]);
                MainActivity.rl.addView(Enemy.handImages[i]);
            }
        }
    }

    public static boolean isPlayerTurn() {
        return playerTurn;
    }

    public static void setTurn(boolean playerTurn) {
        Field.playerTurn = playerTurn;
    }
}
