package designpatterns;

/**
 * Created by niervin on 11/25/2016.
 */
public class Queen extends Character{

    public Queen(WeaponBehavior a){
        super(a);
    }

    @Override
    public void fight() {
        System.out.println("Queen Attacked: ");
        weapon.useWeapon();
    }
}
