/*
 * @Author Frank He
 * @Version 09282017
 */
package osu.cse1223;
import java.util.Scanner;
public class Project05 {
	public static void main(String[] args) {
	Scanner in = new Scanner(System.in);
	int random = (int)(Math.random()*200)+1;
	int count = 1; //Generate random integer
	System.out.print("Enter a guess between 1 and 200: ");
	int guess = in.nextInt();
	
	while(guess!=random) {
		if(guess<1||guess>200) {
			System.out.println("Your guess is out of range. Pick a number between 1 and 200.");
			System.out.println();
			count++;
		}
		else if(guess>random) {
			System.out.println("Your guess was too high. Try again.");
			System.out.println();
			count++;
		}
		else if(guess<random) {
			System.out.println("Your guess was too low. Try again.");
			System.out.println();
			count++;
		}
		System.out.print("Enter a guess between 1 and 200: ");
		guess = in.nextInt();
	} //Test to see if the integer the user entered is the same one as the random integer and inform user if the gues is too low or too high or invalid
	
	System.out.println("Congratulations! Your guess was correct! ");
	System.out.println();
	System.out.println("I had choosen "+random+" as the target number.");
	System.out.println("You guesses it in "+count+" tries.");//Print out final statement
	if(count==1) {
		System.out.println("That was astounding!");
	}
	else if(count>=10) {
		System.out.println("This just isn't your game, is it?");
	}
	else if(count>=8) {
		System.out.println("Are you sure this is the right game for you?");
	}
	else if(count==7) {
		System.out.println("That was not that impressive.");
	}
	else if(count>=5) {
		System.out.println("That was pretty good.");
	}
	else if(count>=2) {
		System.out.println("That was lucky!");		
		}
	else if(count==1) {
		System.out.println("That was astounding!");//Print out final statement based on number of guesses
	}
	

}
}
