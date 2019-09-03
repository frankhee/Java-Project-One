/*
 /*
 * @Author Frank He
 * @Version 10042017
 */
package osu.cse1223;
import java.util.Scanner;

public class Project06 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.print("Enter a credit card number (enter a blank line to quit): ");
		String cardNumber = in.nextLine();//Print out statement
		
		while(cardNumber.length()!=16&&!cardNumber.isEmpty()){
			System.out.println("ERROR! Number MUST have exactly 16 digits");
			System.out.println();
			System.out.print("Enter a credit card number (enter a blank line to quit): ");
			cardNumber = in.nextLine();
		}//Determine if the string entered is the correct number
			String letter = "";
			int odd = 0;
			int even = 0;
			int sumValue=0;
			int checkPoint2 = 0;//Set up values
		while(!cardNumber.isEmpty()) {
			int checkPoint = Integer.parseInt(cardNumber.substring(cardNumber.length()-1,cardNumber.length()));
			odd=Integer.parseInt(cardNumber.substring(1,2))+Integer.parseInt(cardNumber.substring(3,4))+Integer.parseInt(cardNumber.substring(5,6))+Integer.parseInt(cardNumber.substring(7,8))+Integer.parseInt(cardNumber.substring(9,10))+Integer.parseInt(cardNumber.substring(11,12))+Integer.parseInt(cardNumber.substring(13,14));
			if(Integer.parseInt(cardNumber.substring(0,1))*2>=10) {
				letter = cardNumber.substring(0,1);
				even = Integer.parseInt(letter)*2-9;
			}
			else {
				letter= cardNumber.substring(0,1);
				even=Integer.parseInt(letter)*2;
			}
			if(Integer.parseInt(cardNumber.substring(2,3))*2>=10) {
				letter = cardNumber.substring(2,3);
				even= even + Integer.parseInt(letter)*2-9;
			}
			else {
				letter = cardNumber.substring(2,3);
				even= even + Integer.parseInt(letter)*2;
			}
			if(Integer.parseInt(cardNumber.substring(4,5))*2>=10) {
				letter= cardNumber.substring(4,5);
				even= even + Integer.parseInt(letter)*2-9;
			}
			else {
				letter = cardNumber.substring(4,5);
				even= even + Integer.parseInt(letter)*2;
			}
			if(Integer.parseInt(cardNumber.substring(6,7))*2>=10) {
				letter= cardNumber.substring(6,7);
				even= even + Integer.parseInt(letter)*2-9;
			}
			else {
				letter = cardNumber.substring(6,7);
				even= even + Integer.parseInt(letter)*2;
			}
			if(Integer.parseInt(cardNumber.substring(8,9))*2>=10) {
				letter= cardNumber.substring(8,9);
				even= even + Integer.parseInt(letter)*2-9;
			}
			else {
				letter = cardNumber.substring(8,9);
				even= even + Integer.parseInt(letter)*2;
			}
			if(Integer.parseInt(cardNumber.substring(10,11))*2>=10) {
				letter= cardNumber.substring(10,11);
				even= even + Integer.parseInt(letter)*2-9;
			}
			else {
				letter = cardNumber.substring(10,11);
				even= even + Integer.parseInt(letter)*2;
			}
			if(Integer.parseInt(cardNumber.substring(12,13))*2>=10) {
				letter= cardNumber.substring(12,13);
				even= even + Integer.parseInt(letter)*2-9;
			}
			else {
				letter = cardNumber.substring(12,13);
				even= even + Integer.parseInt(letter)*2;
			}
			if(Integer.parseInt(cardNumber.substring(14,15))*2>=10) {
				letter= cardNumber.substring(14,15);
				even= even + Integer.parseInt(letter)*2-9;
			}
			else {
				letter = cardNumber.substring(14,15);
				even= even + Integer.parseInt(letter)*2;
			}//Using the loop to determine the sum value needed
			sumValue=odd+even;
			checkPoint2=10-sumValue%10;//Determine the check point for the number entered
			System.out.println("Check digit should be: "+checkPoint);
			System.out.println("Check digit is: "+checkPoint2);
			if(checkPoint==checkPoint2) {
				System.out.println("Number is valid");
			}
			else {
				System.out.println("Number is not valid");
			}//Compare to see if the check point is correct
			System.out.println();
			
			System.out.print("Enter a credit card number (enter a blank line to quit): ");
			cardNumber = in.nextLine();
			while(cardNumber.length()!=16 && !cardNumber.isEmpty()){
				System.out.println("ERROR! Number MUST have exactly 16 digits");
				System.out.println();
				System.out.print("Enter a credit card number (enter a blank line to quit): ");
				cardNumber = in.nextLine();//Let the user to enter another string until the user enters an empty string
			}
			
		}
		
		System.out.println("Goodbye!");//Print out statement 
	}
}
