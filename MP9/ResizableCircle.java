public class ResizableCircle extends Circle implements Resizable{
	public ResizableCircle(double radius){
		super(radius);
	}

	public void resize(int percent){
		double newSize = (double) (percent) / 100;
		radius += newSize * radius;
	}
	public void Render(){



	}

}
