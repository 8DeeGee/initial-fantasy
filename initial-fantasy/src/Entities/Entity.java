package Entities;

import java.util.ArrayList;

public class Entity {
    protected String name;
    protected int health;
    protected int strength;
    protected int magic;
    protected int agility;
    protected int intelligence;
    protected int level;
    protected ArrayList<String> inventory;
    protected int experience;
    protected int experienceNeededForNextLevel;


    //---------------------------------------------------
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    //---------------------------------------------------
    public int getHealth() {
        return health;
    }
    public void setHealth(int hp) {
        this.health = hp;
    }
    //---------------------------------------------------
    public int getStrength() {
        return strength;
    }
    public void setStrength(int strength) {
        this.strength = strength;
    }
    //---------------------------------------------------
    public int getMagic() {
        return magic;
    }
    public void setMagic(int magic) {
        this.magic = magic;
    }
    //---------------------------------------------------
    public int getAgility() {
        return agility;
    }
    public void setAgility(int agility) {
        this.agility = agility;
    }
    //---------------------------------------------------
    public int getIntelligence() {
        return intelligence;
    }
    public void setIntelligence(int intelligence) {
        this.intelligence = intelligence;
    }
    //---------------------------------------------------
    public int getLevel() {
        return level;
    }
    public void setLevel(int level) {
        this.level = level;
    }
    //---------------------------------------------------
    public void addItemToInventory(String item){
        this.inventory.add(item);
    }
    public void removeItemFromInventory(String item){
        this.inventory.remove(item);
    }
    //---------------------------------------------------
    public int getExperience() {
        return experience;
    }
    public void setExperience(int experience) {
        this.experience = experience;
    }
    //---------------------------------------------------
    public int getExperienceNeededForNextLevel() {
        return experienceNeededForNextLevel;
    }
    public void setExperienceNeededForNextLevel(int experienceNeededForNextLevel) {
        this.experienceNeededForNextLevel = experienceNeededForNextLevel;
    }
    public void levelUp(){
        setExperienceNeededForNextLevel(experienceNeededForNextLevel*2);
        setLevel(level++);
        setExperience(0);
    }
    //---------------------------------------------------


    public Entity(String inName, int str, int mgc, int agl, int hp, int intel) {
        this.name = inName;
        this.health = hp;
        this.strength = str;
        this.magic = mgc;
        this.agility = agl;
        this.intelligence = intel;
        this.level = 1;
        this.inventory = new ArrayList<>();
        this.experience = 0;
        this.experienceNeededForNextLevel = 10;
    }
}

