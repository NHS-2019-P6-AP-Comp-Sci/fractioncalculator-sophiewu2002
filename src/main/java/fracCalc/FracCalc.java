/**
 * @author Mr. Rasmussen
 */

package fracCalc;

import java.util.*;

public class FracCalc {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		String expression = s.nextLine();

		String result = produceAnswer(expression);
		System.out.println(result);

	}

	// ** IMPORTANT ** DO NOT DELETE THIS FUNCTION. This function will be used to
	// test your code
	// This function takes a String 'input' and produces the result
	//
	// input is a fraction string that needs to be evaluated. For your program, this
	// will be the user input.
	// e.g. input ==> "1/2 + 3/4"
	//
	// The function should return the result of the fraction after it has been
	// calculated
	// e.g. return ==> "1_1/4"
	public static String produceAnswer(String input) {
		int locationOfFirstSpace = input.indexOf(" ");

		int operand1Location = 0;
		int operatorLocation = locationOfFirstSpace + 1;
		int operand2Location = operatorLocation + 2;
		int lengthOfExpression = input.length();

		String operand1 = input.substring(operand1Location, locationOfFirstSpace);
		String operator = input.substring(operatorLocation, operatorLocation + 1);
		String operand2 = input.substring(operand2Location, lengthOfExpression);

		return operand2;
	}

}
