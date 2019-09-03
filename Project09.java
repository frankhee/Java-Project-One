
/**
 * Project09.java
 *
 *   A program that converts binary numbers into decimal numbers.
 *   Used to practice breaking code up into methods.
 *
 *   @author Frank He
 *   @version 10182017
 */
package osu.cse1223;

import java.util.Scanner;

public class Project09 {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		// Assign string output to the returned value of method promptForBinary
		String output = promptForBinary(input);

		// Set up while loop to keep the main method going until the user enters an empty line
		while (output.length() > 0) {
			int decimal = binaryToDecimal(output);
			System.out.println("The binary value " + output + " is " + decimal + " in decimal.");
			System.out.println();
			output = promptForBinary(input);
		}
			System.out.println("Goodbye");
	}

	 /**
     * Given a Scanner as input, prompt the user to enter a binary value. Use
     * the function checkForBinaryValue below to make sure that the value
     * entered is actually a binary value and not junk. Then return the value
     * entered by the user as an String to the calling method.
     *
     * @param input
     *            A scanner to take user input from
     * @return a String representing a binary value read from the user
     */
	public static String promptForBinary(Scanner input) {
		// Prompt user to enter a binary value
		System.out.print("Enter a binary value (empty line to quit): ");
		
		// Assign the binary value entered to string val
		String val = input.nextLine();
		
		// Use while loop to prompt user to enter the correct value
		while (!checkForBinaryValue(val)) {
			System.out.println("ERROR - invalid binary value");
			System.out.println();
			System.out.print("Enter a binary value (empty line to quite): ");
			val = input.nextLine();
		}
		return val;
	}

	/**
     * Given a Scanner as input, prompt the user to enter a binary value. Use
     * the function checkForBinaryValue below to make sure that the value
     * entered is actually a binary value and not junk. Then return the value
     * entered by the user as an String to the calling method.
     *
     * @param input
     *            A scanner to take user input from
     * @return a String representing a binary value read from the user
     */
	public static boolean checkForBinaryValue(String value) {
		// Create boolean and integer values for the upcoming while loop
		boolean check = true;
		int i = 0;
		
		// Use while loop to determine if the value entered by the user is the correct one
		while (value.length() > i && check) {
			if (value.charAt(i) != '1' && value.charAt(i) != '0') {
				check = false;
			}
				i++;
		}
		return check;
	}

	 /**
     * Given a binary value, return an int value that is the base 10
     * representation of that value. Your implementation must use the algorithm
     * described in the Project 9 write-up. Other algorithms will receive no
     * credit.
     *
     * @param value
     *            A String containing a binary value to convert to integer
     * @return The base 10 integer value of that binary in the String
     */
	public static int binaryToDecimal(String value) {
		// Create boolean and integer values for the upcoming while loop
		int decimalAnswer = 0;
		int n = value.length() - 1;
		int i = 0;
		
		//Use while loop to solve for the decimal value from the binary value
		while (i < value.length()) {
			int charToInt = Character.getNumericValue(value.charAt(i));
			int powerAnswer = charToInt * ((int) Math.pow(2, n));
			decimalAnswer = decimalAnswer + powerAnswer;
			n--;
			i++;
		}
		return decimalAnswer;
	}
}