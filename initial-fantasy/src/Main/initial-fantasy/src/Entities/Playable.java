package Entities;

import java.util.ArrayList;

public abstract class Playable implements Fighter {
    protected String name;
    protected int health;
    protected int strength;
    protected int magic;
    protected int agility;
    protected int intelligence;
    protected int level;
    protected int mana;
    protected ArrayList<String> inventory;
    protected int experience;
    protected int experienceNeededForNextLevel;

    protected int[] attacks;


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
        setLevel(this.getLevel() + 1);
        setExperience(0);
    }
    //---------------------------------------------------

    public int getMana() {
        return mana;
    }
    public void setMana(int mana) {
        this.mana = mana;
    }

    public int atk_SlashDash(){
        int newManaValue = getMana() - 5;
        if (newManaValue < 0 ) {
            System.out.println("voce não mana suficiente e perdeu seu turno!!");
            return 0;
        }
        this.setMana(newManaValue);
        return 4 * this.getStrength() * (this.getMagic()/2);
    }
    public int atk_DivineSpears(){
        int newMagicValue = getMana() - 3;
        if (newMagicValue < 0 ) {
            System.out.println("voce não mana suficiente e perdeu seu turno!!");
            return 0;
        }
        this.setMana(newMagicValue);
        return 2 * this.getMagic() * (this.getIntelligence()/2);
    }
    public int atk_FireBlast(){
        int newMagicValue = getMana() - 4;
        if (newMagicValue < 0 ) {
            System.out.println("voce não mana suficiente e perdeu seu turno!!");
            return 0;
        }
        this.setMana(newMagicValue);
        return 3 * (this.getMagic()*2);
    }
    public int atk_MachRush(){
        int newMagicValue = getMana() - 4;
        if (newMagicValue < 0 ) {
            System.out.println("voce não mana suficiente e perdeu seu turno!!");
            return 0;
        }
        this.setMana(newMagicValue);
        return 3 * this.getAgility() * (this.getStrength()/2);
    }
    public int spell_Nourish(){

        return 10 + getMagic();
    }

    public int basicAttack(int multiplier) {
        return 5 * multiplier;
    }

    public Playable(String inName, int str, int mgc, int agl, int hp, int intel) {
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
        this.mana = 25;
    }

    public int attack(int choice) {
        return switch (choice) {
            case 0 -> atk_SlashDash();
            case 1 -> atk_DivineSpears();
            case 2 -> atk_FireBlast();
            case 3 -> atk_MachRush();
            case 4 -> spell_Nourish();
            default -> lostTurn();
        };
    }

    public void showAttacks() {
        System.out.println("Escolha seu ataque com um número entre 0 e 4");
        System.out.println("1 - ");
    }

    public int lostTurn() {
        System.out.println("Você perdeu o turno!");
        return 0;
    }
}

