/*
 * Project11.java
 * 
 *   A program that reads in a text file that uses a specific input format and uses it to
 *   produce a formatted report for output.
 *   
 *   See the write-up for Homework Lab 13 for more details.
 *   
 *   This skeleton is more "skeletal" than previous labs.  You MUST break your code up into
 *   more methods than what you see here.  Consider methods to display the formatted report
 *   as well as more methods to compute values for the report.
 * 
 * @author Frank He
 * 
 */
package osu.cse1223;
import java.io.*;
import java.util.*;

public class Project11 {
	
	public static void main(String[] args) {
		//Import scanner
		Scanner inScanner = new Scanner(System.in);
		
		//Get input and output file names 
		String inputFile = inputfileName(inScanner);
		String outputFile = OutfileName(inScanner);
		
		//Use try and catch to find IOExceptions 
		try{
			
			//Create new file, printwriter, and scanner to import the input file to the output file
			File inFile = new File(inputFile);
			Scanner inputScore = new Scanner(inFile);
			File outFile = new File(outputFile);
			PrintWriter outputScore = new PrintWriter(outFile);
			
			//Create the header for the report 
			outputScore.println("Final Overall Scores Report");
			outputScore.println();
			outputScore.printf("%-22s%6s%8s%6s%6s%n","Name","Mean","Median","Max","Min");
			outputScore.printf("%-22s%6s%8s%6s%6s%n","------------------","------","------","----","----");
			
			//Create two array lists for the total mean numbers and names
			ArrayList<Integer>average = new ArrayList<>();
			ArrayList<String>averageName = new ArrayList<>();
			
			//Use while loop to print each player's information
			int nameCount = 0;
			while(inputScore.hasNext()){
				String name = inputScore.nextLine();
				averageName.add(name);
				nameCount++;
				ArrayList<Integer>inputPlayer = readNextSeries(inputScore);
				int mean = getAverage(inputPlayer);
				average.add(mean);
				int median = getMedian(inputPlayer);
				int max = getMax(inputPlayer);
				int min = getMin(inputPlayer);
				outputScore.printf("%-22s%6d%8d%6d%6d%n",name,mean,median,max,min);
			}
			outputScore.println();
			
			//Determine the highest and lowest average as well as the corresponded names
			int highest = getMax(average);
			int lowest  = getMin(average);
			int indexAveHigh=average.indexOf(highest);
			int indexAveLow=average.indexOf(lowest);
			String high = averageName.get(indexAveHigh);
			String low = averageName.get(indexAveLow);
			
			//Print out the summary
			outputScore.println("Total number of participants: "+nameCount);
			outputScore.println("Highest average score: "+high+" "+"("+highest+")");
			outputScore.println("Lowest average score: "+low+" "+ "("+lowest+")");
			inputScore.close();
			outputScore.close();
		
		//Display error message when an IOException is caught
		}catch(IOException e){
			System.out.println("ERROR: File does not exist");
		}
	}
	
	//Given scanner, return a string that is the input file name
	private static String inputfileName(Scanner inScanner) {
		
		//Prompt the user to enter input file name
		System.out.print("Enter an input file name: ");
		String fileName = inScanner.nextLine();
		
		//Determine if the name enter by the user is not an empty line
		while(fileName.equals("")){
			System.out.println("ERROR: Empty Line");
			System.out.print("Enter an input file name: ");
			fileName = inScanner.nextLine();
		}
		return fileName;
	}
	
	//Given scanner, return a string that is the output file name
	private static String OutfileName(Scanner inScanner) {
		
		//Prompt the user to enter output file name
		System.out.print("Enter an output file name: ");
		String fileName = inScanner.nextLine();
		
		//Determine if the name enter by the user is not an empty line
		while(fileName.equals("")){
			System.out.println("ERROR: Empty Line");
			System.out.print("Enter an Output file name: ");
			fileName = inScanner.nextLine();
		}
		return fileName;
	}
	
	
	// Given a Scanner as input read in a list of integers one at a time until a negative
	// value is read from the Scanner.  Store these integers in an ArrayList<Integer> and
	// return the ArrayList<Integer> to the calling program.
	private static ArrayList<Integer> readNextSeries(Scanner inScanner) {
		
		//Create new array list
		ArrayList<Integer>answer = new ArrayList<>();
		
		//Get the input string then parse it to an integer
		String input = inScanner.nextLine();
		int array = Integer.parseInt(input);
		
		//Use while loop import integers to the array list until it detects a negative number
		while(array>=0){
			answer.add(array);
			input = inScanner.nextLine();
			array = Integer.parseInt(input);
		}
		return answer;
	}
	
	// Given a ArrayList<Integer> of integers, compute the median of the list and return it to
	// the calling program.
	private static int getMedian(ArrayList<Integer> inList) {
		
		//Use the sort method to sort the given array list
		Collections.sort(inList);
		
		//Use if statement to determine the median of the array list based on the size of the array list
		int median = 0;
		if(inList.size()%2==0){
			median = (inList.get(inList.size()/2)+inList.get(inList.size()/2-1))/2;
		}
		else{
			median = inList.get(inList.size()/2);
		}
		return median;
	}
	
	// Given a ArrayList<Integer> of integers, compute the average of the list and return it to
	// the calling program.
	private static int getAverage(ArrayList<Integer> inList) {
		
		//Use for loop to get the sum of the array list 
		int sum = 0;
		for(int i = 0;i<inList.size();i++){
			sum = sum+inList.get(i);
		}
		
		//Return the average of the array list
		return sum/inList.size();
	}
	
	//Given an array list, return the max element of the array list 
	private static int getMax(ArrayList<Integer> inList) {
		
		//Use for loop to determine the max element
		int max = inList.get(0);
		for(int i = 0;i<inList.size();i++){
			if(inList.get(i)>max){
				max = inList.get(i);
			}
		}
		return max;		
}
	
	//Given an array list, return the min element of the array list 
	private static int getMin(ArrayList<Integer> inList) {
		
		//Use for loop to determine the max element
		int min = inList.get(0);
		for(int i = 0;i<inList.size();i++){
			if(inList.get(i)<min){
				min = inList.get(i);
			}
		}
		return min;		
}
}
