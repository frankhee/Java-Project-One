/*
 * @Author Frank He
 * @Version 09042017
 * 
 * EXTRA CREDIT: When I enter a substring that does not exist in the longer string, it returned -1 as the starting position in the longer string and an error.
 * line 29 caused the error and I would have to make an if statement to set up a condition to test if the substring is within the longer string or not.
 */
package osu.cse1223;

import java.util.Scanner;

public class Project02 {

	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		
		System.out.print("Enter a long string: ");
		String input = in.nextLine(); //Print out statement 
		System.out.print("Enter a substring: ");
		String sub = in.nextLine();
		
		int inputLength = input.length();
		System.out.println("Length of your string: " + inputLength);//Determine the length of my statement 
		
		int subLength = sub.length();
		System.out.println("Length of your substring: "+subLength);//Determine the length of my substring 
		
		int pos = input.indexOf(sub);
		System.out.println("Starting position of your substring in string: "+pos);//Get position for substring
		
		String before = input.substring(0,pos);
		System.out.println("String before your substring: "+before);//Determine the characters before my substring 
		
		String after = input.substring(pos+subLength);
		System.out.println("String after your substring: "+after);//Determine the characters after my substring
		
		System.out.print("Enter a position between 0 and 43: ");
		int number = in.nextInt();//Determine the characters between index 0 and 43
		
		char letter = input.charAt(number);
		System.out.println("The character at position " + number + " is "+ letter);//Determine the character in the statement at the entered number
		
		System.out.print("Enter a replacement string: ") ;
		String replace = in.next();//Print out the statement 
		
		String newString = before + replace + after ;
		System.out.print("Your new string is: " + 	newString);//Replace the new string into the statement 
		
		
	}

}
