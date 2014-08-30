package co.cvmaster.studio;

import android.content.Context;
import android.view.MenuItem;
import android.view.View;
import android.widget.PopupMenu;

/**
 * Created by silve_000 on 20/08/2014.
 */
public class OnHandClickListener implements View.OnClickListener {

    private Context context;
    private Player player;

    public OnHandClickListener(Context ctxt, Player p) {
        context = ctxt;
        player = p;
    }
    @Override
    public void onClick(final View v) {
        PopupMenu popupMenu = new PopupMenu(context, v);
        if (Player.getPhase().equals(Phase.RP)) {
            if (Player.hand.get(v.getId()).getGrade() == Player.vanguard.getGrade() || Player.hand.get(v.getId()).getGrade() == Player.vanguard.getGrade() + 1)
                popupMenu.inflate(R.menu.ride);
            else
                popupMenu.inflate(R.menu.view_details);
        } else if (Player.getPhase().equals(Phase.MP)) {
            if (Player.hand.get(v.getId()).getGrade() <= Player.vanguard.getGrade())
                popupMenu.inflate(R.menu.call);
            else
                popupMenu.inflate(R.menu.view_details);
        } else {
            popupMenu.inflate(R.menu.view_details);
        }
        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.ride:
                        player.ride(v.getId());
                        return true;
                    case R.id.call:
                        player.call(v.getId());
                        return true;
                    case R.id.view_details:
                        Field.viewDetails("hand", v.getId());
                        return true;
                }
                return false;
            }
        });
        popupMenu.show();
    }
}
