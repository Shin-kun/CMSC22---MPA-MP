package LAB7;

/**
 * Created by niervin on 9/30/2016.
 */
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * Created by nmenego on 9/29/16.
 */
public class RPG {

    private Random rand;

    // constructor
    public RPG() {
        this.rand = new Random();
    }

    // generate a random monster name..
    public String getRandomMonsterName() {
        String[] adjectives = {"Green", "Slimy", "Bloody", "Smelly"};
        String[] monsters = {"Ogre", "Elf", "Giant", "Teacher"};
        List<String> adjs = Arrays.asList(adjectives);
        List<String> mons = Arrays.asList(monsters);

        return adjs.get(randInt(0, adjs.size() - 1)) + " " + mons.get(randInt(0, mons.size() - 1));
    }

    // inclusive random integer
    public int randInt(int min, int max) {
        int randomNum = rand.nextInt((max - min) + 1) + min;
        return randomNum;
    }

    // coin toss
    public boolean coinToss() {
        return randInt(0, 1) == 1 ? true : false;
    }

    // pause the game for awhile for dramatic effect!
    public void sleep(int ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
    }

    // duel two characters, one as attacker, one as defender
    // returns true if someone is killed
    public boolean duel(RPGCharacter attacker, RPGCharacter defender) {
        int damage = attacker.attack();
        System.out.println("--> " + attacker.getName() + " ATK " + defender.getName());
        sleep(2000);

        if (coinToss()) {
            int remHp = defender.takeDamage(damage);
            if (remHp <= 0) {

                System.out.printf("--> %s killed %s!\n", attacker.getName(), defender.getName());
                return true;
            }
        } else {
            System.out.println("--> MISSED!");
        }
        return false;
    }


    // game...
    public static void main(String[] args) {

        RPG rpg = new RPG();
        RPGCharacter hero = new Swordsman("nico"); // TODO take parameters as input via STDIN
        RPGCharacter monster = new Monster(rpg.getRandomMonsterName(), rpg.randInt(1, 100), rpg.randInt(1, 100));

        Hero heros = (Hero) hero;
        //System.out.println(heros.getLevel() + " mao ni si level");
        System.out.println(heros.getHp() + " mao ni si hp");

        System.out.println("====== GAME START =====");
        System.out.printf("%s\n%s\n", heros, monster);

        //System.out.println(hero.);

        // fight! for version 1, hero will always attack first.
        int count = 0;
        while (true) {
            System.out.println("== round " + ++count);
            // hero's turn
            boolean monsterIsDead = rpg.duel(heros, monster);
            if (monsterIsDead) break;

            // monster's turn
            boolean heroIsDead = rpg.duel(monster, heros);
            if (heroIsDead) break;

            System.out.printf("%s\n%s\n", heros, monster);
        }

        System.out.printf("%s\n%s\n", heros, monster);
    }
}