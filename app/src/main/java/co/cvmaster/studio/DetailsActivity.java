package co.cvmaster.studio;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.SpannableString;
import android.widget.ImageView;
import android.widget.TextView;


public class DetailsActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        ImageView imageCard = (ImageView) findViewById(R.id.image_card);
        TextView txtName = (TextView) findViewById(R.id.txtName);
        TextView txtGrade = (TextView) findViewById(R.id.txtGrade);
        TextView txtClan_SkillIconEffect_IsTrigger = (TextView) findViewById(R.id.txtClanSkillIconEffectIsTrigger);
        TextView txtSkill = (TextView) findViewById(R.id.txtSkill);
        Card cardDetails = null;

        Bundle extras = getIntent().getExtras();
        if (extras == null) {
            throw new NullPointerException("Failed to get any details");
        }

        String location = extras.getString("location");
        int position = extras.getInt("position");

        if (location.equals("hand"))
            cardDetails = Player.hand.get(position);
        else if (location.equals("vanguard"))
            cardDetails = Player.vanguard;
        else if (location.equals("rearguard"))
            cardDetails = Player.rearguard[position];
        else if (location.equals("enemyVanguard"))
            cardDetails = Enemy.vanguard;
        else if (location.equals("enemyRearguard"))
            cardDetails = Enemy.rearguard[position];

        imageCard.setImageResource(cardDetails.getDrawableResourceBig());
        txtName.setText(cardDetails.getName());
        txtGrade.setText("Grade " + String.valueOf(cardDetails.getGrade()));
        if (cardDetails.getTriggerType() != null)
            txtClan_SkillIconEffect_IsTrigger.setText(cardDetails.getClan() + "/" + cardDetails.getSkillIconEffect() + "/" + cardDetails.getTriggerType());
        else
            txtClan_SkillIconEffect_IsTrigger.setText(cardDetails.getClan() + "/" + cardDetails.getSkillIconEffect());

        Drawable drawableLeftMargin = getResources().getDrawable(cardDetails.getDrawableResourceBig());
        int leftMargin = drawableLeftMargin.getIntrinsicWidth() + 10;
        try {
            SpannableString ss = new SpannableString(cardDetails.getSkill());
            ss.setSpan(new TextSurroundImage(6, leftMargin), 0, ss.length(), 0);
            txtSkill.setText(ss);
        } catch (NullPointerException npe) {

        }
    }
}
