
public class CommandLine {

	public static void main(String[] args) {
		System.out.println("Length: " + args.length);
		for( int i = 0; i < args.length; i++ ) {
			System.out.println(i + ":\t" + args[i]);
		}
	}
}
