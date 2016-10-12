
public class TestDraw{

    public static void main(String[] args){
        Movable m1 = new MovableRectangle(8,3,12,9,10,0);
		System.out.println(m1);
		m1.moveLeft();

		System.out.println(m1);


		/*Movable m2 = new MovableCircle(2,1,2,2,20);
		System.out.println(m2);
		m2.moveRight();
		System.out.println(m2);*/
    }
}
