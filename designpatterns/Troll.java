package designpatterns;

/**
 * Created by niervin on 11/25/2016.
 */
public class Troll extends Character {

    public Troll(WeaponBehavior a){
        super(a);
    }


    @Override
    public void fight() {
        System.out.println("Troll Attacked: ");
        weapon.useWeapon();
    }
}
