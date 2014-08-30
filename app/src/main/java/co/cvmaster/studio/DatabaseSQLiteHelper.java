package co.cvmaster.studio;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.LinkedList;
import java.util.List;

class DatabaseSQLiteHelper extends SQLiteOpenHelper {

    private static final int VERSION = 1;
    private static final String NAME = "CardDB";

    private static final String TABLE_CARDS = "cards";

    private static final String KEY_ID = "id";
    private static final String KEY_NAME = "name";
    private static final String KEY_SKILL = "skill";
    private static final String KEY_SKILL_EFFECT_ICON = "skillIconEffect";
    private static final String KEY_GRADE = "grade";
    private static final String KEY_CLAN = "clan";
    private static final String KEY_IS_TRIGGER = "isTrigger";
    private static final String KEY_PATH = "path";
    private static final String KEY_PATH_BIG = "pathBig";
    private static final String KEY_PATH_REST = "pathRest";
    private static final String KEY_PATH_OPPONENT = "pathOpponent";
    private static final String KEY_POWER = "power";
    private static final String KEY_SHIELD = "shield";

    private static final String[] COLUMNS = {KEY_ID, KEY_NAME, KEY_SKILL, KEY_SKILL_EFFECT_ICON, KEY_CLAN, KEY_IS_TRIGGER, KEY_GRADE, KEY_PATH, KEY_PATH_BIG,
            KEY_PATH_REST, KEY_PATH_OPPONENT, KEY_POWER, KEY_SHIELD};

    public DatabaseSQLiteHelper(Context c) {
        super(c, NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // TODO Auto-generated method stub
        String CREATE_CARD_TABLE = "CREATE TABLE cards ( " + "id INTEGER PRIMARY KEY, " + "name TEXT, " + "skill TEXT, " + "skillIconEffect TEXT, " + "clan TEXT, "
                + "isTrigger TEXT, " + "grade INTEGER, " + "path INTEGER, " + "pathBig INTEGER, " + "pathRest INTEGER, " + "pathOpponent INTEGER, "
                + "power INTEGER, " + "shield INTEGER )";

        db.execSQL(CREATE_CARD_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // TODO Auto-generated method stub
        db.execSQL("DROP TABLE IF EXISTS cards");

        onCreate(db);
    }

    public void addCard(Card card) {

        SQLiteDatabase db = getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_NAME, card.getName());
        values.put(KEY_SKILL, card.getSkill());
        values.put(KEY_SKILL_EFFECT_ICON, card.getSkillIconEffect());
        values.put(KEY_GRADE, card.getGrade());
        values.put(KEY_CLAN, card.getClan());
        values.put(KEY_IS_TRIGGER, card.getTriggerType());
        values.put(KEY_PATH, card.getDrawableResource());
        values.put(KEY_PATH_BIG, card.getDrawableResourceBig());
        values.put(KEY_PATH_REST, card.getDrawableResourceRest());
        values.put(KEY_PATH_OPPONENT, card.getDrawableResourceOpponent());
        values.put(KEY_POWER, card.getPower());
        values.put(KEY_SHIELD, card.getShield());

        db.insert(TABLE_CARDS, null, values);

        db.close();
    }

    public Card getCard(int i) {
        SQLiteDatabase db = getReadableDatabase();

        Cursor cursor = db.query(TABLE_CARDS, COLUMNS, "id = ?", new String[]{String.valueOf(i)}, null, null, null);

        if (cursor != null)
            cursor.moveToFirst();

        Card card = new Card();
        assert cursor != null;
        card.setId(Integer.parseInt(cursor.getString(0)));
        card.setName(cursor.getString(1));
        card.setSkill(cursor.getString(2));
        card.setSkillIconEffect(cursor.getString(3));
        card.setClan(cursor.getString(4));
        card.setTriggerType(cursor.getString(5));
        card.setGrade(Integer.parseInt(cursor.getString(6)));
        card.setDrawableResource(Integer.parseInt(cursor.getString(7)));
        card.setDrawableResourceBig(Integer.parseInt(cursor.getString(8)));
        card.setDrawableResourceRest(Integer.parseInt(cursor.getString(9)));
        card.setDrawableResourceOpponent(Integer.parseInt(cursor.getString(10)));
        card.setPower(Integer.parseInt(cursor.getString(11)));
        card.setShield(Integer.parseInt(cursor.getString(12)));

        return card;
    }

    public List<Card> getDatabase() {
        List<Card> deck = new LinkedList<Card>();

        String query = "SELECT * FROM " + TABLE_CARDS;

        SQLiteDatabase db = getWritableDatabase();
        Cursor cursor = db.rawQuery(query, null);

        Card card;
        if (cursor.moveToFirst()) {
            do {
                card = new Card();
                card.setId(Integer.parseInt(cursor.getString(0)));
                card.setName(cursor.getString(1));
                card.setSkill(cursor.getString(2));
                card.setSkillIconEffect(cursor.getString(3));
                card.setClan(cursor.getString(4));
                card.setTriggerType(cursor.getString(5));
                card.setGrade(Integer.parseInt(cursor.getString(6)));
                card.setDrawableResource(Integer.parseInt(cursor.getString(7)));
                card.setDrawableResourceBig(Integer.parseInt(cursor.getString(8)));
                card.setDrawableResourceRest(Integer.parseInt(cursor.getString(9)));
                card.setDrawableResourceOpponent(Integer.parseInt(cursor.getString(10)));
                card.setPower(Integer.parseInt(cursor.getString(11)));
                card.setShield(Integer.parseInt(cursor.getString(12)));

                deck.add(card);
            } while (cursor.moveToNext());
        }

        return deck;
    }
}
