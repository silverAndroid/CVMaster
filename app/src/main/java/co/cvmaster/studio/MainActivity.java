package co.cvmaster.studio;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.google.example.games.basegameutils.BaseGameActivity;


public class MainActivity extends Activity {

    final int buttonY = 500;

    private Deck deck;
    private Database db;

    static TextView deckSize;
    static Button[] phases;
    static ImageView vanguard;
    static TextView vanguardPower;
    static ImageView enemyVanguard;
    static TextView enemyVanguardPower;
    static ImageView[] rearguard;
    static TextView[] rearguardPower;
    static ImageView[] enemyRearguard;
    static TextView[] enemyRearguardPower;
    static ImageView[] damageZone;
    static ImageView[] enemyDamageZone;
    static Player player;
    static Enemy enemy;

    RelativeLayout rl;
    Field field;

    @SuppressWarnings("ResourceType")
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        rl = new RelativeLayout(this);
        db = new Database(this);
        deck = new Deck(db, this);
        field = new Field(this);
        player = new Player(deck, this);
        enemy = new Enemy(deck, this);
        ImageView[] deckImages = new ImageView[30];
        ImageView[] enemyDeckImages = new ImageView[30];

        ImageView playingMat = new ImageView(this);
        RelativeLayout.LayoutParams playingMatParams = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT);
        playingMatParams.addRule(RelativeLayout.CENTER_IN_PARENT);
        playingMatParams.leftMargin = 25;
        playingMatParams.addRule(RelativeLayout.ALIGN_PARENT_LEFT);
        playingMatParams.height = 1100;
        playingMatParams.width = 750;
        playingMat.setImageResource(R.drawable.vanguard_mat);
        playingMat.setScaleType(ImageView.ScaleType.FIT_CENTER);
        playingMat.setLayoutParams(playingMatParams);

        rl.addView(playingMat);

        for (int i = 0; i < 30; i++) {
            deckImages[i] = new ImageView(this);
            deckImages[i].setAdjustViewBounds(true);
            deckImages[i].setX(655 + i);
            deckImages[i].setY(680 + i);
            deckImages[i].setImageResource(R.drawable.card_back);
            rl.addView(deckImages[i]);
        }

        for (int i = 0; i < 30; i++) {
            enemyDeckImages[i] = new ImageView(this);
            enemyDeckImages[i].setAdjustViewBounds(true);
            enemyDeckImages[i].setX(51 + i);
            enemyDeckImages[i].setY(304 + i);
            enemyDeckImages[i].setImageResource(R.drawable.card_back_opponent);
            rl.addView(enemyDeckImages[i]);
        }

        vanguard = new ImageView(this);
        vanguard.setAdjustViewBounds(true);
        vanguard.setX(370);
        vanguard.setY(710);
        vanguard.setOnClickListener(new OnVanguardClickListener(this, player));
        rl.addView(vanguard);
        Player.vanguard.setCard("Heroic Spirit Seeker, Mark");
        vanguard.setImageResource(Player.vanguard.getDrawableResource());

        enemyVanguard = new ImageView(this);
        enemyVanguard.setAdjustViewBounds(true);
        enemyVanguard.setX(370);
        enemyVanguard.setY(300);
        rl.addView(enemyVanguard);
        Enemy.vanguard.setCard("Genius Liberator, Woltimer");
        enemyVanguard.setImageResource(Enemy.vanguard.getDrawableResourceOpponent());
        enemyVanguard.setOnClickListener(new OnEnemyVanguardClickListener(this));

        vanguardPower = new TextView(this);
        vanguardPower.setX(365);
        vanguardPower.setY(795);
        vanguardPower.setText(String.valueOf(Player.vanguard.getPower()));
        vanguardPower.setGravity(Gravity.CENTER);
        vanguardPower.setBackgroundColor(Color.WHITE);
        rl.addView(vanguardPower, 75, 25);

        enemyVanguardPower = new TextView(this);
        enemyVanguardPower.setX(365);
        enemyVanguardPower.setY(300);
        enemyVanguardPower.setText(String.valueOf(Enemy.vanguard.getPower()));
        enemyVanguardPower.setGravity(Gravity.CENTER);
        enemyVanguardPower.setBackgroundColor(Color.WHITE);
        rl.addView(enemyVanguardPower, 75, 25);

        rearguard = new ImageView[5];
        rearguardPower = new TextView[5];
        for (int i = 0; i < 5; i++) {
            rearguard[i] = new ImageView(this);
            rearguardPower[i] = new TextView(this);
            rearguard[i].setAdjustViewBounds(true);
            if (i >= 2) {
                rearguard[i].setX(220 + ((i - 2) * 150));
                rearguardPower[i].setX(215 + ((i - 2) * 150));
                rearguard[i].setY(855);
                rearguardPower[i].setY(940);
            } else {
                rearguard[i].setX(220 + i * 300);
                rearguardPower[i].setX(215 + i * 300);
                rearguard[i].setY(710);
                rearguardPower[i].setY(795);
            }
            rearguard[i].setImageResource(R.drawable.empty);
            rearguard[i].setId(i);
            rearguard[i].setOnClickListener(new OnRearguardClickListener(this));
            rearguardPower[i].setId(i);
            rearguardPower[i].setGravity(Gravity.CENTER);
            rl.addView(rearguard[i]);
            try {
                rearguardPower[i].setText(String.valueOf(Player.rearguard[i].getPower()));
                rearguardPower[i].setBackgroundColor(Color.WHITE);
            } catch (NullPointerException npe) {

            }
            rl.addView(rearguardPower[i], 75, 25);
        }

        enemyRearguard = new ImageView[5];
        enemyRearguardPower = new TextView[5];
        for (int i = 0; i < 5; i++) {
            enemyRearguard[i] = new ImageView(this);
            enemyRearguardPower[i] = new TextView(this);
            enemyRearguard[i].setAdjustViewBounds(true);
            if (i >= 2) {
                enemyRearguard[i].setX(520 - (i - 2) * 150);
                enemyRearguard[i].setY(150);
            } else {
                enemyRearguard[i].setX(520 - i * 300);
                enemyRearguard[i].setY(300);
            }
            enemyRearguard[i].setImageResource(R.drawable.empty);
            enemyRearguard[i].setId(i);
            enemyRearguard[i].setOnClickListener(new OnEnemyRearguardClickListener(this));
            rl.addView(enemyRearguard[i]);
        }

        damageZone = new ImageView[6];
        for (int i = 0; i < 6; i++) {
            damageZone[i] = new ImageView(this);
            damageZone[i].setAdjustViewBounds(true);
            damageZone[i].setX(62);
            damageZone[i].setY(650 + i * 45);
            damageZone[i].setId(i);
            rl.addView(damageZone[i]);
        }

        enemyDamageZone = new ImageView[6];
        for (int i = 0; i < 6; i++) {
            enemyDamageZone[i] = new ImageView(this);
            enemyDamageZone[i].setAdjustViewBounds(true);
            enemyDamageZone[i].setX(640);
            enemyDamageZone[i].setY(393 - i * 45);
            enemyDamageZone[i].setId(i);
            enemyDamageZone[i].setRotation(180);
            rl.addView(enemyDamageZone[i]);
        }

        phases = new Button[6];
        for (int i = 0; i < 6; i++) {
            phases[i] = new Button(this);
            phases[i].setX(100 + i * 100);
            phases[i].setY(buttonY);
            rl.addView(phases[i]);
        }

        phases[0].setText(Phase.SP.toString());
        phases[1].setText(Phase.DP.toString());
        phases[2].setText(Phase.RP.toString());
        phases[3].setText(Phase.MP.toString());
        phases[4].setText(Phase.BP.toString());
        phases[5].setText(Phase.EP.toString());

        Player.setPhase(Phase.DP);

        deckSize = new TextView(this);
        deckSize.setX(715);
        deckSize.setY(765);
        deckSize.setText(String.valueOf(60));
        deckSize.setText(String.valueOf(Player.deck.size()));
        deckSize.setTextColor(Color.RED);
        rl.addView(deckSize);

        for (int i = 0; i < 5; i++) {
            player.draw();
            enemy.draw();
            Field.setPositions();
        }

        setContentView(rl);
    }

    @Override
    public boolean onTouchEvent(MotionEvent me) {
        int x = (int) me.getX();
        int y = (int) me.getY();

        switch (me.getAction()) {
            case MotionEvent.ACTION_UP:
                if (Player.getPhase().equals(Phase.DP)) {
                    if (x >= 650 && x <= 800) {
                        if (y >= 675 && y <= 900) {
                            player.draw();
                            Field.setPositions();
                            //Player.setPhase(Phase.RP);
                        }
                    }
                } else if (Player.getPhase().equals(Phase.EP)) {
                    if (x >= 650 && x <= 800) {
                        if (y >= 675 && y <= 900) {
                            player.takeDamage();
                        }
                    }
                }
        }
        return false;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.empty, menu);
        return true;
    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        menu.clear(); //Clear view of previous menu
        MenuInflater inflater = getMenuInflater();
        if (Player.getPhase().equals(Phase.RP)) {
            inflater.inflate(R.menu.phase_mp_bp_ep_options, menu);
            return true;
        } else if (Player.getPhase().equals(Phase.MP)) {
            inflater.inflate(R.menu.phase_bp_ep_options, menu);
            return true;
        } else if (Player.getPhase().equals(Phase.BP)) {
            inflater.inflate(R.menu.phase_ep_options, menu);
            for (int i = 0; i < 2; i++) {
                MainActivity.rearguard[i].setOnClickListener(new OnRearguardClickListener(this, player));
            }
            return true;
        } else {
            inflater.inflate(R.menu.empty, menu);
        }
        return super.onPrepareOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.main_phase:
                Player.setPhase(Phase.MP);
                return true;
            case R.id.battle_phase:
                Player.setPhase(Phase.BP);
                for (int i = 0; i < 5; i++) {
                    //rearguard[i].setOnClickListener(new OnRearguardClickListener(this, ));
                }
                return true;
            case R.id.end_phase:
                Player.setPhase(Phase.EP);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        phases = null;
        vanguard = null;
        vanguardPower = null;
        rearguard = null;
        rearguardPower = null;
        field = null;
        deck = null;
        db = null;
        field = null;
    }
}
