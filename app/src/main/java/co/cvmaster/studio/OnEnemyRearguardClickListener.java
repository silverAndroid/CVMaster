package co.cvmaster.studio;

import android.content.Context;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.PopupMenu;

/**
 * Created by silve_000 on 21/08/2014.
 */
public class OnEnemyRearguardClickListener implements View.OnClickListener {

    private boolean vanguardAttacking;
    private int rearguardAttackingPosition;
    private Context context;

    public OnEnemyRearguardClickListener(boolean va, int rap, Context ctxt) {
        vanguardAttacking = va;
        rearguardAttackingPosition = rap;
        context = ctxt;
    }

    public OnEnemyRearguardClickListener(Context ctxt) {
        context = ctxt;
    }

    @Override
    public void onClick(final View v) {
        PopupMenu popupMenu = new PopupMenu(context, v);
        if (Player.getPhase().equals(Phase.BP)) {
            if (vanguardAttacking) {
                if (Player.vanguard.getPower() >= Enemy.rearguard[v.getId()].getPower()) {
                    Enemy.rearguard[v.getId()] = null;
                } else {
                    Log.d("attack", "attack failed");
                }
            } else if (!vanguardAttacking) {
                if (Player.rearguard[rearguardAttackingPosition].getPower() >= Enemy.rearguard[v.getId()].getPower()) {
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
                                Field.viewDetails("enemyRearguard", v.getId());
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
                            Field.viewDetails("enemyRearguard", v.getId());
                            return true;
                    }
                    return false;
                }
            });
        }
        popupMenu.show();
    }
}
