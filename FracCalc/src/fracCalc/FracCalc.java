package fracCalc;
import java.util.*;
public class FracCalc {
    public static void main(String[] args) {
        // TODO: Read the input from the user and call produceAnswer with an equation
    	Scanner console = new Scanner(System.in);
    	boolean again = true;
    	while(again) {
    		String expression = console.nextLine();
    		if (expression.equalsIgnoreCase("quit")) {
    			again = false;
    		} else {
    			String ans = produceAnswer(expression);
    			System.out.println(ans);
    		}
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
    	//Separate operand1, operator, and operand2
    	int op1End = input.indexOf(' ');
        String operand1 = input.substring(0,op1End);
        int opStart = op1End + 1;
        String operator = input.substring(opStart, (opStart + 1));
        int op2Start = opStart + 2;
        String operand2 = input.substring(op2Start, input.length());
        //Parsing operand1
        int line1 = operand1.indexOf('_');
        int slash1 = operand1.indexOf('/');
        int whole1 = 0;
        int num1 = 0;
        int den1 = 0;
        //Find whole, num, and den depending on the fraction
        if (line1 == -1 && slash1 != -1) {
        	whole1 = 0;
        	num1 = Integer.parseInt(operand1.substring(0, slash1));
        	den1 = Integer.parseInt(operand1.substring(slash1 + 1, operand1.length()));
        } else if (line1 != -1 && slash1 != -1){
        	whole1 = Integer.parseInt(operand1.substring(0, line1));
        	num1 = Integer.parseInt(operand1.substring(line1 + 1, slash1));
        	den1 = Integer.parseInt(operand1.substring(slash1 + 1, operand1.length()));
        } else {
        	whole1 = Integer.parseInt(operand1.substring(0,operand1.length()));
        	num1 = 0;
        	den1 = 1;
        }
        //parsing operand2
        int line2 = operand2.indexOf('_');
        int slash2 = operand2.indexOf('/');
        int whole2 = 0;
        int num2 = 0;
        int den2 = 0;
        //Find whole, num, and den depending on the fraction
        if (line2 == -1 && slash2 != -1) {
        	whole2 = 0;
        	num2 = Integer.parseInt(operand2.substring(0, slash2));
        	den2 = Integer.parseInt(operand2.substring(slash2 + 1, operand2.length()));
        } else if (line2 != -1 && slash2 != -1){
        	whole2 = Integer.parseInt(operand2.substring(0, line2));
        	num2 = Integer.parseInt(operand2.substring(line2 + 1, slash2));
        	den2 = Integer.parseInt(operand2.substring(slash2 + 1, operand2.length()));
        } else {
        	whole2 = Integer.parseInt(operand2.substring(0,operand2.length()));
        	num2 = 0;
        	den2 = 1;
        }
        //Sends error if divided by zero
        if (den1 == 0 || den2 == 0 || (num2 == 0 && operator.contentEquals("/") && whole2 == 0)) {
        	return "ERROR: Cannot divide by zero.";
        }
        //Figuring out the operator
        int realNum = 0;
    	int realDen = den1 * den2;
    	//Changing to improper fraction
    	num1 = num1 + Math.abs(whole1 * den1);
    	if (whole1 < 0) {
    		num1 *= -1;
    	}
    	num2 = num2 + Math.abs(whole2 * den2);
    	if (whole2 < 0) {
    		num2 *= -1;
    	}
    	//Calculate depending on operator
        if (operator.equals("+")) {
        	realNum = num1 * den2 + num2 * den1;
        } else if(operator.equals("-")) {
        	realNum = num1 * den2 - num2 * den1;
        } else if(operator.contentEquals("*")) {
        	realNum = num1 * num2;
        } else {
        	realNum = den2 * num1;
        	realDen = num2 * den1;
        }
        //If the denominator is negative, multiple numerator by -1
        if (realDen < 0) {
        	realNum *= -1;
        	realDen *= -1;
        }
        int realWhole = realNum / realDen;
        if (realWhole != 0 && realNum > 0) {
        	realNum = realNum % realDen;
        } else if (realWhole != 0 && realNum < 0) {
        	realNum = realNum % realDen * -1;
        }
        //reduce
        for (int i = realDen - 1; i >= 2; i--) {
        if (realNum % i == 0 && realDen % i == 0) {
        		realNum /= i;
        		realDen /= i;
        		i = 1;
        	}
        }
        //create return string
        if (realWhole != 0 && realNum != 0) {
        	return realWhole + "_" + realNum + "/" + realDen;
        }else if (realWhole == 0 && realNum == 0){
        	return "0";
        }else if (realWhole != 0 && realNum == 0){
        	return String.valueOf(realWhole);
        }else {
        	return realNum + "/" + realDen;
        }
    }
    // TODO: Fill in the space below with any helper methods that you think you will need
}
