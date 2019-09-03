/*
 * @Author Frank He
 * @Version 09122017 
 */
package osu.cse1223;

import java.util.Scanner;

public class Project03 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.print("Enter your name: ");
		String name = in.nextLine();
		System.out.println("Welcome "+name+"!"+" Please answer the following question:");
		System.out.println();//Print out statement 
		int randomValue1 = (int)(10*Math.random()) + 1;
		int randomValue2 = (int)(10*Math.random())+1;//Create random numbers between 0-10
		int totalCorrect = 0;//Create integer for total correct answers 
		System.out.print(randomValue1 + " + " + randomValue2+" = ");
		int answer1 = in.nextInt();//Print out question
		int correctAnswer1 = randomValue1 + randomValue2;
		if(answer1==correctAnswer1) {
			System.out.println("Correct!");
			System.out.println();
			totalCorrect =totalCorrect +1;
		}
			else {
				System.out.println("The correct answer is "+correctAnswer1);
				System.out.println();
		}//Use if statement to determine if the answer is correct

		System.out.print(randomValue1 + " * " + randomValue2+" = ");
		int answer2 = in.nextInt();
		int correctAnswer2 = randomValue1 * randomValue2;
		if(answer2==correctAnswer2) {
			System.out.println("Correct!");
			System.out.println();
			 totalCorrect = totalCorrect+1;
		}
			else {
				System.out.println("The correct answer is "+correctAnswer2);
				System.out.println();
		}////Use if statement to determine if the answer is correct
		System.out.print(randomValue1 + " / " + randomValue2+" = ");
		int answer3 = in.nextInt();
		int correctAnswer3 = randomValue1 / randomValue2;
		if(answer3==correctAnswer3) {
			System.out.println("Correct!");
			System.out.println();
			totalCorrect = totalCorrect +1;
		}
			else {
				System.out.println("The correct answer is "+correctAnswer3);
				System.out.println();
		}////Use if statement to determine if the answer is correct
		System.out.print(randomValue1 + " % " + randomValue2+" = ");
		int answer4 = in.nextInt();
		int correctAnswer4 = randomValue1 % randomValue2;
		if(answer4==correctAnswer4) {
			System.out.println("Correct!");
			System.out.println();
			totalCorrect = totalCorrect+1;
		}
			else {
				System.out.println("The correct answer is "+correctAnswer4);
				System.out.println();
		}////Use if statement to determine if the answer is correct
			System.out.println();
			System.out.println("You got "+totalCorrect+" correct answers");//Print out statement 
			int numerator = totalCorrect;
			double denominator = 4.0;
			double quotient = numerator/denominator;
			double finalAnswer = quotient*100;//Calculate the percentage number for correctness
			System.out.print("That's "+finalAnswer+"%!");//Print out statement 
	}
	

}
		
