/*
 * Project07.java
 * 
 *   A program that plays the dice game high/low
 *   Used to practice breaking code up into methods. 
 * 
 * @author Frank He
 * @version 10102017
 *
 */
package osu.cse1223;

import java.util.Scanner;

public class Project07 {
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int moneyAmount = 100;//Determine initial money amount
		while(moneyAmount>0) {
			System.out.println("You have "+moneyAmount+" dollars");
			int bet = getBet(in,moneyAmount);
			if(bet==0) {
				System.out.println("You have "+moneyAmount+" dollars left");
				System.out.println("Goodbye!");
				break;
			}//DEtermine if the player has 0 dollars left,if so, terminate the loop
			
			char guessLetter = getHighLow(in);
			int rollOne = getRoll();
			int rollTwo = getRoll();
			int totalRoll = rollOne + rollTwo;
			System.out.println("Die 1 rolls "+rollOne);
			System.out.println("Die 2 rolls "+rollTwo);
			System.out.println("Total of two dice is : "+totalRoll);
			int winning = determineWinnings(guessLetter,bet,totalRoll);
			moneyAmount = moneyAmount+winning;//Determine the first and second roll and the total roll sum and the winning amount
			
			if(moneyAmount == 0) {
			System.out.println("You have "+moneyAmount+" dollars left");
			System.out.println("Goodbye!");
			}//Determine if player wants to quit playing
			System.out.println();
		}//Use while loop to determine if the player is winning, losing or quitting
	}
	
	
	// Given a Scanner and a current maximum amount of money, prompt the user for
	// an integer representing the number of dollars that they want to bet.  This
	// number must be between 0 and to maximum number of dollars.  If the user enters
	// a number that is out of bounds, display an error message and ask again.
	// Return the bet to the calling program.
	private static int getBet(Scanner inScanner, int currentPool) {
		System.out.print("Enter an amount to bet (0 to quit): ");
		int betAmount = inScanner.nextInt();
		while(betAmount>currentPool||betAmount<0) {
			System.out.println("Your bet MUST be between 0 and "+currentPool+" dollars.");
			System.out.print("Enter an amount to bet (0 to quit): ");
			betAmount = inScanner.nextInt();
		}
		return betAmount;
	}
	
	// Given a Scanner, prompt the user for a single character indicating whether they
	// would like to bet High ('H'), Low ('L') or Sevens ('S').  Your code should accept
	// either capital or lowercase answers, but should display an error if the user attempts
	// to enter anything but one of these 3 values and prompt for a valid answer.
	// Return the character to the calling program.
	private static char getHighLow(Scanner inScanner) {
		System.out.print("High, low or sevens (H/L/S): ");
		char guessChar = inScanner.next().charAt(0);
		while(guessChar!='H'&&guessChar!='h'&&guessChar!='L'&&guessChar!='l'&&guessChar!='S'&&guessChar!='s') {
		System.out.println("ERROR: Enter either (H/L/S)");
		System.out.print("High, low or sevens (H/L/S): ");
		guessChar = inScanner.next().charAt(0);
		}
		return guessChar;
	}
	
	// Produce a random roll of a single six-sided die and return that value to the calling
	// program
	private static int getRoll() {
		int getRoll = (int)(Math.random()*6+1);
		return getRoll;
	}
	
	// Given the choice of high, low or sevens, the player's bet and the total result of
	// the roll of the dice, determine how much the player has won.  If the player loses
	// the bet then winnings should be negative.  If the player wins, the winnings should
	// be equal to the bet if the choice is High or Low and 4 times the bet if the choice
	// was Sevens.  Return the winnings to the calling program.
	private static int determineWinnings(char guessChar, int betAmount, int totalDice) {
			int winning = 0;
			if(guessChar == 'H'||guessChar == 'h') {
				if(totalDice>=8) {
					winning = betAmount;
				}
				else {
					winning = -1*betAmount;
				}
			}
			else if(guessChar == 'L'||guessChar == 'l') {
				if(totalDice<=6) {
					winning = betAmount;
				}
				else {
					winning = -1*betAmount;
				}
			}
			else {
				if(totalDice==7) {
					winning = 4*betAmount;
				}
				else {
					winning = -1*betAmount;
				}
			}
			if(winning>0) {
				System.out.println("You won "+winning+" dollars!");
			}
			else {
				System.out.println("You lost!");
			}
			return winning;
	}

}