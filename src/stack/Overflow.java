package stack;

public class Overflow extends Exception{

    private static final long serialVersionUID = 6551591962766598233L;

    public static void overflowException(){
        System.err.println("Stapel voll");
    }

}
