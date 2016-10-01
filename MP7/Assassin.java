
public class Assassin extends Hero {
    //need changes and improvements
    private int BASE_ATTACK = 17;
    private int ARMOR = 7;

    public Assassin(String name){
        super(name);
        super.setHp(120);
        super.setMana(115);
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
