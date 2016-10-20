package ProjectGame;

/**
 * Created by niervin on 10/15/2016.
 */
public class Character implements Movable{
    private int rship; //int relationship
    protected Stats mes;

    public Character(String name){
        mes = new Stats(name);
    }

    public void setRship(int rship) { this.rship = rship; }

    public int getRship() { return rship; }

    public boolean moveUp() { return true; }
    public boolean moveDown() { return true; }
    public boolean moveRight() { return true;}
    public boolean moveLeft() { return true; }

}
