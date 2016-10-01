package LAB7;

/**
 * Created by niervin on 10/1/2016.
 */
public class Druid extends Hero{
    //transformation kay ma add ang HP and MANA...
    private int BASE_ATTACK = 10;
    private int ARMOR = 5;

    public Druid(String name){
        super(name);
        super.setHp(110);
        super.setMana(110);
    }

    //special attacks more or less mao ni ilang special moves
    public int specAtt(int choice) {
        if(choice == 1) {
            //how to record the number of turns??
            //transformation
            //werewolf for 4 turns;
            super.minusMana(15);
            ARMOR += 4;
            return BASE_ATTACK += 10;
        }
        else if(choice == 2) {
            //shocking spell nature power
            //once every turn the enemy will paralyze.. the enemy won't move sa kana nga turn
            super.minusMana(20);
            return BASE_ATTACK + 5;
        }
        return BASE_ATTACK;
    }

    public int attack() {
        return BASE_ATTACK;
    }

    public int takeDamage(int damage) {
        // reduce damage because of armor!!! oh yeah!
        damage -= ARMOR;
        // set new hp
        return super.takeDamage(damage);
    }
}
