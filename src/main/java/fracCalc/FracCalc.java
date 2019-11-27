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
//		Finding the location of everything 
		int locationOfFirstSpace = input.indexOf(" ");
		int operand1Location = 0;
		int operatorLocation = locationOfFirstSpace + 1;
		int operand2Location = operatorLocation + 2;
		int lengthOfExpression = input.length();

//		separating the locations of the operands and operator 
		String operand1 = input.substring(operand1Location, locationOfFirstSpace);
		String operator = input.substring(operatorLocation, operatorLocation + 1);
		String operand2 = input.substring(operand2Location, lengthOfExpression);

//		If there is a negative sign in operand 1
		int locationOfNegativeSign1 = operand1.indexOf("-");
		if (locationOfNegativeSign1 != -1) {
			operand1Location = 1;
		}
//		If there is a negative sign in operand 2
		int locationOfNegativeSign2 = operand2.indexOf("-");
		if (locationOfNegativeSign2 != -1) {
			operand2Location = operand2Location + 1;
		}

//		Finding the location of the division sign if there is one (for fractions)
		int locationOfDivisionSign1InOperand1 = operand1.indexOf("/");
		int locationOfDivisionSign1 = locationOfDivisionSign1InOperand1 + operand1Location;
		int locationOfDivisionSign2InOperand2 = operand2.indexOf("/");
		int locationOfDivisionSign2 = locationOfDivisionSign2InOperand2 + operand2Location;

//		Initializing the variables for whole number, numerator, and denominator 
		String whole1 = " ";
		String numerator1 = " ";
		String denominator1 = " ";

		String whole2 = " ";
		String numerator2 = " ";
		String denominator2 = " ";

		int locationOfUnderscore1 = operand1.indexOf("_");
		int locationOfUnderscore2InOperand2 = operand2.indexOf("_");
		int locationOfUnderscore2 = locationOfUnderscore2InOperand2 + operand2Location;

		if (locationOfNegativeSign1 != -1) {
			locationOfDivisionSign1 = locationOfDivisionSign1 - 1;
		}

//		when there is only a fraction (no whole number) 
		if (locationOfUnderscore1 == -1 && locationOfDivisionSign1InOperand1 != -1) {
			whole1 = "0";
			numerator1 = input.substring(operand1Location, locationOfDivisionSign1);
			denominator1 = input.substring(locationOfDivisionSign1 + 1, locationOfFirstSpace);
		}
//		when there is a mixed fraction 
		if (locationOfUnderscore1 != -1 && locationOfDivisionSign1InOperand1 != -1) {
			whole1 = input.substring(operand1Location, locationOfUnderscore1);
			numerator1 = input.substring(locationOfUnderscore1 + 1, locationOfDivisionSign1);
			denominator1 = input.substring(locationOfDivisionSign1 + 1, locationOfFirstSpace);
		}
//		when there is only a whole number (no fraction) 
		if (locationOfDivisionSign1InOperand1 == -1) {
			whole1 = input.substring(operand1Location, locationOfFirstSpace);
			numerator1 = "0";
			denominator1 = "1";
		}

		if (locationOfNegativeSign2 != -1) {
			locationOfUnderscore2 = locationOfUnderscore2 - 1;
			locationOfDivisionSign2 = locationOfDivisionSign2 - 1;

//		when there is only a fraction ( no whole number)
			if (locationOfUnderscore2InOperand2 == -1 && locationOfDivisionSign2InOperand2 != -1) {
				whole2 = "0";
				numerator2 = input.substring(operand2Location, locationOfDivisionSign2);
				denominator2 = input.substring(locationOfDivisionSign2 + 1, lengthOfExpression);
			}
//		When there is a mixed fraction 
			if (locationOfUnderscore2InOperand2 != -1 && locationOfDivisionSign2InOperand2 != -1) {
				whole2 = input.substring(operand2Location, locationOfUnderscore2);
				numerator2 = input.substring(locationOfUnderscore2 + 1, locationOfDivisionSign2);
				denominator2 = input.substring(locationOfDivisionSign2 + 1, lengthOfExpression);
			}
		} else {
//			when there is only a fraction (no whole number) 
			if (locationOfUnderscore2InOperand2 == -1 && locationOfDivisionSign2InOperand2 != -1) {
				whole2 = "0";
				numerator2 = input.substring(operand2Location, locationOfDivisionSign2);
				denominator2 = input.substring(locationOfDivisionSign2 + 1, lengthOfExpression);
			}
//		When there is a mixed fraction 
			if (locationOfUnderscore2InOperand2 != -1 && locationOfDivisionSign2InOperand2 != -1) {
				whole2 = input.substring(operand2Location, locationOfUnderscore2);
				numerator2 = input.substring(locationOfUnderscore2 + 1, locationOfDivisionSign2);
				denominator2 = input.substring(locationOfDivisionSign2 + 1, lengthOfExpression);
			}
		}
