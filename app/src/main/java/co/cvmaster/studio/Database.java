package co.cvmaster.studio;

import android.content.Context;

import java.util.List;

/**
 * Created by Rushil Perera on 31/07/2014.
 */
public class Database {

    private static DatabaseSQLiteHelper dbSQLite;

    public Database(Context c) {
        dbSQLite = new DatabaseSQLiteHelper(c);
    }

    static List<Card> create() {

        dbSQLite.addCard(new Card("Bluish Flame Liberator, Percival", "[ACT](VC): Legion 20000 \"Liberator of Oath, " +
                "Aglovale\" (If your opponent has a grade 3 or greater vanguard, only once, this unit may return four cards from your drop zone to your deck, " +
                "and search your deck for the specified card, and perform Legion.)\n[AUTO](VC):When this unit performs Legion, " +
                "look at four cards from the top of your deck, search for up to one card with \"Liberator\" in its card name, call it to an open (RC), " +
                "and put the rest on the bottom of your deck in any order.\n [AUTO](VC):When this unit attacks a vanguard, " +
                "this unit gets [Power]+2000 until end of that battle.", SkillIconEffect.TWIN_DRIVE.toString(), Clan.GOLD_PALADIN.toString(), 3,
                R.drawable.td16_001, R.drawable.td16_001_big, R.drawable.td16_001_rest, R.drawable.td16_001_opponent, 11000, Shield.ZERO.toInt()));

        dbSQLite.addCard(new Card("Liberator of Vigor, Kadvan", "[AUTO](VC/RC):[Counter Blast (1)] When this unit attacks, you may pay the cost. If you do, " +
                "this unit gets [Power]+3000 until end of that battle.", SkillIconEffect.TWIN_DRIVE.toString(), Clan.GOLD_PALADIN.toString(), 3,
                R.drawable.td16_002, R.drawable.td16_002_big, R.drawable.td16_002_rest, R.drawable.td16_002_opponent, 10000, Shield.ZERO.toInt()));

        dbSQLite.addCard(new Card("Liberator, Blue Flame Dragon", "[ACT](VC): Legion 20000 \"Unbending Liberator, " +
                "Keredic\" (If your opponent has a grade 3 or greater vanguard, only once, this unit may return four cards from your drop zone to your deck, " +
                "and search your deck for the specified card, and perform Legion.)\n[AUTO](VC):When this unit attacks a vanguard, if this unit is in Legion, " +
                "this unit gets [Power]+5000 until end of that battle.\n[AUTO](RC):When this unit attacks a vanguard, " +
                "this unit gets [Power]+2000 until end of that battle.", SkillIconEffect.TWIN_DRIVE.toString(), Clan.GOLD_PALADIN.toString(), 3,
                R.drawable.td16_003, R.drawable.td16_003_big, R.drawable.td16_003_rest, R.drawable.td16_003_opponent, 10000, Shield.ZERO.toInt()));

        dbSQLite.addCard(new Card("Unbending Liberator, Keredic", null, SkillIconEffect.INTERCEPT.toString(), Clan.GOLD_PALADIN.toString(), 2,
                R.drawable.td16_004, R.drawable.td16_004_big, R.drawable.td16_004_rest, R.drawable.td16_004_opponent, 10000, Shield.FIVE.toInt()));

        dbSQLite.addCard(new Card("Liberator of Royalty, Phallon", "[AUTO](RC):When this unit attacks, if you have a vanguard with \"Liberator\" in its card name," +
                " this unit gets [Power]+3000 until end of that battle.", SkillIconEffect.INTERCEPT.toString(), Clan.GOLD_PALADIN.toString(), 2,
                R.drawable.td16_005, R.drawable.td16_005_big, R.drawable.td16_005_rest, R.drawable.td16_005_opponent, 9000, Shield.FIVE.toInt()));

        dbSQLite.addCard(new Card("Liberator of Oath, Aglovale", "[AUTO]:[Counter Blast (1)] When this unit is placed on (RC), " +
                "if you have a vanguard with \"Liberator\" in its card name, you may pay the cost. If you do, look at three cards from the top of your deck, " +
                "search for up to one card with \"Liberator\" in its card name, call it to an open (RC), and put the rest on the bottom of your deck in any order" +
                ".", SkillIconEffect.INTERCEPT.toString(), Clan.GOLD_PALADIN.toString(), 2, R.drawable.td16_006, R.drawable.td16_006_big,
                R.drawable.td16_006_rest, R.drawable.td16_006_opponent, 9000, Shield.FIVE.toInt()));

        dbSQLite.addCard(new Card("Liberator of Preparation, Caradox", "[AUTO]:When this unit intercepts, this card gets [Shield]+5000 until end of that battle.",
                SkillIconEffect.INTERCEPT.toString(), Clan.GOLD_PALADIN.toString(), 2, R.drawable.td16_007, R.drawable.td16_007_big, R.drawable.td16_007_rest,
                R.drawable.td16_007_opponent, 8000, Shield.FIVE.toInt()));

        dbSQLite.addCard(new Card("Huntgal Liberator", "[AUTO](RC):When this unit attacks, if your vanguard is in Legion, " +
                "this unit gets [Power]+4000 until end of that battle.", SkillIconEffect.INTERCEPT.toString(), Clan.GOLD_PALADIN.toString(), 2,
                R.drawable.td16_008, R.drawable.td16_008_big, R.drawable.td16_008_rest, R.drawable.td16_008_opponent, 8000, Shield.FIVE.toInt()));

        dbSQLite.addCard(new Card("Opposing Liberator, Polyus", "[AUTO]:[Choose a card from your hand, and discard it] When this unit is placed on (RC), " +
                "if the number of other vanguards and/or rear-guards you have with \"Liberator\" in its card name is four or more, " +
                "you may pay the cost. If you do, draw a card.", SkillIconEffect.BOOST.toString(), Clan.GOLD_PALADIN.toString(), 1, R.drawable.td16_009,
                R.drawable.td16_009_big, R.drawable.td16_009_rest, R.drawable.td16_009_opponent, 7000, Shield.FIVE.toInt()));

        dbSQLite.addCard(new Card("Liberator of Quiet, Cador", "[ACT](VC/RC):[Counter Blast (1)] This unit gets [Power]+1000 until end of turn.",
                SkillIconEffect.BOOST.toString(), Clan.GOLD_PALADIN.toString(), 1, R.drawable.td16_010, R.drawable.td16_010_big, R.drawable.td16_010_rest,
                R.drawable.td16_010_opponent, 7000, Shield.FIVE.toInt()));

        dbSQLite.addCard(new Card("Little Liberator, Marron", "[AUTO](RC):When this unit attacks, if you have a vanguard with \"Liberator\" in its card name, " +
                "this unit gets [Power]+3000 until end of that battle.", SkillIconEffect.BOOST.toString(), Clan.GOLD_PALADIN.toString(), 1, R.drawable.td16_011,
                R.drawable.td16_011_big, R.drawable.td16_011_rest, R.drawable.td16_011_opponent, 7000, Shield.FIVE.toInt()));

        dbSQLite.addCard(new Card("Boardgal Liberator", "[AUTO](RC):When this unit boosts a vanguard, if your vanguard is in Legion, " +
                "the boosted unit gets [Power]+4000 until end of that battle.", SkillIconEffect.BOOST.toString(), Clan.GOLD_PALADIN.toString(), 1,
                R.drawable.td16_012, R.drawable.td16_012_big, R.drawable.td16_012_rest, R.drawable.td16_012_opponent, 6000, Shield.FIVE.toInt()));

        dbSQLite.addCard(new Card("Genius Liberator, Woltimer", "[AUTO]: Forerunner (When a unit of the same clan rides this unit, " +
                "you may call this unit to (RC))\n[AUTO](RC): When this unit boosts, if the number other vanguards and/or rear-guards you have with \"Liberator\"" +
                " in its card name is four or more, the boosted unit gets [Power]+3000 until end of that battle.", SkillIconEffect.BOOST.toString(),
                Clan.GOLD_PALADIN.toString(), 0, R.drawable.td16_013, R.drawable.td16_013_big, R.drawable.td16_013_rest, R.drawable.td16_013_opponent, 5000,
                Shield.TEN.toInt()));

        dbSQLite.addCard(new Card("Liberator of Ambition, Asus", null, SkillIconEffect.BOOST.toString(), Clan.GOLD_PALADIN.toString(),
                Trigger.CRITICAL.toString(), 0, R.drawable.td16_014, R.drawable.td16_014_big, R.drawable.td16_014_rest, R.drawable.td16_014_opponent, 5000,
                Shield.TEN.toInt()));

        dbSQLite.addCard(new Card("Liberator, Lucky Charmy", null, SkillIconEffect.BOOST.toString(), Clan.GOLD_PALADIN.toString(), Trigger.DRAW.toString(), 0,
                R.drawable.td16_015, R.drawable.td16_015_big, R.drawable.td16_015_rest, R.drawable.td16_015_opponent, 5000, Shield.FIVE.toInt()));

        dbSQLite.addCard(new Card("Wise Liberator, Yuron", null, SkillIconEffect.BOOST.toString(), Clan.GOLD_PALADIN.toString(), Trigger.STAND.toString(), 0,
                R.drawable.td16_016, R.drawable.td16_016_big, R.drawable.td16_016_rest, R.drawable.td16_016_opponent, 5000, Shield.TEN.toInt()));

        dbSQLite.addCard(new Card("Liberator of Holy Tree, Elkia", null, SkillIconEffect.BOOST.toString(), Clan.GOLD_PALADIN.toString(), Trigger.HEAL.toString(),
                0, R.drawable.td16_017, R.drawable.td16_017_big, R.drawable.td16_017_rest, R.drawable.td16_017_opponent, 5000, Shield.TEN.toInt()));

        dbSQLite.addCard(new Card("Seeker Sacred Wingal", "[ACT](VC): Legion 20000  \"Blaster Blade Seeker\" (If your opponent has a grade 3 or greater " +
                "vanguard, only once, this unit may return four cards from your drop zone to your deck, " +
                "and search your deck for the specified card, and perform Legion.)\n[AUTO](VC):When this unit performs Legion, " +
                "search your deck for up to one grade 2 or greater card with \"Seeker\" in its card name, call it to (RC), " +
                "and shuffle your deck.\n[AUTO](VC):When this unit attacks a vanguard, this unit gets [Power]+2000 until end of that battle.",
                SkillIconEffect.TWIN_DRIVE.toString(), Clan.ROYAL_PALADIN.toString(), 3, R.drawable.td14_001, R.drawable.td14_001_big,
                R.drawable.td14_001_rest, R.drawable.td14_001_opponent, 11000, Shield.ZERO.toInt()));

        dbSQLite.addCard(new Card("Secret Sword Seeker, Vortigern", "[ACT](VC): Legion 20000 \"Natural Talent Seeker, " +
                "\"Valrod\" (If your opponent has a grade 3 or greater vanguard, only once, this unit may return four cards from your drop zone to your deck, " +
                "and search your deck for the specified card, and perform Legion.)\n[AUTO](VC):When this unit attacks a vanguard, if this unit is in Legion, " +
                "this unit gets [Power]+5000 until end of that battle.\n[AUTO](RC):When this unit attacks a vanguard, " +
                "this unit gets [Power]+2000 until end of that battle.", SkillIconEffect.TWIN_DRIVE.toString(), Clan.ROYAL_PALADIN.toString(), 3,
                R.drawable.td14_002, R.drawable.td14_002_big, R.drawable.td14_002_rest, R.drawable.td14_002_opponent, 10000, Shield.ZERO.toInt()));

        dbSQLite.addCard(new Card("Blue Flame Seeker, Taranis", "[AUTO](VC/RC):[Counter Blast (1)] When this unit attacks, you may pay the cost. If you do, " +
                "this unit gets [Power]+3000 until end of that battle.", SkillIconEffect.TWIN_DRIVE.toString(), Clan.ROYAL_PALADIN.toString(), 3,
                R.drawable.td14_003, R.drawable.td14_003_big, R.drawable.td14_003_rest, R.drawable.td14_003_opponent, 10000, Shield.ZERO.toInt()));

        dbSQLite.addCard(new Card("Natural Talent Seeker, Valrod", null, SkillIconEffect.INTERCEPT.toString(), Clan.ROYAL_PALADIN.toString(), 2,
                R.drawable.td14_004, R.drawable.td14_004_big, R.drawable.td14_004_rest, R.drawable.td14_004_opponent, 10000, Shield.FIVE.toInt()));

        dbSQLite.addCard(new Card("Blaster Blade Seeker", "[AUTO]:[Counter Blast (1)] When this unit is placed on (RC), " +
                "if you have a vanguard with \"Seeker\" in its card name, you may pay the cost. If you do, choose one of your opponent's grade 2 or greater " +
                "rear-guards, and retire it.", SkillIconEffect.INTERCEPT.toString(), Clan.ROYAL_PALADIN.toString(), 2, R.drawable.td14_005,
                R.drawable.td14_005_big, R.drawable.td14_005_rest, R.drawable.td14_005_opponent, 9000, Shield.FIVE.toInt()));

        dbSQLite.addCard(new Card("Full Bloom Seeker, Cerdic", "[AUTO](RC):When this unit attacks, if you have a vanguard with \"Seeker\" in its card name, " +
                "this unit gets [Power]+3000 until end of that battle.", SkillIconEffect.INTERCEPT.toString(), Clan.ROYAL_PALADIN.toString(), 2,
                R.drawable.td14_006, R.drawable.td14_006_big, R.drawable.td14_006_rest, R.drawable.td14_006_opponent, 9000, Shield.FIVE.toInt()));

        dbSQLite.addCard(new Card("Provocation Seeker, Blumenthal", "[AUTO](RC): When this unit attacks, if your vanguard is in Legion, " +
                "this unit gets [Power]+4000 until end of that battle.", SkillIconEffect.INTERCEPT.toString(), Clan.ROYAL_PALADIN.toString(), 2,
                R.drawable.td14_007, R.drawable.td14_007_big, R.drawable.td14_007_rest, R.drawable.td14_007_opponent, 8000, Shield.FIVE.toInt()));

        dbSQLite.addCard(new Card("Vladgal Seeker", "[AUTO]:When this unit intercepts, this card gets [Shield]+5000 until end of that battle.",
                SkillIconEffect.INTERCEPT.toString(), Clan.ROYAL_PALADIN.toString(), 2, R.drawable.td14_008, R.drawable.td14_008_big,
                R.drawable.td14_008_rest, R.drawable.td14_008_opponent, 8000, Shield.FIVE.toInt()));

        dbSQLite.addCard(new Card("Seeker, Youthful Mage", "[ACT](VC/RC):[Counter Blast (1)] This unit gets [Power]+1000 until end of turn.",
                SkillIconEffect.BOOST.toString(), Clan.ROYAL_PALADIN.toString(), 1, R.drawable.td14_009, R.drawable.td14_009_big, R.drawable.td14_009_rest,
                R.drawable.td14_009_opponent, 7000, Shield.FIVE.toInt()));

        dbSQLite.addCard(new Card("Good Faith Seeker, Cynric", "[AUTO](RC):When this unit attacks, if you have a vanguard with \"Seeker\" in its card name, " +
                "this unit gets [Power]+3000 until end of that battle.", SkillIconEffect.BOOST.toString(), Clan.ROYAL_PALADIN.toString(), 1,
                R.drawable.td14_010, R.drawable.td14_010_big, R.drawable.td14_010_rest, R.drawable.td14_010_opponent, 7000, Shield.FIVE.toInt()));

        dbSQLite.addCard(new Card("Seeker of the Right Path, Gangalen", "[AUTO](RC):When this unit attacks a vanguard, " +
                "this unit gets [Power]+2000 until end of that battle.", SkillIconEffect.BOOST.toString(), Clan.ROYAL_PALADIN.toString(), 1,
                R.drawable.td14_011, R.drawable.td14_011_big, R.drawable.td14_011_rest, R.drawable.td14_011_opponent, 7000, Shield.FIVE.toInt()));

        dbSQLite.addCard(new Card("Seeker, Rune Eagle", "[AUTO](RC):When this unit boosts a vanguard, if your vanguard is in Legion, " +
                "the boosted unit gets [Power]+4000 until end of that battle.", SkillIconEffect.BOOST.toString(), Clan.ROYAL_PALADIN.toString(), 1,
                R.drawable.td14_012, R.drawable.td14_012_big, R.drawable.td14_012_rest, R.drawable.td14_012_opponent, 6000, Shield.FIVE.toInt()));

        dbSQLite.addCard(new Card("Heroic Spirit Seeker, Mark", null, SkillIconEffect.BOOST.toString(), Clan.ROYAL_PALADIN.toString(), null, 0,
                R.drawable.td14_013, R.drawable.td14_013_big, R.drawable.td14_013_rest, R.drawable.td14_013_opponent, 6000, Shield.TEN.toInt()));

        dbSQLite.addCard(new Card("Certain Kill Seeker, Modron", null, SkillIconEffect.BOOST.toString(), Clan.ROYAL_PALADIN.toString(),
                Trigger.CRITICAL.toString(), 0, R.drawable.td14_014, R.drawable.td14_014_big, R.drawable.td14_014_rest, R.drawable.td14_014_opponent, 5000,
                Shield.TEN.toInt()));

        dbSQLite.addCard(new Card("Messegal Seeker", null, SkillIconEffect.BOOST.toString(), Clan.ROYAL_PALADIN.toString(), Trigger.DRAW.toString(), 0,
                R.drawable.td14_015, R.drawable.td14_015_big, R.drawable.td14_015_rest, R.drawable.td14_015_opponent, 5000, Shield.FIVE.toInt()));

        dbSQLite.addCard(new Card("Warning Seeker, Maris", null, SkillIconEffect.BOOST.toString(), Clan.ROYAL_PALADIN.toString(), Trigger.STAND.toString(), 0,
                R.drawable.td14_016, R.drawable.td14_016_big, R.drawable.td14_016_rest, R.drawable.td14_016_opponent, 5000, Shield.TEN.toInt()));

        dbSQLite.addCard(new Card("Seeker, Loving Healer", null, SkillIconEffect.BOOST.toString(), Clan.ROYAL_PALADIN.toString(), Trigger.HEAL.toString(), 0,
                R.drawable.td14_017, R.drawable.td14_017_big, R.drawable.td14_017_rest, R.drawable.td14_017_opponent, 5000, Shield.TEN.toInt()));

        return dbSQLite.getDatabase();
    }

    public static Card getCardFromDatabase(String name) {
        Card card = null;
        List<Card> database = create();

        for (Card c : database) {
            if (c.getName() != null && c.getName().equals(name)) {
                int index = database.indexOf(c);
                card = database.get(index);
                break;
            }
        }

        return card;
    }

    public void shutdown() {
        dbSQLite.close();
    }
}
