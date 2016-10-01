public class Mage extends Hero {
    private int BASE_ATTACK = 15;
    private int ARMOR = 5;

    public Mage(String name){
        super(name);
        super.setHp(17);
        super.setMana(30);
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
