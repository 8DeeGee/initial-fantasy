package Entities;

public class Monster implements Fighter {
    protected int health;
    protected int strength;
    protected int agility;
    protected int level;

    public int getAgility() {
        return agility;
    }

    public void setAgility(int agility) {
        this.agility = agility;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public Monster(int hp, int str, int agl){
        this.health = hp;
        this.strength = str;
        this.agility = agl;
    }

    @Override
    public void receiveDamage(int dmg) {

    }

    @Override
    public int attack(int diceResults, int atk) {
        return 0;
    }
}
