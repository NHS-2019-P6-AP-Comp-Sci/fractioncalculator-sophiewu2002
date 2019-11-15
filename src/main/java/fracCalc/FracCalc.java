/**
 * @author Mr. Rasmussen
 */

package fracCalc;

import java.util.*;

public class FracCalc {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		String expression = s.nextLine();

		while (!expression.contentEquals("quit")) {
			String result = produceAnswer(expression);
			System.out.println(result);
			expression = s.nextLine();
			
		s.close();
		}

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

		int locationOfNegativeSign = operand1.indexOf("-");
		if (locationOfNegativeSign != -1) {
			operand1Location = 1;
		}

		int locationOfDivisionSign1InOperand1 = operand1.indexOf("/");
		int locationOfDivisionSign1 = locationOfDivisionSign1InOperand1 + operand1Location;
		int locationOfDivisionSign2InOperand2 = operand2.indexOf("/");
		int locationOfDivisionSign2 = locationOfDivisionSign2InOperand2 + operand2Location;

//		int locationOfBackSlash1InOperand1 = operand1.indexOf("\\");
//		int locationOfBackSlash1 = locationOfBackSlash1InOperand1 + operand1Location;
//		int locationOfBackSlash2InOperand2 = operand2.indexOf("\\");
//		int locationOfBackSlash2 = locationOfBackSlash2InOperand2 + operand2Location;

		String whole1 = " ";
		String numerator1 = " ";
		String denominator1 = " ";

		String whole2 = " ";
		String numerator2 = " ";
		String denominator2 = " ";

		int locationOfUnderscore = operand1.indexOf("_");
		if (locationOfUnderscore == -1 && locationOfDivisionSign1InOperand1 != -1) {
			whole1 = "0";
			numerator1 = input.substring(locationOfUnderscore + 1, locationOfDivisionSign1);
			denominator1 = input.substring(locationOfDivisionSign1 + 1, locationOfFirstSpace);
		} 
		
		if (locationOfUnderscore != -1 && locationOfDivisionSign1InOperand1 != -1) {
			whole1 = input.substring(0, locationOfUnderscore);
			numerator1 = input.substring(locationOfUnderscore + 1, locationOfDivisionSign1);
			denominator1 = input.substring(locationOfDivisionSign1 + 1, locationOfFirstSpace);
		}

		locationOfUnderscore = operand2.indexOf("_") + operand2Location;
		if (locationOfUnderscore - operand2Location == -1 && locationOfDivisionSign2InOperand2 != -1) {
			whole2 = "0";
			numerator2 = input.substring(operand2Location, locationOfDivisionSign2);
			denominator2 = input.substring(locationOfDivisionSign2 + 1, lengthOfExpression);
		} 
		if (locationOfUnderscore - operand2Location != -1 && locationOfDivisionSign2InOperand2 != -1) {
			whole2 = input.substring(operand2Location, locationOfUnderscore);
			numerator2 = input.substring(locationOfUnderscore + 1, locationOfDivisionSign2);
			denominator2 = input.substring(locationOfDivisionSign2 + 1, lengthOfExpression);
		}

		if (locationOfDivisionSign1InOperand1 == -1) {
			whole1 = input.substring(operand1Location, locationOfFirstSpace);
			numerator1 = "0";
			denominator1 = "1";
		}

		if (locationOfDivisionSign2InOperand2 == -1) {
			whole2 = input.substring(operand2Location, lengthOfExpression);
			numerator2 = "0";
			denominator2 = "1";
		}

		String result = "whole:" + whole2 + " numerator:" + numerator2 + " denominator:" + denominator2;
//		String result = whole2 + " " + numerator2 + " " + denominator2;
		return result;
	}

}
