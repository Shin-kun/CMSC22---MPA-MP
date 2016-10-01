public class Mage extends Hero {
    //need changes and improvements
    private int BASE_ATTACK = 8;
    private int ARMOR = 5;

    public Mage(String name){
        super(name);
        super.setHp(117);
        super.setMana(130);
    }

    //special attacks more or less mao ni ilang special moves
    public int attack(int choice) {
        if(choice == 1){
            return BASE_ATTACK;
        }
        else if(choice == 2) {
            //after 1 turn
            //fireball
            //highest amount of damage but greatest mana cost
            super.minusMana(30);
            return BASE_ATTACK + 20;
        }
        else if(choice == 3) {
            //curse?? need improvements please
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
