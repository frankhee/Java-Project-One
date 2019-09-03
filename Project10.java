/*
 * Project10.java
 * 
 *   A program that plays and scores a round of the game Poker Dice.  In this game,
 *   five dice are rolled.  The player is allowed to select a number of those five dice
 *   to re-roll.  The dice are re-rolled and then scored as if they were a poker hand.  
 *   The following hands MUST be scored in this assignment:
 *   	* High card
 *   	* One Pair
 *   	* Two Pair
 *   	* Three of a Kind
 *   	* Full House
 *   	* Four of a Kind
 *   	* Five of a Kind
 *   For extra credit, you may also implement:
 *   	* Straight
 * 
 * @author Frank He
 * @version 11082017
 * 
 */
package osu.cse1223;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;


public class Project10 {

	public static void main(String[] args) {
		
		//Declare scanner 
		Scanner inScanner = new Scanner(System.in);
		
		//Create new array size of 5
		int[]current = new int[5];
		
		//Create a boolean function to continue the while loop
		boolean repeat = true;
		while(repeat) {
			
		//Reset all the elements in the array to 0 by using method resetDice
			resetDice(current);
			
		//Generate random number to the array list consist of the dice number 
			rollDice(current);
			
		//Assign string dice to the method diceToString to convert the array list to a string 
			String dice = diceToString(current);
		
			System.out.println("Your current dice: "+dice);
			
		//Prompt the user to re-roll the dice using the method promptForReroll
			promptForReroll(current,inScanner);
		
		//Use for loop to determine the final dice combination 
			for(int i = 0;i<current.length;i++) {
				if(current[i]==0) {
					current[i]= (int)(Math.random()*10)+1;
				}
				dice = diceToString(current);
			}
			System.out.println("Your final dice: "+dice);
		
			//Create array countTotal using the method getCounts
			int[]countTotal = getCounts(current);
			
			String result = getResult(current);
			System.out.println(result);
			repeat = promptForPlayAgain(inScanner);
			System.out.println();
		}
		
	}
	
	// Given an array of integers as input, sets every element of the array to zero.
	private static void resetDice(int[] dice) {
		
		//Use for loop to assign 0 to all the elements in the array
		for(int i = 0; i<dice.length;i++) {
			dice[i]=0;
		}
	}
	
	// Given an array of integers as input, checks each element of the array.  If the value
	// of that element is zero, generate a number between 1 and 10 and replace the zero with
	// it.  Otherwise, leave it as is and move to the next element.
	private static void rollDice(int[] dice) {
		
		//Use for loop to assign random integers to elements in the array
		for(int i = 0; i<dice.length;i++) {
			if(dice[i]==0) {
				dice[i]= (int)(Math.random()*10)+1;
			}
		}
	}
	
	// Given an array of integers as input, create a formatted String that contains the
	// values in the array in the order they appear in the array.  For example, if the 
	// array contains the values [0, 3, 7, 5, 2] then the String returned by this method
	// should be "0 3 7 5 2".
	private static String diceToString(int[] dice) {
		
		//Use for loop to print out the array
		String answer = "";
		for(int i = 0; i<dice.length;i++) {
			answer = answer + dice[i]+" ";
		}
		return answer;
	}
	
	
	// Given an array of integers and a Scanner as input, prompt the user with a message
	// to indicate which dice should be re-rolled.  If the user enters a valid index (between
	// 0 and the total number of dice -1) then set the die at that index to zero.  If the 
	// user enters a -1, end the loop and return to the calling program.  If the user enters
	// any other invalid index, provide an error message and ask again for a valid index.
	private static void promptForReroll(int[] dice, Scanner inScanner) {
		
		//Prompt the user to re-roll the dice
		System.out.print("Select a dice to re-roll (-1 to keep remaining dice): ");
		String answer = inScanner.nextLine();
		int index = Integer.parseInt(answer);
		
		//Use while loop to determine the validity of the input
		while(index!=-1) {
			while(index<-1||index>=dice.length) {
				System.out.println("ERROR: Index must be between 0 and " + (dice.length-1)+" (-1 to quit)!");
				System.out.print("Select a dice to re-roll (-1 to keep remaining dice: ");
				answer = inScanner.nextLine();
				index = Integer.parseInt(answer);
			}
		//Assign the value 0 to the selected index position 
		dice[index]=0;
		String arrayToString = diceToString(dice);
		System.out.println("You current dice: "+arrayToString);
		System.out.print("Select a dice to re-roll (-1 to keep remaining dice: ");
		answer = inScanner.nextLine();
		index = Integer.parseInt(answer);
		}
		System.out.println("Keeping remaininig dice...");
		System.out.println("Rerolling...");
		
	}
	
