import static java.lang.Math.PI;


public class Circle implements GeometricObject,Drawable{
	protected double radius;

	public Circle(double radius){
		this.radius = radius;
	}

	public double getArea(){
		return PI * radius * radius;
	}

	public double getPerimeter(){
		return PI * radius * 2;
	}

    public void Render(){





    }


	public String toString(){
		String ans;
		ans = String.format("A Circle with an Area = %.2f, Circumference = %.2f, and radius of %.2f",getArea(), getPerimeter(), radius);
        return ans;
	}
}
