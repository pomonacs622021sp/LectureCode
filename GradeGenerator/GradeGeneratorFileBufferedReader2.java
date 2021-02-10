import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;
import java.util.Scanner;


public class GradeGeneratorFileBufferedReader2 {
	private static final String[] GRADES = {"A", "B", "C", "D", "F"};
	private static final String[] GRADE_MODIFIERS = {"+", "-", ""};
	
	private Random rand = new Random();
	
	public void generateGrades(BufferedReader in, PrintWriter out){
		try{			
			out.println("Name\t\tGrade");
			out.println("----------------------------");

			String name = in.readLine();
			
			while( name != null ){
				out.println(name + "\t" + generateGrade());
				
				name = in.readLine();
			}
			
			out.close();
		}catch(IOException e) {
			System.err.println(e.getMessage());
		}
	}
	
	private String generateGrade(){
		return GRADES[rand.nextInt(GRADES.length)] + 
			   GRADE_MODIFIERS[rand.nextInt(GRADE_MODIFIERS.length)];
	}
	
	public static void main(String[] args){
		String nameFile = "/Users/drk04747/classes/cs62/examples/GradesGenerator/names.txt";
		String gradesFile =  "/Users/drk04747/classes/cs62/examples/GradesGenerator/grades.txt";
		
		GradeGeneratorFileBufferedReader2 generator = new GradeGeneratorFileBufferedReader2();
		
		try {
			BufferedReader in = new BufferedReader(new FileReader(nameFile));
			PrintWriter out = new PrintWriter(new FileOutputStream(gradesFile));
			
			generator.generateGrades(in, out);
		} catch (FileNotFoundException e) {
			System.err.println("Problems opening file");
			System.err.println(e.getMessage());
		}
	}
}
