package co.cvmaster.studio;

/**
 * Created by Rushil Perera on 31/07/2014.
 */
public enum Shield { ZERO(0), FIVE(5000), TEN(10000);

    private int shield;

    private Shield(int shield) {
        this.shield = shield;
    }

    public int toInt() {
        return shield;
    }
}
