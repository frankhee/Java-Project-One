/* 
 * Project01.java
 * A program will display a series of arithmetic operations 
 * using those two integers.
 * 
 * @Author Frank He
 * @Version 20170830
 */
import java.util.Scanner;

public class Project01 {

	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		
		System.out.print("Enter the first number: ");
		
		String first = in.nextLine();
		int firstNumber = Integer.parseInt(first);
		System.out.print("Enter the second number: ");
		
		String second = in.nextLine();
		int secondNumber = Integer.parseInt(second);
		int answer1 = firstNumber + secondNumber;
		System.out.println(firstNumber + " + " + secondNumber+ " = " + answer1);
		
		int answer2 = firstNumber - secondNumber;
		System.out.println(firstNumber + " - " + secondNumber+ " = " + answer2);
		
		int answer3 = firstNumber * secondNumber;
		System.out.println(firstNumber + " * " + secondNumber+ " = " + answer3);
				
		int answer4 = firstNumber / secondNumber;
		System.out.println(firstNumber + " / " + secondNumber+ " = " + answer4);
		
		int answer5 = firstNumber % secondNumber;
		System.out.println(firstNumber + " % " + secondNumber+ " = " + answer5);
		
		int answer6 = (firstNumber + secondNumber)/2;
		System.out.println("The average of your two numbers is: " + answer6);
	
	}

}
