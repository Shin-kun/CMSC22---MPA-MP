
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
