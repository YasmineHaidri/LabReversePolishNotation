package stack;

public class Underflow extends Exception {

	private static final long serialVersionUID = 6551591962766598233L;
	public static void UnderflowException(){
		System.err.println("Stapel leer");
	}

}
