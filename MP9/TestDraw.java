import java.io.*;

public class TestDraw{

    public static void clearScreen(){
        try {
            if (System.getProperty("os.name").contains("Windows"))
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            else
                Runtime.getRuntime().exec("clear");
        } catch (IOException | InterruptedException ex) {}
    }


    public static void main(String[] args){
        Movable m1 = new MovableRectangle(8,3,12,9,10,0);
		//System.out.println(m1);
        m1.Render();
		m1.moveLeft();
        System.out.println("\nPress any key to continue...");
        try
        {
            System.in.read();
        }
        catch(Exception e){}
        clearScreen();


		m1.Render();
		//System.out.println(m1);


		/*Movable m2 = new MovableCircle(2,1,2,2,20);
		System.out.println(m2);
		m2.moveRight();
		System.out.println(m2);*/
    }
}
