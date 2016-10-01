public class Swordsman extends Hero{
    //need changes and improvements

    // because of sword
    private static final int BASE_ATTACK = 8;
    // because of armor
    private static final int ARMOR = 19;
    public Swordsman(String name) {
        // a swordsman will have +ARMOR for HP because of ARMOR
        super(name);
        super.setHp(30);
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
