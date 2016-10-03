package LAB7;

/**
 * Created by niervin on 10/1/2016.
 */
public class Assassin extends Hero {
    //need changes and improvements
    public static final int BASE_ATTACK = 13;
    public static final int ARMOR = 7;

    public Assassin(String name){
        super(name);
        super.setHp(100);
        super.setMana(115);
    }

    public void skillDisp() {
        System.out.println("Skill set (Assassin):\n" +
                "1.Attack\n" +
                "2.Deadly Poison\n" +
                "3.Slice and Dice\nChoose a skill:");  //subject to change
    }

    private void plusMana() {
        if(getMana() + 4 < 125) {   //plus mana
            super.plusMana(4);
        }
        else {
            super.setMana(125);
        }
    }

    private void buffturns() {
        if(buffcount1 != 0) {
            buffcount2++;       //buffcount turns
        }
        if(buffcount1 == 5) {
            buffcount1 = 0;
            DPS = 0;
        }
    }

    //special attacks more or less mao ni ilang special moves
    public int attack(int choice){
        plusMana();
        buffturns();

        if(choice == 1) {
            return BASE_ATTACK;
        }
        else if(choice == 2) {
            //highest DPS count
            //poison knives
            //similar to archer's poison arrows
            //dps
            // 5 turns
            if(getMana() - 25 < 0 ) {
                System.out.println("Mana is too low. Proceed to attack.");
                return BASE_ATTACK;
            }
            buffcount1 = 1;
            DPS = 5;
            super.minusMana(25);
            return BASE_ATTACK + 7;
        }
        else if(choice == 3) {
            //highest physical damage among hero types
            if(getMana() - 25 < 0 ) {
                System.out.println("Mana is too low. Proceed to attack.");
                return BASE_ATTACK;
            }
            super.minusMana(25);
            return BASE_ATTACK + 9;
        }
        return BASE_ATTACK;
    }

    public int takeDamage(int damage) {
        // reduce damage because of armor!!! oh yeah!
        damage -= ARMOR;
        // set new hp
        return super.takeDamage(damage);
    }
}
