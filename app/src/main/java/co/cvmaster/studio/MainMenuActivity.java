package co.cvmaster.studio;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.gms.games.Games;
import com.google.android.gms.games.GamesStatusCodes;
import com.google.android.gms.games.multiplayer.Participant;
import com.google.android.gms.games.multiplayer.realtime.RealTimeMessage;
import com.google.android.gms.games.multiplayer.realtime.RealTimeMessageReceivedListener;
import com.google.android.gms.games.multiplayer.realtime.Room;
import com.google.android.gms.games.multiplayer.realtime.RoomConfig;
import com.google.android.gms.games.multiplayer.realtime.RoomStatusUpdateListener;
import com.google.android.gms.games.multiplayer.realtime.RoomUpdateListener;
import com.google.example.games.basegameutils.BaseGameActivity;

import java.io.File;
import java.util.ArrayList;
import java.util.List;


public class MainMenuActivity extends BaseGameActivity implements View.OnClickListener, RoomUpdateListener, RoomStatusUpdateListener,
        RealTimeMessageReceivedListener {

    private Button btnSignIn;
    private Button btnSignOut;
    private Button btnQuickFight;

    final static int RC_SELECT_PLAYERS = 10000;
    final static int RC_INVITATION_INBOX = 10001;
    final static int RC_WAITING_ROOM = 10002;

    String mRoomId = null;
    ArrayList<Participant> opponents = null;
    String mMyId = null;
    Spinner deckList;
    ArrayList<String> deckListNames;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);

        setRequestedClients(BaseGameActivity.CLIENT_GAMES | BaseGameActivity.CLIENT_APPSTATE);

        mHelper = getGameHelper();

        mHelper.beginUserInitiatedSignIn();
        mHelper.enableDebugLog(true);

        btnSignIn = (Button) findViewById(R.id.btn_sign_in);
        btnSignIn.setOnClickListener(this);

        btnSignOut = (Button) findViewById(R.id.btn_sign_out);
        btnSignOut.setOnClickListener(this);

        btnQuickFight = (Button) findViewById(R.id.btn_quick_fight);
        btnQuickFight.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btn_sign_in) {
            beginUserInitiatedSignIn();
        } else if (v.getId() == R.id.btn_sign_out) {
            signOut();
            btnSignIn.setVisibility(View.VISIBLE);
            btnSignOut.setVisibility(View.GONE);
        } else if (v.getId() == R.id.btn_quick_fight) {
            if (isSignedIn()) {
                // custom dialog
                final Dialog dialog = new Dialog(this);
                dialog.setContentView(R.layout.activity_deck_select);
                dialog.setTitle("Select a Deck");

                deckList = (Spinner) dialog.findViewById(R.id.deck_names);
                deckListNames = new ArrayList<String>();

                File deck = new File(this.getFilesDir().getPath());
                File[] deckFiles;
                if (deck.listFiles() != null) {
                    deckFiles = deck.listFiles();
                } else {
                    throw new NullPointerException("No Files located");
                }

                for (int i = 0; i < deckFiles.length; i++) {
                    if (!deckFiles[i].getName().equals("Database"))
                        deckListNames.add(deckFiles[i].getName().replace(".txt", ""));

                    Log.d("deckFiles", deckFiles[i].getName());
                    Log.d("deckListNames", deckListNames.get(i));
                }

                ArrayAdapter<String> stringArrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, deckListNames);
                deckList.setAdapter(stringArrayAdapter);
                deckList.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                        Toast.makeText(MainMenuActivity.this, deckListNames.get(position), Toast.LENGTH_SHORT).show();
                        MainActivity.playerDeckName = deckListNames.get(position);
                        startQuickGame();
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {

                    }
                });

                dialog.show();
            } else {
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setMessage("You must sign-in in order to access this feature.")
                        .setTitle("Sign-in Required!")
                        .setPositiveButton("Sign in", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                beginUserInitiatedSignIn();
                            }
                        })
                        .setNegativeButton("Forget it", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                finish();
                            }
                        });
                AlertDialog dialog = builder.create();
                dialog.show();
            }
        }
    }

    public void startQuickGame() {
        // auto-match criteria to invite one random automatch opponent.
        // You can also specify more opponents (up to 3).
        Bundle am = RoomConfig.createAutoMatchCriteria(1, 1, 0);
        Log.d("startQuickGame", "Bundle created");

        // build the room config:
        RoomConfig.Builder roomConfigBuilder = makeBasicRoomConfigBuilder();
        Log.d("startQuickGame", "makeBasicRoomConfigBuilder()");
        roomConfigBuilder.setAutoMatchCriteria(am);
        RoomConfig roomConfig = roomConfigBuilder.build();
        Log.d("startQuickGame", "Instantiate RoomConfig");

        Games.RealTimeMultiplayer.create(getApiClient(), roomConfig);
        Log.d("startQuickGame", "Game Created");

        // prevent screen from sleeping during handshake
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
    }

    private RoomConfig.Builder makeBasicRoomConfigBuilder() {
        RoomConfig.Builder builder = RoomConfig.builder(this);
        builder.setMessageReceivedListener(this);
        builder.setRoomStatusUpdateListener(this);

        // ...add other listeners as needed...

        return builder;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onSignInFailed() {
        btnSignIn.setVisibility(View.VISIBLE);
        btnSignOut.setVisibility(View.GONE);
    }

    @Override
    public void onSignInSucceeded() {
        btnSignIn.setVisibility(View.GONE);
        btnSignOut.setVisibility(View.VISIBLE);
    }

    @Override
    protected void onStart() {
        super.onStart();
        mHelper.onStart(this);
    }

    @Override
    protected void onStop() {
        super.onStop();
        mHelper.onStop();
    }

    @Override
    protected void onActivityResult(int request, int response, Intent data) {
        super.onActivityResult(request, response, data);
        mHelper.onActivityResult(request, response, data);
    }

    @Override
    public void onRoomCreated(int i, Room room) {
        if (i != GamesStatusCodes.STATUS_OK) {
            throw new IllegalStateException("onRoomCreated, status " + i);
        }
        Intent iMultiplayer = Games.RealTimeMultiplayer.getWaitingRoomIntent(getApiClient(), room, Integer.MAX_VALUE);
        startActivityForResult(iMultiplayer, RC_WAITING_ROOM);
        Log.d("onRoomCreated", "Opening Waiting Room");
    }

    @Override
    public void onJoinedRoom(int i, Room room) {
        if (i != GamesStatusCodes.STATUS_OK) {
            throw new IllegalStateException("onJoinedRoom, status " + i);
        }
        Intent iMultiplayer = Games.RealTimeMultiplayer.getWaitingRoomIntent(getApiClient(), room, Integer.MAX_VALUE);
        startActivityForResult(iMultiplayer, RC_WAITING_ROOM);
        Log.d("onJoinedRoom", "Opening Waiting Room");
    }

    @Override
    public void onLeftRoom(int i, String s) {

    }

    @Override
    public void onRoomConnected(int i, Room room) {
        if (i != GamesStatusCodes.STATUS_OK) {
            throw new IllegalStateException("onRoomConnected, status " + i);
        }
        updateRoom(room);
    }

    @Override
    public void onRealTimeMessageReceived(RealTimeMessage realTimeMessage) {
        byte[] buf = realTimeMessage.getMessageData();
        String sender = realTimeMessage.getSenderParticipantId();
        Log.d("onRealTimeMessageReceived", "Message received: " + (char) buf[0] + "/" + (int) buf[1]);
    }

    @Override
    public void onRoomConnecting(Room room) {
        updateRoom(room);
    }

    @Override
    public void onRoomAutoMatching(Room room) {
        updateRoom(room);
    }

    @Override
    public void onPeerInvitedToRoom(Room room, List<String> strings) {
        updateRoom(room);
    }

    @Override
    public void onPeerDeclined(Room room, List<String> strings) {
        updateRoom(room);
    }

    @Override
    public void onPeerJoined(Room room, List<String> strings) {
        updateRoom(room);
    }

    @Override
    public void onPeerLeft(Room room, List<String> strings) {
        updateRoom(room);
    }

    @Override
    public void onConnectedToRoom(Room room) {

        mRoomId = room.getRoomId();
        mMyId = room.getParticipantId(Games.Players.getCurrentPlayerId(getApiClient()));
        opponents = room.getParticipants();

        Log.d("onConnectedToRoom", mRoomId);
        Log.d("onConnectedToRoom", mMyId);
        Log.d("onConnectedToRoom", "<< CONNECTED TO ROOM >>");

        Intent iMA = new Intent(this, MainActivity.class);
        startActivity(iMA);
    }

    @Override
    public void onDisconnectedFromRoom(Room room) {
        mRoomId = null;
        showAlert("Disconnected", "Disconnected from room");
        Log.d("onDisconnectedFromRoom", "Disconnected from room");
    }

    @Override
    public void onPeersConnected(Room room, List<String> strings) {
        updateRoom(room);
    }

    @Override
    public void onPeersDisconnected(Room room, List<String> strings) {
        updateRoom(room);
    }

    @Override
    public void onP2PConnected(String s) {

    }

    @Override
    public void onP2PDisconnected(String s) {

    }

    public void updateRoom(Room room) {
        if (room != null) {
            opponents = room.getParticipants();
            Log.d("updateRoom", "Getting Number of Opponents");
        }
    }
}
