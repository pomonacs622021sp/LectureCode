package shapes;

public class Shape {
	private String name;
	
	public Shape(String name){
		this.name = name;
	}
	
	public double getArea(){
		return 0.0;
	}
		
	public String toString(){
		return name + " with area " + getArea();
	}
}
