package co.cvmaster.studio;

import android.content.Context;
import android.view.MenuItem;
import android.view.View;
import android.widget.PopupMenu;

/**
 * Created by silve_000 on 20/08/2014.
 */
public class OnRearguardClickListener implements View.OnClickListener {

    private int handPosition;
    private Context context;
    private Player player;

    public OnRearguardClickListener(int hp, Context ctxt) {
        handPosition = hp;
        context = ctxt;
    }

    public OnRearguardClickListener(Context ctxt, Player p) {
        context = ctxt;
        player = p;
    }

    public OnRearguardClickListener(Context ctxt) {
        context = ctxt;
    }

    @Override
    public void onClick(final View v) {
        PopupMenu popupMenu = new PopupMenu(context, v);
        if (Player.getPhase().equals(Phase.MP)) {
            Player.rearguard[v.getId()] = Player.hand.remove(handPosition);
            MainActivity.rearguard[v.getId()].setImageResource(Player.rearguard[v.getId()].getDrawableResource());
            MainActivity.rearguardPower[v.getId()].setText(String.valueOf(Player.rearguard[v.getId()].getPower()));
            Field.setPositions();
            for (int i = 0; i < 5; i++) {
                MainActivity.rearguard[i].setOnClickListener(null);
            }
        } else if (Player.getPhase().equals(Phase.BP)) {
            if (!Player.rearguard[v.getId()].isResting()) {
                popupMenu.inflate(R.menu.attack);
                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        switch (item.getItemId()) {
                            case R.id.attack:
                                player.attack(false, v.getId());
                                return true;
                            case R.id.view_details:
                                Field.viewDetails("rearguard", v.getId());
                                return true;
                        }
                        return false;
                    }
                });
            } else {
                popupMenu.inflate(R.menu.view_details);
                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        switch (item.getItemId()) {
                            case R.id.view_details:
                                Field.viewDetails("rearguard", v.getId());
                                return true;
                        }
                        return false;
                    }
                });
            }
        } else {
            popupMenu.inflate(R.menu.view_details);
            popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                @Override
                public boolean onMenuItemClick(MenuItem item) {
                    switch (item.getItemId()) {
                        case R.id.view_details:
                            Field.viewDetails("rearguard", v.getId());
                            return true;
                    }
                    return false;
                }
            });
        }
        popupMenu.show();
    }
}
