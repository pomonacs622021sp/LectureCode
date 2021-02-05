package shapes;

public class Square extends Shape{
	private double sideLength;
	
	public Square(double sideLength) {
		super("Square");
		this.sideLength = sideLength;
	}

	public double getArea(){
		return sideLength*sideLength;
	}
	
	public double getSideLength(){
		return sideLength;
	}
}
