import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Random;
import java.util.Scanner;


public class GradeGenerator {
	private static final String[] GRADES = {"A", "B", "C", "D", "F"};
	private static final String[] GRADE_MODIFIERS = {"+", "-", ""};
	
	private Random rand = new Random();
	
	public void printGrades(String filename){
		generateGrades(filename, System.out);
	}
	
	public void generateGradesFile(String infile, String outfile){
		try {
			generateGrades(infile, new FileOutputStream(outfile));
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		}
	}
	
	private void generateGrades(String infilename, OutputStream stream){
		try{
			Scanner in = new Scanner(new File(infilename));
			PrintWriter out = new PrintWriter(stream);

			out.println("Name\t\tGrade");
			out.println("----------------------------");

			while( in.hasNext() ){
				String name = in.nextLine();



				if( name.length() > 7 ){
					out.println(name + "\t" + generateGrade());
				}else{
					out.println(name + "\t\t" + generateGrade());
				}
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
		String nameFile = "/Users/dkauchak/classes/cs201/examples/GradesGenerator/201.spring14.txt";
		String gradesFile =  "/Users/dkauchak/classes/cs201/examples/GradesGenerator/201.grades.txt";
		
		// generate grades to a file
		GradeGenerator generator = new GradeGenerator();
		generator.printGrades(nameFile);
		
		// generate grades to a file
		generator.generateGradesFile(nameFile, gradesFile);
	}
}
