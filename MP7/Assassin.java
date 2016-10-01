package LAB7;

/**
 * Created by niervin on 10/1/2016.
 */
public class Assassin extends Hero {
    //need changes and improvements
    private int BASE_ATTACK = 17;
    private int ARMOR = 7;

    public Assassin(String name){
        super(name);
        super.setHp(20);
        super.setMana(15);
    }

    public int attack(){
        return BASE_ATTACK;
    }


}
