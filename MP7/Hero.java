package LAB7;

/**
 * Created by niervin on 9/30/2016.
 */
public abstract class Hero extends RPGCharacter{
    //need changes and improvements
    //gi erase nako ang levels coz i find no meaning sa pag butang og level tungod kay duel ra mn ni nga type of game
    // private int level;
        public static int buffcount1; //for counting buff turns
        public static int buffcount2; //for counting buff turns

        public Hero(String name) {
            super(name);
            buffcount1 = 0;
            buffcount2 = 0;
            //this.level = level;
        }

        public abstract void skillDisp();

        // getters and setters
        /*public int getLevel() {
            return level;
        }*/

        /*public void setLevel(int level) {
            this.level = level;
        }*/
        //public int getBuffcount1() { return buffcount1;  }
        //public int getBuffcount2() { return buffcount2; }
}
