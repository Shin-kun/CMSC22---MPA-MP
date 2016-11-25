package designpatterns;

/**
 * Created by niervin on 11/25/2016.
 */
public class BowandArrowBehavior implements WeaponBehavior {

    @Override
    public void useWeapon() {
        System.out.println("Thwack...Thud");
    }
}
