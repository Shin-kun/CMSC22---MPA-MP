package ProjectGame;

/**
 * Created by niervin on 10/15/2016.
 */
//name subject to change
public class Stats {
    public int x; // x coordinate
    public int y; // y coordinate
    public int ctr; //number of conservation...
    public String name;    //name
    public String[] message;   //messages

    public Stats(String name){
        this.name = name;
    }

    public int getX() { return x; }

    public void setX(int x) { this.x = x; }

    public int getY() { return y; }

    public void setY(int y) { this.y = y; }

    public int getCtr() { return ctr; }

    public void setCtr(int ctr) { this.ctr = ctr; }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }




}
