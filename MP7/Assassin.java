package LAB7;

/**
 * Created by niervin on 10/1/2016.
 */
public class Assassin extends Hero {
    //need changes and improvements
    private int BASE_ATTACK;
    private int ARMOR;

    public Assassin(String name){
        super(name);
        super.setHp(100);
        super.setMana(115);
        BASE_ATTACK = 17;
        ARMOR = 7;
    }

    public void skillDisp() {
        System.out.println("Skill set (Assassin):\n" +
                "1.Attack\n" +
                "2.Poison Knives\n" +
                "3.Smoke Bomb\n");  //subject to change
        System.out.println("Choose a skill: ");
    }

    //special attacks more or less mao ni ilang special moves
    public int attack(int choice){
        if(choice == 1) {
            return BASE_ATTACK;
        }
        if(choice == 2) {
            //poison knives
            //similar to archer's poison arrows
            //dps
            super.minusMana(20);
            return BASE_ATTACK + 5;
        }
        else if(choice == 3) {
            //di ko kahibaw unsaon pag butang ani
            //accuracy.. smoke bomb
            //100% accuracy and 40% accuracy for the enemy
            super.minusMana(25);
            return BASE_ATTACK;
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
