package co.cvmaster.studio;

import android.content.Context;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.PopupMenu;

/**
 * Created by silve_000 on 21/08/2014.
 */
public class OnEnemyVanguardClickListener implements View.OnClickListener {

    private Context context;
    private boolean vanguardAttacking; //boolean to check if the vanguard is attacking
    private int rearguardAttackingPosition; //variable for position of the rearguard that is attacking enemy

    public OnEnemyVanguardClickListener(boolean va, int rap, Context ctxt) {
        vanguardAttacking = va;
        rearguardAttackingPosition = rap;
        context = ctxt;
    }

    public OnEnemyVanguardClickListener(Context ctxt) {
        context = ctxt;
    }

    @Override
    public void onClick(final View v) {
        PopupMenu popupMenu = new PopupMenu(context, v);
        if (Player.getPhase().equals(Phase.BP)) {
            Player.vanguard.setResting(true);
            MainActivity.vanguard.setImageResource(Player.vanguard.getDrawableResourceRest());
            if (vanguardAttacking) {
                if (Player.vanguard.getPower() >= Enemy.vanguard.getPower()) {
                    Enemy.takeDamage();
                } else {
                    Log.d("attack", "attack failed");
                }
            } else if (!vanguardAttacking) {
                if (Player.rearguard[rearguardAttackingPosition].getPower() >= Enemy.vanguard.getPower()) {
                    Enemy.takeDamage();
                } else {
                    Log.d("attack", "attack failed");
                }
            } else {
                popupMenu.inflate(R.menu.view_details);
                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        switch (item.getItemId()) {
                            case R.id.view_details:
                                Field.viewDetails("enemyVanguard", v.getId());
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
                            Field.viewDetails("enemyVanguard", v.getId());
                            return true;
                    }
                    return false;
                }
            });
        }
        popupMenu.show();
    }
}
