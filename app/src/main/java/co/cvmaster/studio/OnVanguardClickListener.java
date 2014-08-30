package co.cvmaster.studio;

import android.content.Context;
import android.view.MenuItem;
import android.view.View;
import android.widget.PopupMenu;

/**
 * Created by silve_000 on 20/08/2014.
 */
public class OnVanguardClickListener implements View.OnClickListener {

    private Context context;
    private Player player;

    public OnVanguardClickListener(Context ctxt, Player p) {
        context = ctxt;
        player = p;
    }

    @Override
    public void onClick(final View v) {
        PopupMenu popupMenu = new PopupMenu(context, v);
        if (Player.getPhase().equals(Phase.BP)) {
            if (!Player.vanguard.isResting()) {
                popupMenu.inflate(R.menu.attack);
                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        switch (item.getItemId()) {
                            case R.id.attack:
                                player.attack(true, -1);
                                return true;
                            case R.id.view_details:
                                Field.viewDetails("vanguard", v.getId());
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
                                Field.viewDetails("vanguard", v.getId());
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
                            Field.viewDetails("vanguard", v.getId());
                            return true;
                    }
                    return false;
                }
            });
        }
        popupMenu.show();
    }
}
