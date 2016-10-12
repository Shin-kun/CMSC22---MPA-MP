public class MovableCircle implements Movable{
	private int radius;
	private MovablePoint center;

	public MovableCircle(int x, int y, int xSpeed, int ySpeed, int radius){
		center = new MovablePoint(x, y, xSpeed, ySpeed);
		this.radius = radius;
	}

	public String toString(){
		return "Position at x = " + center.x + " and y = " + center.y;
	}

	public void Render() {


	}

	public void moveUp(){
		center.y -= center.ySpeed;
	}

    public void moveDown(){
		center.y += center.ySpeed;
	}

	public void moveLeft(){
		center.x -= center.xSpeed;
	}

	public void moveRight(){
		center.x += center.xSpeed;
	}
}
