package designpatterns;

/**
 * Created by niervin on 11/25/2016.
 */
public class KnifeBehavior implements WeaponBehavior{
    @Override
    public void useWeapon() {
        System.out.println("Whook");
    }
}
