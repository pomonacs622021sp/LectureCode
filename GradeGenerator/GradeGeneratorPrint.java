import java.io.File;
import java.io.FileNotFoundException;
import java.util.Random;
import java.util.Scanner;


public class GradeGeneratorPrint {
	private static final String[] GRADES = {"A", "B", "C", "D", "F"};
	private static final String[] GRADE_MODIFIERS = {"+", "-", ""};
	
	private Random rand = new Random();
	
	public void generateGrades(String filename){
		try {
			Scanner in = new Scanner(new File(filename));

			System.out.println("Name\t\tGrade");
			System.out.println("----------------------------");

			while( in.hasNext() ){
				String name = in.nextLine();
	
				System.out.println(name + "\t" + generateGrade());
			}
		} catch (FileNotFoundException e) {
			System.out.println("Couldn't find file: " + filename);
		}
	}
	
	private String generateGrade(){
		return GRADES[rand.nextInt(GRADES.length)] + 
			   GRADE_MODIFIERS[rand.nextInt(GRADE_MODIFIERS.length)];
	}
	
	public static void main(String[] args){
		String nameFile = "/Users/drk04747/classes/cs62/examples/GradesGenerator/names.txt";
		
		GradeGeneratorPrint generator = new GradeGeneratorPrint();
		generator.generateGrades(nameFile);
	}
}