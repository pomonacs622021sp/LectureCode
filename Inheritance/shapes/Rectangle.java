package shapes;

public class Rectangle extends Shape{
	private double base;
	private double height;
	
	public Rectangle(double base, double height){
		super("Rectangle");
		
		this.base = base;
		this.height = height;
	}
	
	public double getArea(){
		return base * height;
	}
	
	public double getBase(){
		return base;
	}
	
	public double getHeight(){
		return height;
	}
}
