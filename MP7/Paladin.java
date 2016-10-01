package LAB7;

/**
 * Created by niervin on 10/1/2016.
 */
public class Paladin extends Hero{
    //need changes and improvements

    // because of sword
    private int BASE_ATTACK;
    // because of armor
    private int ARMOR;

    public Paladin(String name) {
        // a swordsman will have +ARMOR for HP because of ARMOR
        super(name);
        super.setHp(150);
        super.setMana(110);
        BASE_ATTACK = 5;
        ARMOR = 23;
    }
    public void skillDisp() {
        System.out.println("Skill set (Paladin):\n" +
                "1. Heal");
        System.out.println("Choose a skill: ");
    }


    //special attacks more or less mao ni ilang special moves
    public int attack(int choice) {
        if(choice == 1) {
            return BASE_ATTACK;
        }
        else if(choice == 2) {
            int health = super.getHp();
            //freaken healll bloddy heelll
            if(health + 25 > 150){
                int points = 150 - health;
                super.setHp(points + health);
            }
            else{
                super.setHp(25 + health);
            }
            super.minusMana(17);
            return 0;
        }
        else if(choice == 3){
            //need more improvements
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
