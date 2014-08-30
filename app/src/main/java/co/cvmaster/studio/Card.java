package co.cvmaster.studio;

import java.io.Serializable;

/**
 * Created by Rushil Perera on 31/07/2014.
 */
public class Card implements Serializable {

    private int id;
    private Card card;
    private String name;
    private String skill;
    private String skillIconEffect;
    private String clan;
    private String triggerType;
    private int grade;
    private int drawableResource;
    private int drawableResourceBig;
    private int drawableResourceRest;
    private int drawableResourceOpponent;
    private int power;
    private int shield;
    private boolean resting;

    public Card() {
    }

    public Card(String name, String skill, String iconEffect, String clan, int grade, int path, int pathBig, int pathRest, int pathOpponent, int power, int shield) {
        this.name = name;
        this.skill = skill;
        skillIconEffect = iconEffect;
        this.clan = clan;
        this.grade = grade;
        drawableResource = path;
        drawableResourceBig = pathBig;
        drawableResourceRest = pathRest;
        drawableResourceOpponent = pathOpponent;
        this.power = power;
        this.shield = shield;
        card = new Card();
    }

    public Card(String name, String skill, String iconEffect, String clan, String triggerType, int grade, int path, int pathBig, int pathRest, int pathOpponent,
                int power, int shield) {
        this.name = name;
        this.skill = skill;
        skillIconEffect = iconEffect;
        this.clan = clan;
        this.triggerType = triggerType;
        this.grade = grade;
        drawableResource = path;
        drawableResourceBig = pathBig;
        drawableResourceRest = pathRest;
        drawableResourceOpponent = pathOpponent;
        this.power = power;
        this.shield = shield;
        card = new Card();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setCard(String name) {
        try {
            card = Player.searchDeck(name);
            this.name = card.getName();
            skill = card.getSkill();
            skillIconEffect = card.getSkillIconEffect();
            clan = card.getClan();
            triggerType = card.getTriggerType();
            grade = card.getGrade();
            drawableResource = card.getDrawableResource();
            drawableResourceBig = card.getDrawableResourceBig();
            drawableResourceRest = card.getDrawableResourceRest();
            power = card.getPower();
            shield = card.getShield();
        } catch (NullPointerException npe) {
            try {
                card = Enemy.searchDeck(name);
                this.name = card.getName();
                skill = card.getSkill();
                skillIconEffect = card.getSkillIconEffect();
                clan = card.getClan();
                triggerType = card.getTriggerType();
                grade = card.getGrade();
                drawableResource = card.getDrawableResource();
                drawableResourceBig = card.getDrawableResourceBig();
                drawableResourceRest = card.getDrawableResourceRest();
                drawableResourceOpponent = card.getDrawableResourceOpponent();
                power = card.getPower();
                shield = card.getShield();
            } catch (NullPointerException e) {
                card = null;
            }
        }
    }

    public Card getCard() {
        return card;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSkill() {
        return skill;
    }

    public void setSkill(String skill) {
        this.skill = skill;
    }

    public String getSkillIconEffect() {
        return skillIconEffect;
    }

    public void setSkillIconEffect(String skillIconEffect) {
        this.skillIconEffect = skillIconEffect;
    }

    public String getClan() {
        return clan;
    }

    public void setClan(String clan) {
        this.clan = clan;
    }

    public String getTriggerType() {
        return triggerType;
    }

    public void setTriggerType(String isTrigger) {
        this.triggerType = isTrigger;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public int getDrawableResource() {
        return drawableResource;
    }

    public void setDrawableResource(int drawableResource) {
        this.drawableResource = drawableResource;
    }

    public int getDrawableResourceBig() {
        return drawableResourceBig;
    }

    public void setDrawableResourceBig(int drawableResourceBig) {
        this.drawableResourceBig = drawableResourceBig;
    }

    public int getDrawableResourceRest() {
        return drawableResourceRest;
    }

    public void setDrawableResourceRest(int drawableResourceRest) {
        this.drawableResourceRest = drawableResourceRest;
    }

    public int getDrawableResourceOpponent() {
        return drawableResourceOpponent;
    }

    public void setDrawableResourceOpponent(int drawableResourceOpponent) {
        this.drawableResourceOpponent = drawableResourceOpponent;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public int getShield() {
        return shield;
    }

    public void setShield(int shield) {
        this.shield = shield;
    }

    public boolean isResting() {
        return resting;
    }

    public void setResting(boolean resting) {
        this.resting = resting;
    }
}
