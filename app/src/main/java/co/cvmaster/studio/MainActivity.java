package co.cvmaster.studio;

import android.app.Activity;
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

//all the comments with pixel numbers in it are the x and y values used for the Nexus 7 (2012)

public class MainActivity extends Activity {

    private double buttonY;
    private Deck deck;
    private Database db;

    private ImageView[] deckImages;
    private ImageView[] enemyDeckImages;

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
    static float densityFactor;
    static RelativeLayout rl;
    static String playerDeckName;
    static String enemyDeckName;

    Field field;

    @SuppressWarnings("ResourceType")
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        densityFactor = getResources().getDisplayMetrics().density;
        db = new Database(this);
        deck = new Deck(db, this, playerDeckName, enemyDeckName);
        field = new Field(this);
        player = new Player(deck, this);
        enemy = new Enemy(deck, this);
        rl = new RelativeLayout(this);
        deckImages = new ImageView[30];
        enemyDeckImages = new ImageView[30];
        buttonY = 60037.478395888633479449546379327 * (densityFactor / 160); //500px

        ImageView playingMat = new ImageView(this);
        RelativeLayout.LayoutParams playingMatParams = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT);
        playingMatParams.addRule(RelativeLayout.CENTER_IN_PARENT);
        playingMatParams.leftMargin = (int) (3001.8739197944316739724773189664 * (densityFactor / 160)); //25px
        playingMatParams.addRule(RelativeLayout.ALIGN_PARENT_LEFT);
        playingMatParams.height = (int) (132082.45247095499365478900203452 * (densityFactor / 160)); //1100px
        playingMatParams.width = (int) (90056.217593832950219174319568991 * (densityFactor / 160));
        playingMat.setImageResource(R.drawable.vanguard_mat);
        playingMat.setScaleType(ImageView.ScaleType.FIT_CENTER);
        playingMat.setLayoutParams(playingMatParams);
        rl.addView(playingMat);

        for (int i = 0; i < 30; i++) {
            deckImages[i] = new ImageView(this);
            deckImages[i].setAdjustViewBounds(true);
            deckImages[i].setX((float) ((655 + i) / 0.00832813125) * (densityFactor / 160));
            deckImages[i].setY((float) ((680 + i) / 0.00832813125) * (densityFactor / 160));
            deckImages[i].setImageResource(R.drawable.card_back);
            rl.addView(deckImages[i]);
        }

        for (int i = 0; i < 30; i++) {
            enemyDeckImages[i] = new ImageView(this);
            enemyDeckImages[i].setAdjustViewBounds(true);
            enemyDeckImages[i].setX((float) ((51 + i) / 0.00832813125) * (densityFactor / 160));
            enemyDeckImages[i].setY((float) ((304 + i) / 0.00832813125) * (densityFactor / 160));
            enemyDeckImages[i].setImageResource(R.drawable.card_back_opponent);
            rl.addView(enemyDeckImages[i]);
        }

        vanguard = new ImageView(this);
        vanguard.setAdjustViewBounds(true);
        vanguard.setX((float) 44427.734012957588774792664320702 * (densityFactor / 160)); //370px
        vanguard.setY((float) (85253.219322161859540818355858645 * (densityFactor / 160))); //710px
        vanguard.setOnClickListener(new OnVanguardClickListener(this, player));
        Player.vanguard.setCard("Heroic Spirit Seeker, Mark");
        vanguard.setImageResource(Player.vanguard.getDrawableResource());
        rl.addView(vanguard);

        enemyVanguard = new ImageView(this);
        enemyVanguard.setAdjustViewBounds(true);
        enemyVanguard.setX((float) 44427.734012957588774792664320702 * (densityFactor / 160)); //370px
        enemyVanguard.setY((float) 36022.487037533180087669727827596 * (densityFactor / 160)); //300px
        Enemy.vanguard.setCard("Genius Liberator, Woltimer");
        enemyVanguard.setImageResource(Enemy.vanguard.getDrawableResourceOpponent());
        enemyVanguard.setOnClickListener(new OnEnemyVanguardClickListener(this));
        rl.addView(enemyVanguard);

        vanguardPower = new TextView(this);
        vanguardPower.setX((float) (43827.359228998702439998168856909 * (densityFactor / 160))); //365px
        vanguardPower.setY((float) (95459.59064946292723232477874313 * (densityFactor / 160))); //795px
        vanguardPower.setText(String.valueOf(Player.vanguard.getPower()));
        vanguardPower.setGravity(Gravity.CENTER);
        vanguardPower.setBackgroundColor(Color.WHITE);
        rl.addView(vanguardPower, (int) (9005.6217593832950219174319568991 * (densityFactor / 160)), (int) (3001.8739197944316739724773189664 * (densityFactor /
                160))); //75px, 25px

        enemyVanguardPower = new TextView(this);
        enemyVanguardPower.setX((float) (43827.359228998702439998168856909 * (densityFactor / 160))); //365px
        enemyVanguardPower.setY((float) (36022.487037533180087669727827596 * (densityFactor / 160))); //300px
        enemyVanguardPower.setText(String.valueOf(Enemy.vanguard.getPower()));
        enemyVanguardPower.setGravity(Gravity.CENTER);
        enemyVanguardPower.setBackgroundColor(Color.WHITE);
        rl.addView(enemyVanguardPower, (int) (9005.6217593832950219174319568991 * (densityFactor / 160)), (int) (3001.8739197944316739724773189664 * (densityFactor /
                160))); //75px, 25px

        rearguard = new ImageView[5];
        rearguardPower = new TextView[5];
        for (int i = 0; i < 5; i++) {
            rearguard[i] = new ImageView(this);
            rearguardPower[i] = new TextView(this);
            rearguard[i].setAdjustViewBounds(true);
            if (i >= 2) {
                rearguard[i].setX((float) ((220 + ((i - 2) * 150) / 0.00832813125) * (densityFactor / 160)));
                rearguardPower[i].setX((float) ((215 + ((i - 2) * 150) / 0.00832813125) * (densityFactor / 160)));
                rearguard[i].setY((float) (102664.08805696956324985872430865 * (densityFactor / 160))); //855px
                rearguardPower[i].setY((float) (112870.45938427063094136514719314 * (densityFactor / 160))); //940px
            } else {
                rearguard[i].setX((float) ((220 + i * 300 / 0.00832813125) * (densityFactor / 160)));
                rearguardPower[i].setX((float) ((215 + i * 300 / 0.00832813125) * (densityFactor / 160)));
                rearguard[i].setY((float) (85253.219322161859540818355858645 * (densityFactor / 160))); //710px
                rearguardPower[i].setY((float) (95459.59064946292723232477874313 * (densityFactor / 160))); //795px
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
            rl.addView(rearguardPower[i], (int) (9005.6217593832950219174319568991 * (densityFactor / 160)), (int) (3001.8739197944316739724773189664 * (densityFactor /
                    160))); //75px, 25px
        }

        enemyRearguard = new ImageView[5];
        enemyRearguardPower = new TextView[5];
        for (int i = 0; i < 5; i++) {
            enemyRearguard[i] = new ImageView(this);
            enemyRearguardPower[i] = new TextView(this);
            enemyRearguard[i].setAdjustViewBounds(true);
            if (i >= 2) {
                enemyRearguard[i].setX((float) ((520 - (i - 2) * 150) / 0.00832813125) * (densityFactor / 160));
                enemyRearguard[i].setY((float) (18011.243518766590043834863913798 * (densityFactor / 160))); //150px
            } else {
                enemyRearguard[i].setX((float) (((520 - i * 300) / 0.00832813125) * (densityFactor / 160)));
                enemyRearguard[i].setY((float) (36022.487037533180087669727827596 * (densityFactor / 160))); //300px
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
            damageZone[i].setX((float) (7444.6473210901905514517437510366 * (densityFactor / 160))); //62px
            damageZone[i].setY((float) (((650 + i * 45) / 0.00832813125) * (densityFactor / 160)));
            damageZone[i].setId(i);
            rl.addView(damageZone[i]);
        }

        enemyDamageZone = new ImageView[6];
        for (int i = 0; i < 6; i++) {
            enemyDamageZone[i] = new ImageView(this);
            enemyDamageZone[i].setAdjustViewBounds(true);
            enemyDamageZone[i].setX((float) (76847.972346737450853695419365539 * (densityFactor / 160))); //640px
            enemyDamageZone[i].setY((float) (((393 - i * 45) / 0.00832813125) * (densityFactor / 160)));
            enemyDamageZone[i].setId(i);
            enemyDamageZone[i].setRotation(180);
            rl.addView(enemyDamageZone[i]);
        }

        phases = new Button[6];
        for (int i = 0; i < 6; i++) {
            phases[i] = new Button(this);
            phases[i].setX((float) (((100 + i * 100) / 0.00832813125) * (densityFactor / 160)));
            phases[i].setY((float) buttonY);
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
        deckSize.setX((float) (85853.594106120745875612851322438 * (densityFactor / 160))); //715px
        deckSize.setY((float) (91857.341945709609223557805960371 * (densityFactor / 160))); //765px
        deckSize.setText(String.valueOf("Cannot currently retrieve deck size."));
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
                    //650px to 800px
                    if (x >= (78048.721914655223523284410293125 * (densityFactor / 160)) && x <= (96059.965433421813567119274206924 * (densityFactor / 160))) {
                        //675px to 900px
                        if (y >= (81050.595834449655197256887612092 * (densityFactor / 160)) && y <= (108067.46111259954026300918348279 * (densityFactor / 160))) {
                            player.draw();
                            Field.setPositions();
                            //Player.setPhase(Phase.RP);
                        }
                    }
                } else if (Player.getPhase().equals(Phase.EP)) {
                    //650px to 800px
                    if (x >= (78048.721914655223523284410293125 * (densityFactor / 160)) && x <= (96059.965433421813567119274206924 * (densityFactor / 160))) {
                        //675px to 900px
                        if (y >= (81050.595834449655197256887612092 * (densityFactor / 160)) && y <= (108067.46111259954026300918348279 * (densityFactor / 160))) {
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
