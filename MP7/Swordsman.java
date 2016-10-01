package LAB7;

/**
 * Created by niervin on 9/30/2016.
 */
public class Swordsman extends Hero{
    //need changes and improvements

    // because of sword
    public static final int BASE_ATTACK = 10;
    // because of armor
    private int ARMOR;

    public Swordsman(String name) {
        // a swordsman will have +ARMOR for HP because of ARMOR
        super(name);
        super.setHp(130);
        super.setMana(110);
        ARMOR = 15;
    }

    public void skillDisp() {
        System.out.println("Skill Set (Swordsman):\n " +
                "1. Attack\n" +
                "2. Bloodlust\n" +
                "3. Guard Stance");
        System.out.println("Choose a skill: ");
    }

    //special attacks more or less mao ni ilang special moves
    //special attacksss
    //kailangan pa ba nig improvement??
    public int attack(int choice) {
        if(buffcount1 != 0){
            buffcount1++;       //buffcount turns
        }
        if(buffcount2 != 0){
            buffcount2++;       //buffcount turns
        }
        if(buffcount2 == 4){    //guard stance is erased;
            ARMOR -= 8;
        }
        if(choice == 1) {
            if(buffcount1 < 4 && buffcount1 > 0) {
                return BASE_ATTACK + 5;
            }
            else {
                return BASE_ATTACK;
            }
        }
        else if(choice == 2) {
            //how to record number of turns
            //special attack Bloodlust..
            //an offensive buff..
            //for 4 turns + 5 attack
            buffcount1 = 1;
            if(getMana() < 0) {
                System.out.println("Mana is too low. Proceed to attack");
                return attack(1);
            }
            else {
                super.minusMana(15);
                return BASE_ATTACK + 5;
            }
        }
        else if(choice == 3) {
            //how to record number of turns
            //Guard Stance
            //a defense buff
            //for 5 turns + 8 armor
            buffcount2 = 1;
            if(getMana() < 0) {
                System.out.println("Mana is too low. Proceed to attack");
                return BASE_ATTACK;
            }
            else {
                super.minusMana(20);
                ARMOR += 8;
                return 0;
            }
        }
        return BASE_ATTACK;
    }
    public int takeDamage(int damage) {
        // reduce damage because of armor!!! oh yeah!
        damage -= ARMOR;
        // set new hp
        if(damage < 0){
            damage = 0;
        }
        return super.takeDamage(damage);
    }

}

