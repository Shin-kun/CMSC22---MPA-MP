package designpatterns;

/**
 * Created by niervin on 11/25/2016.
 */
public class Knight extends Character {

    public Knight(WeaponBehavior a){
        super(a);
    }

    @Override
    public void fight() {
        System.out.println("Knight Attacked: ");
        weapon.useWeapon();
    }
}
