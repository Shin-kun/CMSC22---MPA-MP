import static java.lang.Math.PI;
import java.util.*;
import java.io.*;
public class Circle implements GeometricObject,Drawable {
    protected double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    public double getPerimeter() {
        return PI * 2 * radius;
    }

    public double getArea() {
        return PI * radius * radius;
    }

    public String toString() {
        String ans;
        ans = String.format("This circle has a radius of %.2f, an area of %.2f and a perimeter of %.2f", radius, getArea(), getPerimeter());
        Render();
        return ans;
    }


    public static void clearScreen(){
        try {
            if (System.getProperty("os.name").contains("Windows"))
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            else
                Runtime.getRuntime().exec("clear");
        } catch (IOException | InterruptedException ex) {}
    }

    public static void sleep(int ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
    }

    public void Render(){
        int x, y, i, j, ctr;
        ctr = 0;
        x = 20;
        y = 20;
        clearScreen();
        sleep(1000);
        if(x < radius || y < radius){
            throw new IllegalArgumentException("Radius must fit within coordinates");
        }
        for(i = 0; i <= y+radius ; i++){
            for(j = 0; j <= x+radius;j++){

                if(i == y){
                    if(j == x-radius || j == x+radius){
                        System.out.print("X");
                    }
                    if(j ==x){
                        System.out.print("X");
                    }
                }
                else if(i > y-radius && i < y + radius){
                    if(j == x - ctr || j == x + ctr){
                        if(i <= y - radius + (radius/4) || i > y + radius -(radius/4))
                            System.out.print("X");
                        else{
                            if((i%2 != 0 || i <= y + radius -(radius/4) && i % 2 != 0 ))
                                System.out.print("X");
                        }
                    }
                }
                else{
                    if( i == y-radius && j == x ||  i == y+radius && j == x){
                        System.out.print("X");
                        ctr = 1;
                    }
                }
                System.out.print("  ");
            }

            if (ctr != 0 && i > y-radius && i <= y){
                if(ctr < radius){
                    if(i <= y - radius + (radius/4)) { ctr+=2; }
                    else {
                        if(ctr < radius){ ctr++; }
                    }
                }
            }
            else if(ctr!=0 && i > y && i < y+radius){
                if(i >= y+ (radius/4) && i < y + radius - (radius/4)){ ctr--; }
                else{
                    if(i >= y + radius - (radius/4)){ ctr-=2;}
                }
            }
            System.out.print("\n");
        }
    }
}