//		when there is only a whole number (no fraction) 
		if (locationOfDivisionSign2InOperand2 == -1) {
			whole2 = input.substring(operand2Location, lengthOfExpression);
			numerator2 = "0";
			denominator2 = "1";
		}

//		Turn string operator and operands into integers 
		int whole_1 = Integer.parseInt(whole1);
		int numerator_1 = Integer.parseInt(numerator1);
		int denominator_1 = Integer.parseInt(denominator1);
		int whole_2 = Integer.parseInt(whole2);
		int numerator_2 = Integer.parseInt(numerator2);
		int denominator_2 = Integer.parseInt(denominator2);

//		When whole number is not equal to 0, convert to mixed fractions 
		if (whole_1 != 0) {
			numerator_1 = (whole_1 * denominator_1) + numerator_1;
		}
		if (whole_2 != 0) {
			numerator_2 = (whole_2 * denominator_2) + numerator_2;
		}

		int answerNumerator = 0;
		int answerDenominator = 0;

		/* when division */ if (operator.contentEquals("/")) {
			int newNumerator_2 = denominator_2;
			int newDenominator_2 = numerator_2;
			answerNumerator = numerator_1 * newNumerator_2;
			answerDenominator = denominator_1 * newDenominator_2;
		} /* when multiplication */ else if (operator.contentEquals("*")) {
			answerNumerator = numerator_1 * numerator_2;
			answerDenominator = denominator_1 * denominator_2;
		}

		/* - first operand, - second operand */if (locationOfNegativeSign1 != -1 && locationOfNegativeSign2 != -1) {

		} /* - first operand, + second operand */else if (locationOfNegativeSign1 != -1
				&& locationOfNegativeSign2 == -1) {
			answerNumerator = answerNumerator * -1;
		} /* + first operand, - second operand */ else if (locationOfNegativeSign1 == -1
				&& locationOfNegativeSign2 != -1) {
			answerNumerator = answerNumerator * -1;
		}

		/* - first operand, + second operand */ if (locationOfNegativeSign1 != -1 && locationOfNegativeSign2 == -1) {
			numerator_1 = numerator_1 * -1;
		} /* + first operand, - second operand */ else if (locationOfNegativeSign1 == -1
				&& locationOfNegativeSign2 != -1) {
			numerator_2 = numerator_2 * -1;
		}

		/* when addition */ if (operator.equals("+")) {
			answerDenominator = denominator_1 * denominator_2;
			numerator_1 = numerator_1 * denominator_2;
			numerator_2 = numerator_2 * denominator_1;
			/* - first operand, - second operand */if (locationOfNegativeSign1 != -1 && locationOfNegativeSign2 != -1) {
				numerator_1 = numerator_1 * -1;
				numerator_2 = numerator_2 * -1;
			}
			answerNumerator = numerator_1 + numerator_2;
		} /* when minus */ else if (operator.equals("-")) {
			answerDenominator = denominator_1 * denominator_2;
			numerator_1 = numerator_1 * denominator_2;
			numerator_2 = numerator_2 * denominator_1;
			/* - first operand, - second operand */if (locationOfNegativeSign1 != -1 && locationOfNegativeSign2 != -1) {
				numerator_1 = numerator_1 * -1;
				numerator_2 = numerator_2 * -1;
			}
			answerNumerator = numerator_1 - numerator_2;
		}

//		String answer = locationOfDivisionSign2 + " " + denominator2;
		String answer = "" + answerNumerator + "/" + answerDenominator;

		return answer;
	}

}
