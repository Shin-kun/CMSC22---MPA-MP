import java.io.*;
public class MovableCircle implements Movable {
    private int radius;
    private MovablePoint center;

    public MovableCircle(int x, int y, int xSpeed, int ySpeed, int radius) {
        center = new MovablePoint(x, y, xSpeed, ySpeed);
        this.radius = radius;
        Render();
    }

    public String toString() {
        Render();
        return "Center at x = " + center.x + " y = " + center.y + " with radius of " + radius;
    }

    public void moveUp() {
        center.y -= center.ySpeed;
        Render();
    }

    public void moveDown() {
        center.y += center.ySpeed;
        Render();
    }

    public void moveLeft() {
        center.x -= center.xSpeed;
        Render();
    }

    public void moveRight() {
        center.x += center.xSpeed;
        Render();
    }

    private static void clearScreen(){
        try {
            if (System.getProperty("os.name").contains("Windows"))
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            else
                Runtime.getRuntime().exec("clear");
        } catch (IOException | InterruptedException ex) {}
    }

    public void Render(){
        int i, j, ctr = 0;
        clearScreen();
        for(i = 0; i <= center.y+radius ; i++){
            for(j = 0; j <= center.x+radius;j++){

                if(i == center.y){
                    if(j == center.x-radius || j == center.x+radius){
                        System.out.print("X");
                    }
                    if(j ==center.x){
                        System.out.print("X");
                    }
                }
                else if(i > center.y-radius && i < center.y + radius){
                    if(j == center.x - ctr || j == center.x + ctr){
                        if(i <= center.y - radius + (radius/4) || i > center.y + radius -(radius/4))
                            System.out.print("X");
                        else{
                            if((i%2 != 0 || i <= center.y + radius -(radius/4) && i % 2 != 0 ))
                                System.out.print("X");
                        }
                    }
                }
                else{
                    if( i == center.y-radius && j == center.x ||  i == center.y+radius && j == center.x){
                        System.out.print("X");
                        ctr = 1;
                    }
                }
                System.out.print("  ");
            }

            if (ctr != 0 && i > center.y-radius && i <= center.y){
                if(ctr < radius){
                    if(i <= center.y - radius + (radius/4)) { ctr+=2; }
                    else {
                        if(ctr < radius){ ctr++; }
                    }
                }
            }
            else if(ctr!=0 && i > center.y && i < center.y+radius){
                if(i >= center.y+ (radius/4) && i < center.y + radius - (radius/4)){ ctr--; }
                else{
                    if(i >= center.y + radius - (radius/4)){ ctr-=2;}
                }
            }
            System.out.print("\n");
        }
    }
}
