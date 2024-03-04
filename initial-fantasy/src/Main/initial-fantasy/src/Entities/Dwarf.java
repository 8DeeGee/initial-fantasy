package Entities;

public class Dwarf extends Playable {
    public Dwarf(String inName, int str, int mgc, int agl, int hp, int intel) {
        super(inName, str, mgc, agl, hp, intel);
    }



    @Override
    public void receiveDamage(int dmg) {
        this.setHealth(this.health - dmg);

    }

    @Override
    public int attack(int diceResults, int atk) {
        if(diceResults == 6){
            return atk * 3;
        }
        return atk;
    }


}
