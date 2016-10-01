package LAB7;

/**
 * Created by niervin on 10/1/2016.
 */
public class Archer extends Hero {
    //same stats as assassin
    //higher accuracy than assassin but weaker armor
    //need changes and improvements
    private int BASE_ATTACK = 17;
    private int ARMOR = 4;

    public Archer(String name){
        super(name);
        super.setHp(120);
        super.setMana(115);
    }

    public int attack(){
        return BASE_ATTACK;
    }

    public int specAtt(int choice){
        if(choice == 1){
            //in every turn ma damage ang kontra let's say 5 turns
            //poison arrow
            //i add pa nig Damage per Second sa enemy
            super.minusMana(20);
            return BASE_ATTACK + 5;
        }
        else if(choice == 2) {
            //paralysis arrow
            //once in every turn ma paralyse ang enemy... cannot move
            super.minusMana(25);
            return BASE_ATTACK + 2;
        }
        return choice;
    }



    public int takeDamage(int damage) {
        // reduce damage because of armor!!! oh yeah!
        damage -= ARMOR;
        // set new hp
        return super.takeDamage(damage);
    }
}
