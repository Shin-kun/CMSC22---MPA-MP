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
