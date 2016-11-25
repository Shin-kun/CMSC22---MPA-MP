package designpatterns;

/**
 * Created by niervin on 11/25/2016.
 */
public class Character {

    WeaponBehavior weapon;

    public Character(){ }

    public Character(WeaponBehavior w){
        setWeapon(w);
    }

    public void setWeapon(WeaponBehavior w){
        this.weapon = w;
    }

    public void fight(){ }

}
