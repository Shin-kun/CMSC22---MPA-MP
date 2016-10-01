package LAB7;

/**
 * Created by niervin on 10/1/2016.
 */
public class Archer extends Hero {
    //same stats as assassin
    //higher accuracy than assassin but weaker armor
    //need changes and improvements
    private int BASE_ATTACK;
    private int ARMOR;

    public Archer(String name){
        super(name);
        super.setHp(120);
        super.setMana(115);
        BASE_ATTACK = 19;
        ARMOR = 4;
    }

    public void skillDisp() {
        System.out.println("Skill set (Hunter):\n" +
                "1.Attack\n" +
                "2.Poison Arrows\n" +
                "3.Paralysis A\n");
        System.out.println("Choose a skill: ");
    }


    public int attack(int choice){
        if(choice == 1){
            return BASE_ATTACK;
        }
        else if(choice == 2){
            //in every turn ma damage ang kontra let's say 5 turns
            //poison arrow
            //i add pa nig Damage per Second sa enemy
            super.minusMana(20);
            return BASE_ATTACK + 5;
        }
        else if(choice == 3) {
            //paralysis arrow
            //once in every turn ma paralyse ang enemy... cannot move
            super.minusMana(25);
            return BASE_ATTACK + 2;
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
