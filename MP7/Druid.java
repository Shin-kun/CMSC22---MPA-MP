package LAB7;

/**
 * Created by niervin on 10/1/2016.
 */
public class Druid extends Hero{
    private int BASE_ATTACK;
    private int ARMOR;

    public Druid(String name){
        super(name);
        super.setHp(120);
        super.setMana(95);
        BASE_ATTACK = 10;
        ARMOR = 5;
    }

    public void skillDisp() {
        System.out.println("Skill set (Druid):\n" +
                "1.Attack\n" +
                "2.Werewolf Aspect\n" +
                "3.Shocking Touch");
        System.out.println("Choose a skill: ");
    }

    private void plusMana() {   //plus mana in every turn
        if(getMana() + 9 < 95) {
            super.plusMana(9);
        }
        else {
            setMana(95);
        }
    }
    private void buffturns() {
        if(buffcount1 != 0){
            buffcount1++;       //buffcount turns
        }
        if(buffcount1 == 5) {
            ARMOR -= 6;
            buffcount1 = 0;
        }
    }

    private int changedAttack() {
        if(buffcount1 == 0) {
            return BASE_ATTACK;
        }
        else {
            return BASE_ATTACK + 10;
        }
    }

    public int attack(int choice) {
        System.out.println(buffcount1 + " mao ni si buffcount1 ni hero!");
        plusMana();
        buffturns();
        if(choice == 1){
            return changedAttack();
        }
        else if(choice == 2) {
            //transformation
            //werewolf for 4 turns;
            if(getMana() - 15 < 0) {
                System.out.println("Mana is too low. Proceed to attack.");
                return changedAttack();
            }
            super.minusMana(15);
            if(buffcount1 != 0) {
                ARMOR -= 4;
            }
            buffcount1 = 1;
            ARMOR += 6;
            return 0;
        }
        else if(choice == 3) {
            //shocking spell nature power
            //once every turn the enemy will paralyze.. the enemy won't move sa kana nga turn
            if(getMana() - 20 < 0) {
                System.out.println("Mana is too low. Proceed to attack.");
                return changedAttack();
            }
            super.minusMana(25);
            chance = true; //it means the enemy is paralyzed
            return BASE_ATTACK + 7;
        }
        return BASE_ATTACK;
    }

    public int takeDamage(int damage) {
        // reduce damage because of armor!!! oh yeah!
        damage -= ARMOR;
        // set new hp
        return super.takeDamage(damage);
    }
}
