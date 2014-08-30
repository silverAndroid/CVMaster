package co.cvmaster.studio;

import android.content.Context;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

/**
 * Created by Rushil Perera on 31/07/2014.
 */
public class Deck {

    private Database db;
    private Context context;
    ArrayList<Card> deck;
    ArrayList<Card> enemyDeck;

    public Deck(Database database, Context c) {
        db = database;
        context = c;
        deck = new ArrayList<Card>();
        enemyDeck = new ArrayList<Card>();
        create();
    }

    public void create() {
        File[] file = {new File(context.getFilesDir().getPath() + "/Royal Paladin.txt"), new File(context.getFilesDir().getPath() + "/Gold Paladin.txt")};
        try {
            if (!file[0].exists()) {
                deck.add(db.getCardFromDatabase("Seeker, Sacred Wingal"));
                deck.add(db.getCardFromDatabase("Secret Sword Seeker, Vortigern"));
                deck.add(db.getCardFromDatabase("Secret Sword Seeker, Vortigern"));
                deck.add(db.getCardFromDatabase("Blue Flame Seeker, Taranis"));
                deck.add(db.getCardFromDatabase("Blue Flame Seeker, Taranis"));
                deck.add(db.getCardFromDatabase("Blue Flame Seeker, Taranis"));
                deck.add(db.getCardFromDatabase("Blue Flame Seeker, Taranis"));
                deck.add(db.getCardFromDatabase("Natural Talent Seeker, Valrod"));
                deck.add(db.getCardFromDatabase("Natural Talent Seeker, Valrod"));
                deck.add(db.getCardFromDatabase("Natural Talent Seeker, Valrod"));
                deck.add(db.getCardFromDatabase("Natural Talent Seeker, Valrod"));
                deck.add(db.getCardFromDatabase("Blaster Blade Seeker"));
                deck.add(db.getCardFromDatabase("Full Bloom Seeker, Cerdic"));
                deck.add(db.getCardFromDatabase("Provocation Seeker, Blumenthal"));
                deck.add(db.getCardFromDatabase("Provocation Seeker, Blumenthal"));
                deck.add(db.getCardFromDatabase("Provocation Seeker, Blumenthal"));
                deck.add(db.getCardFromDatabase("Provocation Seeker, Blumenthal"));
                deck.add(db.getCardFromDatabase("Vladgal Seeker"));
                deck.add(db.getCardFromDatabase("Vladgal Seeker"));
                deck.add(db.getCardFromDatabase("Seeker, Youthful Mage"));
                deck.add(db.getCardFromDatabase("Seeker, Youthful Mage"));
                deck.add(db.getCardFromDatabase("Seeker, Youthful Mage"));
                deck.add(db.getCardFromDatabase("Seeker, Youthful Mage"));
                deck.add(db.getCardFromDatabase("Good Faith Seeker, Cynric"));
                deck.add(db.getCardFromDatabase("Good Faith Seeker, Cynric"));
                deck.add(db.getCardFromDatabase("Good Faith Seeker, Cynric"));
                deck.add(db.getCardFromDatabase("Good Faith Seeker, Cynric"));
                deck.add(db.getCardFromDatabase("Seeker of the Right Path, Gangalen"));
                deck.add(db.getCardFromDatabase("Seeker of the Right Path, Gangalen"));
                deck.add(db.getCardFromDatabase("Seeker of the Right Path, Gangalen"));
                deck.add(db.getCardFromDatabase("Seeker of the Right Path, Gangalen"));
                deck.add(db.getCardFromDatabase("Seeker, Rune Eagle"));
                deck.add(db.getCardFromDatabase("Seeker, Rune Eagle"));
                deck.add(db.getCardFromDatabase("Heroic Spirit Seeker, Mark"));
                deck.add(db.getCardFromDatabase("Certain Kill Seeker, Modron"));
                deck.add(db.getCardFromDatabase("Certain Kill Seeker, Modron"));
                deck.add(db.getCardFromDatabase("Certain Kill Seeker, Modron"));
                deck.add(db.getCardFromDatabase("Certain Kill Seeker, Modron"));
                deck.add(db.getCardFromDatabase("Messegal Seeker"));
                deck.add(db.getCardFromDatabase("Messegal Seeker"));
                deck.add(db.getCardFromDatabase("Messegal Seeker"));
                deck.add(db.getCardFromDatabase("Messegal Seeker"));
                deck.add(db.getCardFromDatabase("Warning Seeker, Maris"));
                deck.add(db.getCardFromDatabase("Warning Seeker, Maris"));
                deck.add(db.getCardFromDatabase("Warning Seeker, Maris"));
                deck.add(db.getCardFromDatabase("Warning Seeker, Maris"));
                deck.add(db.getCardFromDatabase("Seeker, Loving Healer"));
                deck.add(db.getCardFromDatabase("Seeker, Loving Healer"));
                deck.add(db.getCardFromDatabase("Seeker, Loving Healer"));
                deck.add(db.getCardFromDatabase("Seeker, Loving Healer"));
            }
            if (!file[1].exists()) {
                enemyDeck.add(db.getCardFromDatabase("Bluish Flame Liberator, Percival"));
                enemyDeck.add(db.getCardFromDatabase("Liberator of Vigor, Kadvan"));
                enemyDeck.add(db.getCardFromDatabase("Liberator of Vigor, Kadvan"));
                enemyDeck.add(db.getCardFromDatabase("Liberator of Vigor, Kadvan"));
                enemyDeck.add(db.getCardFromDatabase("Liberator of Vigor, Kadvan"));
                enemyDeck.add(db.getCardFromDatabase("Liberator, Blue Flame Dragon"));
                enemyDeck.add(db.getCardFromDatabase("Liberator, Blue Flame Dragon"));
                enemyDeck.add(db.getCardFromDatabase("Unbending Liberator, Keredic"));
                enemyDeck.add(db.getCardFromDatabase("Unbending Liberator, Keredic"));
                enemyDeck.add(db.getCardFromDatabase("Unbending Liberator, Keredic"));
                enemyDeck.add(db.getCardFromDatabase("Unbending Liberator, Keredic"));
                enemyDeck.add(db.getCardFromDatabase("Liberator of Royalty, Phallon"));
                enemyDeck.add(db.getCardFromDatabase("Liberator of Oath, Aglovale"));
                enemyDeck.add(db.getCardFromDatabase("Liberator of Preparation, Caradox"));
                enemyDeck.add(db.getCardFromDatabase("Liberator of Preparation, Caradox"));
                enemyDeck.add(db.getCardFromDatabase("Liberator of Preparation, Caradox"));
                enemyDeck.add(db.getCardFromDatabase("Liberator of Preparation, Caradox"));
                enemyDeck.add(db.getCardFromDatabase("Huntgal Liberator"));
                enemyDeck.add(db.getCardFromDatabase("Huntgal Liberator"));
                enemyDeck.add(db.getCardFromDatabase("Opposing Liberator, Polyus"));
                enemyDeck.add(db.getCardFromDatabase("Opposing Liberator, Polyus"));
                enemyDeck.add(db.getCardFromDatabase("Opposing Liberator, Polyus"));
                enemyDeck.add(db.getCardFromDatabase("Opposing Liberator, Polyus"));
                enemyDeck.add(db.getCardFromDatabase("Liberator of Quiet, Cador"));
                enemyDeck.add(db.getCardFromDatabase("Liberator of Quiet, Cador"));
                enemyDeck.add(db.getCardFromDatabase("Liberator of Quiet, Cador"));
                enemyDeck.add(db.getCardFromDatabase("Liberator of Quiet, Cador"));
                enemyDeck.add(db.getCardFromDatabase("Little Liberator, Marron"));
                enemyDeck.add(db.getCardFromDatabase("Little Liberator, Marron"));
                enemyDeck.add(db.getCardFromDatabase("Little Liberator, Marron"));
                enemyDeck.add(db.getCardFromDatabase("Little Liberator, Marron"));
                enemyDeck.add(db.getCardFromDatabase("Boardgal Liberator"));
                enemyDeck.add(db.getCardFromDatabase("Boardgal Liberator"));
                enemyDeck.add(db.getCardFromDatabase("Genius Liberator, Woltimer"));
                enemyDeck.add(db.getCardFromDatabase("Liberator of Ambition, Asus"));
                enemyDeck.add(db.getCardFromDatabase("Liberator of Ambition, Asus"));
                enemyDeck.add(db.getCardFromDatabase("Liberator of Ambition, Asus"));
                enemyDeck.add(db.getCardFromDatabase("Liberator of Ambition, Asus"));
                enemyDeck.add(db.getCardFromDatabase("Liberator, Lucky Charmy"));
                enemyDeck.add(db.getCardFromDatabase("Liberator, Lucky Charmy"));
                enemyDeck.add(db.getCardFromDatabase("Liberator, Lucky Charmy"));
                enemyDeck.add(db.getCardFromDatabase("Liberator, Lucky Charmy"));
                enemyDeck.add(db.getCardFromDatabase("Wise Liberator, Yuron"));
                enemyDeck.add(db.getCardFromDatabase("Wise Liberator, Yuron"));
                enemyDeck.add(db.getCardFromDatabase("Wise Liberator, Yuron"));
                enemyDeck.add(db.getCardFromDatabase("Wise Liberator, Yuron"));
                enemyDeck.add(db.getCardFromDatabase("Liberator of Holy Tree, Elkia"));
                enemyDeck.add(db.getCardFromDatabase("Liberator of Holy Tree, Elkia"));
                enemyDeck.add(db.getCardFromDatabase("Liberator of Holy Tree, Elkia"));
                enemyDeck.add(db.getCardFromDatabase("Liberator of Holy Tree, Elkia"));
            }

            save();
            load();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        db.shutdown();
    }

    private void save() throws Exception {
        FileOutputStream[] fos = {context.openFileOutput("Royal Paladin.txt", Context.MODE_APPEND), context.openFileOutput("Gold Paladin.txt", Context.MODE_APPEND)};
        ObjectOutputStream oos = new ObjectOutputStream(fos[0]);
        oos.writeObject(deck);
        oos = new ObjectOutputStream(fos[1]);
        oos.writeObject(enemyDeck);
        oos.close();
    }

    private void load() {
        try {
            FileInputStream[] fis = {context.openFileInput("Royal Paladin.txt"), context.openFileInput("Gold Paladin.txt")};
            ObjectInputStream ois = new ObjectInputStream(fis[0]);
            deck = (ArrayList<Card>) ois.readObject();
            ois = new ObjectInputStream(fis[1]);
            enemyDeck = (ArrayList<Card>) ois.readObject();
            ois.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
