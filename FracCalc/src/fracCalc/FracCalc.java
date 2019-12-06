package fracCalc;
import java.util.*;
public class FracCalc {

    public static void main(String[] args) {
        // TODO: Read the input from the user and call produceAnswer with an equation
    	Scanner console = new Scanner(System.in);
    	boolean again = false;
    	while(again) {
    		String expression = console.nextLine();
    		if (expression.equals("quit")) {
    			again = true;
    		}
    		String op2 = produceAnswer(expression);
    		System.out.println(op2);
    	}
    }
    
    // ** IMPORTANT ** DO NOT DELETE THIS FUNCTION.  This function will be used to test your code
    // This function takes a String 'input' and produces the result
    //
    // input is a fraction string that needs to be evaluated.  For your program, this will be the user input.
    //      e.g. input ==> "1/2 + 3/4"
    //        
    // The function should return the result of the fraction after it has been calculated
    //      e.g. return ==> "1_1/4"
    public static String produceAnswer(String input) { 
        // TODO: Implement this function to produce the solution to the input
    	/*int op1End = 0;
    	int slash = 0;
    	boolean twice = false;
    	// Calculates when the first space or operator appears (a.k.a where the first operand ends)
        while ((input.charAt(op1End).equals()input.' ') || (input.charAt(op1End) != '+') || (input.charAt(op1End) != '-') || (input.charAt(op1End) != '*')/* || !twice) {
        	if (input.charAt(op1End) == '/') {
        		slash++;
        	}
        	if(slash == 2) {
        		twice = true;
        	}
        	op1End++;
        }*/
    	int op1End = input.indexOf(' ');
        String operand1 = input.substring(0,op1End);
        int opStart = op1End + 1;
        String operator = input.substring(opStart, (opStart + 1));
        int op2Start = opStart + 2;
        String operand2 = input.substring(op2Start, input.length());
        return operand2;
    }

    // TODO: Fill in the space below with any helper methods that you think you will need
    
}