	// Given a Scanner as input, prompt the user to play again.  The only valid entries
	// from the user are 'Y' or 'N', in either upper or lower case.  If the user enters
	// a 'Y' the method should return a value of true to the calling program.  If the user
	// enters a 'N' the method should return a value of false.  If the user enters anything
	// other than Y or N (including an empty line), an error message should be displayed
	// and the user should be prompted again until a valid response is received.
	private static boolean promptForPlayAgain(Scanner inScanner) {
		
		//Create boolean function returnAnswer
		boolean returnAnswer = false;
		
		//Prompt the user to enter an answer
		System.out.print("Would you like to play again [Y/N]?: ");
		String value = inScanner.nextLine();
		
		//Use while loop to determine the validity of the user input 
		while(!value.equals("Y")&&!value.equals("y")&&!value.equals("N")&&!value.equals("n")) {
			System.out.println("ERROR! Only 'Y' or 'N' allowed as input!");
			System.out.print("Would you like to play again [Y/N]?: ");
			value = inScanner.nextLine();
		}
		
		//Use if-else statement to determine the boolean value
		if(value.equals("Y")||value.equals("y")) {
			returnAnswer = true;
		}
		else if(value.equals("N")||value.equals("n")) {
			returnAnswer = false;
		}
		
		return returnAnswer;
	}
	
	// Given an array of integers, determines the result as a hand of Poker Dice.  The
	// result is determined as:
	//	* Five of a kind - all five integers in the array have the same value
	//	* Four of a kind - four of the five integers in the array have the same value
	//	* Full House - three integers in the array have the same value, and the remaining two
	//					integers have the same value as well (Three of a kind and a pair)
	//	* Three of a kind - three integers in the array have the same value
	//	* Two pair - two integers in the array have the same value, and two other integers
	//					in the array have the same value
	//	* One pair - two integers in the array have the same value
	//	* Highest value - if none of the above hold true, the Highest Value in the array
	//						is used to determine the result
	//
	//	The method should evaluate the array and return back to the calling program a String
	//  containing the score from the array of dice.
	//
	//  EXTRA CREDIT: Include in your scoring a Straight, which is 5 numbers in sequence
	//		[1,2,3,4,5] or [2,3,4,5,6] or [3,4,5,6,7] etc..
	private static String getResult(int[] dice) {
		
		//Create empty string 
		String result = "";
		
		//Create a new array using the method getCounts
		int[] count = getCounts(dice);
		
		//Create variables to determine the string returned
		boolean check = false;
		int three = 0;
		int two = 0;
		int max = dice[0];
		
		//Use for loops and if-else statements to determine the result 
		for(int i = 0; i<count.length;i++) {
			if(count[i]==3) {
				three++;
			}
			else if(count[i]==2) {
				two++;
			}
		}
		
		if(three==1&&two==1) {
			result = "Full House!";
		}
		else if(three==1&&two==0) {
			result = "Three of a Kind!";
		}
		else if(three==0&&two==2) {
			result = "Two Pair!";
		}
		else if(three==0&&two==1) {
			result = "One Pair!";
		}
		else {
			for(int i = 0;i<dice.length;i++) {
				if(dice[i]>max) {
					max = dice[i];
				}
			}
			result = "Highest Card "+max+"!";
		}
		
		for(int i = 0; i<count.length&&!check;i++) {
			if(count[i]==5) {
				result = "Five of a kind!";
				check = true;
			}
			else if(count[i]==4) {
				result = "Four of a kind!";
				check = true;
			}
		}
		return result;
		
	}
	
	// Given an array of integers as input, return back an array with the counts of the
	// individual values in it.  You may assume that all elements in the array will have 
	// a value between 1 and 10.  For example, if the array passed into the method were:
	//   [1, 2, 3, 3, 7]
	// Then the array of counts returned back by this method would be:
	// [1, 1, 2, 0, 0, 0, 1, 0, 0, 0]
	// (Where index 0 holds the counts of the value 1, index 1 holds the counts of the value
	//  2, index 2 holds the counts of the value 3, etc.)
	// HINT:  This method is very useful for determining the score of a particular hand
	//  of poker dice.  Use it as a helper method for the getResult() method above.
	private static int[] getCounts(int[] dice) {
		
		//Create a new array size 10 
		int [] count = new int [10];
		
		//Use for loop to assign values to the elements in the array
		for(int i = 0; i<dice.length;i++) {
			count[dice[i]-1]= count[dice[i]-1]+1;
		}
		return count;
	}
}
	

