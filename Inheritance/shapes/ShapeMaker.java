package shapes;

import java.util.ArrayList;
import java.util.Scanner;

public class ShapeMaker {
	private ArrayList<Shape> shapes = new ArrayList<Shape>();
	
	public ShapeMaker(){
		getShapes();
	}
	
	private void getShapes(){
		Scanner in = new Scanner(System.in);
		
	   	System.out.print("How many shapes? ");
		int numShapes = in.nextInt();
		
		for( int i = 0; i < numShapes; i++ ){
			System.out.print("What shape? ");
			String nextShape = in.next();
			
			if( nextShape.equals("rectangle") ){
				shapes.add(new Rectangle(2, 10));
			}else if( nextShape.equals("square") ){
				shapes.add(new Square(2));
			}else{
				shapes.add(new Shape(nextShape));
			}
		}
	}
	
	public void printShapes(){
		for( int i = 0; i < shapes.size(); i++ ){
			System.out.println(shapes.get(i));
		}
	}
	
	public static void main(String[] args){
		ShapeMaker maker = new ShapeMaker();
		maker.printShapes();
	}
}