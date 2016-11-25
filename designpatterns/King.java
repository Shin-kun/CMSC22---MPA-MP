package designpatterns;

/**
 * Created by niervin on 11/25/2016.
 */
public class King extends Character {

    public King(WeaponBehavior a){
        super(a);
    }

    @Override
    public void fight() {
        System.out.println("King Attacked: ");
        weapon.useWeapon();
    }
}
