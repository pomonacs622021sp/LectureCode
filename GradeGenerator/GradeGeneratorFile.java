import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;
import java.util.Scanner;


public class GradeGeneratorFile {
	private static final String[] GRADES = {"A", "B", "C", "D", "F"};
	private static final String[] GRADE_MODIFIERS = {"+", "-", ""};
	
	private Random rand = new Random();
	
	public void generateGrades(String infilename, String outfilename){
		try{
			Scanner in = new Scanner(new File(infilename));
			PrintWriter out = new PrintWriter(new FileOutputStream(outfilename));

			out.println("Name\t\tGrade");
			out.println("----------------------------");

			while( in.hasNext() ){
				String name = in.nextLine();
				out.println(name + "\t" + generateGrade());
			}
			
			out.close();
		}catch(FileNotFoundException e) {
			System.out.println(e.getMessage());
		}
	}
	
	private String generateGrade(){
		return GRADES[rand.nextInt(GRADES.length)] + 
			   GRADE_MODIFIERS[rand.nextInt(GRADE_MODIFIERS.length)];
	}
	
	public static void main(String[] args){
		String nameFile = "/Users/drk04747/classes/cs62/examples/GradesGenerator/names.txt";
		String gradesFile =  "/Users/drk04747/classes/cs62/examples/GradesGenerator/grades.txt";
		
		GradeGeneratorFile generator = new GradeGeneratorFile();
		generator.generateGrades(nameFile, gradesFile);
	}
}
