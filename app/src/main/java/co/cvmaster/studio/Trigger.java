package co.cvmaster.studio;

/**
 * Created by Rushil Perera on 31/07/2014.
 */
public enum Trigger { CRITICAL("Critical"), DRAW("Draw"), STAND("Stand"), HEAL("Heal");

    private String trigger;

    private Trigger(String t) {
        trigger = t;
    }

    @Override
    public String toString() {
        return trigger;
    }
}
