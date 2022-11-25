
package postfix;
import java.util.Stack;
import java.util.Scanner;

public class Postfix {
	public static void main(String[] args){

		Postfix pfx= new Postfix();
		//System.out.println(pfx.evaluate("92/"));
		//System.out.println(pfx.infixToPostfix("p-2*5"));
		//System.out.println(pfx.isPfx("p-2*5"));
		//pfx.result();

	}

	public String infixToPostfix(String ifx) {
		Stack<String> characters=new Stack<>();
		String pfx="";
		String operators = "+ * - /()";
		characters.push(";");
		for (int i=0 ; i<ifx.length();i++){
			String current= ifx.substring(i,i+1);

			if (!operators.contains(current)){
				pfx+=current;
			}
			else if(current=="("){
				characters.push("(");
			}
			else if(current=="^"){
				characters.push("^");
			}
			else if(current==")"){
				while(characters.peek()!="(" ){
					pfx+=characters.pop();
				}
				characters.pop();
			}
			else {
				while((!characters.isEmpty())&&(priority(current)<=priority(characters.peek()))){
					pfx+=characters.pop();
				}

				characters.push(current);
			}

		}
		while (!characters.isEmpty()){
			pfx+=characters.pop();
		}
		return pfx.substring(0,pfx.length()-1);

	}


	public double evaluate(String pfx) {
		Stack<String> characters = new Stack<String>();
		String operators = "+ * - /";

		for (int i=0 ; i<pfx.length();i++){
			String current= pfx.substring(i,i+1);
			if (!operators.contains(current)){
				characters.push(current);
			}
			else {
				String b=characters.pop();
				String a=characters.pop();
				characters.push(applyOp(a,b,current));
			}
		}

		return Double.parseDouble(characters.pop());
	}
	public String applyOp(String a1, String b1, String op){
		double a=Double.parseDouble(a1);
		double b=Double.parseDouble(b1);
		double value=0;
		switch(op){
			case "+" : value= a+b; break;
			case "-" : value= a-b;break;
			case "*" : value= a*b;break;
			case "/" : value= a/b ;break;
		}
		String returned=value+"";
		return returned;
	}
	public int priority(String a){
		int p=-1;
		switch (a){
			case "+" : p=0; break;
			case "-" : p=0;break;
			case "*" : p= 1;break;
			case "/" : p=1 ;break;
			case ";" : p=-2; break;
		}
		return p;
	}
	public void result(){
    Scanner input= new Scanner(System.in);
    System.out.println("Give me the expression");
    String exp= input.next();
    input.close();
    if(isPfx(exp)){
    	System.out.println(evaluate(exp));
	}
    else{
		System.out.println(evaluate(infixToPostfix(exp)));
	}
}
public boolean isPfx (String exp){
	String operators = "+ * - /";
		if (operators.contains(exp.substring(exp.length()-1,exp.length()))){
			return true;
		}
		else {
			return false;
		}

}
}
