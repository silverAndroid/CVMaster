package co.cvmaster.studio;

/**
 * Created by Rushil Perera on 31/07/2014.
 */
public enum Clan {ANGEL_FEATHER("Angel Feather"), GENESIS("Genesis"), GOLD_PALADIN("Gold Paladin"), ORACLE_THINK_TANK("Oracle Think Tank"),
    ROYAL_PALADIN("Royal Paladin"), SHADOW_PALADIN("Shadow Paladin"), KAGERO("Kagero"), MURAKAMO("Murakamo"), NARUKAMI("Narukami"), NUBATAMA("Nubatama"),
    TACHIKAZE("Tachikaze"), DARK_IRREGULARS("Dark Irregulars"), PALE_MOON("Pale Moon"), SPIKE_BROTHERS("Spike Brothers"), AQUA_FORCE("Aqua Force"),
    BERMUDA_TRIANGLE("Bermuda Triangle"), GRANBLUE("Granblue"), GREAT_NATURE("Great Nature"), MEGACOLONY("Megacolony"), NEO_NECTAR ("Neo Nectar"),
    DIMENSIONAL_POLICE("Dimensional Police"), LINK_JOKER("Link Joker"), NOVA_GRAPPLER("Nova Grappler");

    private String clan;

    private Clan(String name) {
        clan = name;
    }

    @Override
    public String toString() {
        return clan;
    }
}
