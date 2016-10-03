package LAB7;

/*
 Created by niervin on 9/30/2016.
*/
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.*;

public class RPG {

    private Random rand;

    // constructor
    public RPG() {
        this.rand = new Random();
    }

    // generate a random monster name..
    public String getRandomMonsterName() {
        String[] adjectives = {"Flame", "Sea", "Nature"};
        String[] monsters = {"Basilisk", "Griffyn", "Dragon"};
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
    }   //coin toss needs to change

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
    public boolean duel(RPGCharacter attacker, RPGCharacter defender,boolean turn) {
        int choice;
        if(turn) {
            Hero type = (Hero) attacker;
            type.skillDisp();
            //hero turn... choosing a skill
            Scanner sc = new Scanner(System.in);
            choice = sc.nextInt();
        }
        else {
            //i think it's better nga tagaan og skill ang monster..
            //too op ra seguro ang heroes kung naa silay skills for now choice is 1
            choice = 1;
        }

        int damage = attacker.attack(choice);

        //need improvements regarding kng chance diri..... sa monster ra ni
        if(damage == 0 && turn) {
            System.out.println(attacker.getName() + " used a buffing skill.");
        }
        else if(damage == 0 && !turn) {
            System.out.println(attacker.getName() + " is paralyzed." + attacker.getName() + "cannot move.");
        }
        sleep(2000);
        if(damage != 0) {
            System.out.println("--> " + attacker.getName() + " ATK " + defender.getName());
            if (coinToss()) {
                if(noHP(defender, attacker, damage)) {
                    return true;
                }
                //what if the console says missed unya nag guard stance ug blood lust si swordsman
            } else {                                   //what if chance will always be true..
                if (turn && defender.DPS != 0) {        //meaning naay Damage Per Second for the monster...
                    if(noHP(defender, attacker, 0)) {
                        return true;
                    }
                }
                if(attacker.chance) {
                    attacker.chance = false;                                //kaning coin toss kay need improvements
                }
                System.out.println("--> MISSED!");  //what if ang swordsman and paladin kay nag guard sila tapos ni ingon
            }                                       //missed dayummmmm
        }
        return false;
    }

    private boolean noHP(RPGCharacter defender,RPGCharacter attacker,int damage) {
        int remHP = defender.takeDamage(damage);
        if (remHP <= 0) {
            System.out.printf("--> %s killed %s!\n", attacker.getName(), defender.getName());
            return true;
        }
        return false;
    }

    // game...
    public static void main(String[] args) {
        int i;
        //to determine if it is the hero turn.. this is so in order for the hero to choose a skill
        boolean heroturn = true;
        RPG rpg = new RPG();
        Scanner sc=new Scanner(System.in);

        for(i=0;i<7;System.out.printf("\n"),i++);
        System.out.printf("Hello Adventurer! What is your name? :");
        String name = sc.next();
        System.out.printf("Please pick your class:\n\t1.Swordsman\n\t2.Mage\n\t3.Assassin\n\t4.Druid\nChoose: ");
        int ans;

        for(ans=0 ;ans <= 0 || ans >4   ;ans = sc.nextInt());
        RPGCharacter hero = new Swordsman(name);
        if(ans == 1) {
            hero = new Swordsman(name);
        }
        else if(ans == 2){
            hero = new Mage(name);
        }
        else if(ans == 3){
            hero = new Assassin(name);
        }
        else if(ans == 4){
            hero = new Druid(name);
        }
        RPGCharacter monster = new Monster(rpg.getRandomMonsterName(), rpg.randInt(90, 150), rpg.randInt(27, 40));
        System.out.println("====== GAME START =====");
        System.out.printf("%s\n%s\n", hero, monster);

        // fight! for version 1, hero will always attack first.
        int count = 0;
        while (true) {
            System.out.println("== round " + ++count);
            // hero's turn
            boolean monsterIsDead = rpg.duel(hero, monster,heroturn);
            heroturn = false;
            if (monsterIsDead) break;

            // monster's turn
            boolean heroIsDead = rpg.duel(monster, hero,heroturn);
            heroturn = true;
            if (heroIsDead) break;

            System.out.printf("%s\n%s\n", hero, monster);
        }

        System.out.printf("%s\n%s\n", hero, monster);
    }
}
