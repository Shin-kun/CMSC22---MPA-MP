package LAB7;

/**
 * Created by niervin on 9/30/2016.
 */
public class Monster extends RPGCharacter{
    //need changes and improvements

    private int attackDamage;

    public Monster(String name, int hp, int attackDamage) {
        super(name);
        setHp(hp);
        this.attackDamage = attackDamage;
    }

    public int attack() {
        return attackDamage;
    }
}
