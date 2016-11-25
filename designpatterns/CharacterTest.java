public class CharacterTest {

    public static void main(String[] args) {

        WeaponBehavior knife = new KnifeBehavior();
        WeaponBehavior sword = new SwordBehavior();
        WeaponBehavior axe = new AxeBehavior();
        WeaponBehavior bow = new BowandArrowBehavior();

        Character king = new King(knife);
        Character queen = new Queen(knife);
        Character knight = new Knight(knife);
        Character troll = new Troll(knife);

        king.fight();
        queen.fight();
        knight.fight();
        troll.fight();

        king.setWeapon(sword);
        queen.setWeapon(sword);
        knight.setWeapon(sword);
        troll.setWeapon(sword);

        king.fight();
        queen.fight();
        knight.fight();
        troll.fight();

        king.setWeapon(axe);
        queen.setWeapon(axe);
        knight.setWeapon(axe);
        troll.setWeapon(axe);

        king.fight();
        queen.fight();
        knight.fight();
        troll.fight();

        king.setWeapon(bow);
        queen.setWeapon(bow);
        knight.setWeapon(bow);
        troll.setWeapon(bow);

        king.fight();
        queen.fight();
        knight.fight();
        troll.fight();

    }
}
