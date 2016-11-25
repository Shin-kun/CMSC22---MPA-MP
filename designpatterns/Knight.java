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
