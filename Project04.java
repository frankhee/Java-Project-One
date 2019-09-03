/*
 * @Author Frank He
 * @Version 09202017
 */
package osu.cse1223;

import java.util.Scanner;

public class Project04 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int playerWin = 0;
		int pcWin = 0;
		int tie = 0;
		boolean stop = false;//Set up integers for player wins, PC wins, ties, and boolean function for when the loop would stop
		while(!stop) {
		//Set up the while loop for the tournament 
		System.out.print("Please select one of your dragon [Fire/Plant/Water]: ");
		String answer = in.next();//Record player's choice
		int fire = 0;
		int plant = 1;
		int water = 2;
		int pc = (int) (Math.random()*3);
		String pcAnswer = "";
		if(pc == 0) {
			pcAnswer = "Fire Dragon";
		}
		if(pc==1) {
			pcAnswer = "Plant Dragon";
		}
		if(pc==2) {
			pcAnswer = "Water Dragon";
		}//Set up the random selection for PC
		
		if(answer.charAt(0)=='F'||answer.charAt(0)=='f') {
			System.out.println("You choose: Fire Dragon");
			System.out.println("I chose: " + pcAnswer);
		}
		else if(answer.charAt(0)=='W'||answer.charAt(0)=='w') {
			System.out.println("You choose: Water Dragon");
			System.out.println("I chose: " + pcAnswer);
		}
		else if(answer.charAt(0)=='P'||answer.charAt(0)=='p') {
			System.out.println("You choose: Plant Dragon");
			System.out.println("I chose: " + pcAnswer);
		}
		else {
			System.out.println("You choose: "+answer);
			System.out.println("I chose: " + pcAnswer);
			System.out.println("You lose by default!");//Print out statement for player's choice and PC's choice
		}
		
		if((answer.charAt(0)=='F'||answer.charAt(0)=='f')&&(pcAnswer.charAt(0)=='P'||pcAnswer.charAt(0)=='p')){
			System.out.println("Fire defeats Plant - you win!");
			playerWin++;
		}
		else if((answer.charAt(0)=='F'||answer.charAt(0)=='f')&&(pcAnswer.charAt(0)=='W'||pcAnswer.charAt(0)=='w')){
			System.out.println("Water defeats Fire - you lose!");
			pcWin++;
		}
		else if((answer.charAt(0)=='F'||answer.charAt(0)=='f')&&(pcAnswer.charAt(0)=='F'||pcAnswer.charAt(0)=='f')){
			System.out.println("A Tie!");
			tie++;
		}
		else if((answer.charAt(0)=='W'||answer.charAt(0)=='w')&&(pcAnswer.charAt(0)=='P'||pcAnswer.charAt(0)=='p')){
			System.out.println("Plant defeats Water - you lose!");
			pcWin++;
		}
		else if((answer.charAt(0)=='W'||answer.charAt(0)=='w')&&(pcAnswer.charAt(0)=='F'||pcAnswer.charAt(0)=='f')){
			System.out.println("Water defeats Fire - you win!");
			playerWin++;
		}
		else if((answer.charAt(0)=='W'||answer.charAt(0)=='w')&&(pcAnswer.charAt(0)=='W'||pcAnswer.charAt(0)=='w')){
			System.out.println("A Tie!");
			tie++;
		}
		else if((answer.charAt(0)=='P'||answer.charAt(0)=='p')&&(pcAnswer.charAt(0)=='F'||pcAnswer.charAt(0)=='f')){
			System.out.println("Fire defeats Plant - you lose!");
			pcWin++;
		}
		else if((answer.charAt(0)=='P'||answer.charAt(0)=='p')&&(pcAnswer.charAt(0)=='W'||pcAnswer.charAt(0)=='w')){
			System.out.println("Plant defeats Water - you win!");
			playerWin++;
		}
		else if((answer.charAt(0)=='P'||answer.charAt(0)=='p')&&(pcAnswer.charAt(0)=='P'||pcAnswer.charAt(0)=='p')){
			System.out.println("A Tie!");//Determine who wins the round and count total wins for player and PC, then count ties
			tie++;
		}
		if(playerWin==2 || pcWin==2) {
			stop = true;//Determine if either the player or PC has won 2 games 
		}
		}
		
		System.out.println("Out of 4 matches you won "+playerWin+", I won "+pcWin+", and we tied "+tie+".");
		if(playerWin>pcWin) {
			System.out.println("Congratulation - you win the tourament!");
		}
		else  {
			System.out.println("Sorry - you lost the tournment!");//Print out the final result for the tournament 
		}
	}
}
		
	

		
	
		
		
	




