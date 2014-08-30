package co.cvmaster.studio;

/**
 * Created by Rushil Perera on 31/07/2014.
 */
public enum SkillIconEffect { BOOST("Boost"), INTERCEPT("Intercept"), TWIN_DRIVE("Twin Drive");

    private String skillIconEffect;

    private SkillIconEffect(String sie) {
        skillIconEffect = sie;
    }

    @Override
    public String toString() {
        return skillIconEffect;
    }
}
