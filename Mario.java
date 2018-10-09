
// Prints the half pyramid as seen in the classic
// Mario game. The size of the pyramid is determined
// by user input.

import java.util.Scanner;
import java.io.*;

public class Mario {
	public static void main(String[] args)throws FileNotFoundException {
		Scanner sc = new Scanner(System.in);
		PrintStream ps = new PrintStream(new File("mario.txt"));
				
		String choice = fileOrConsole(sc);
		int num = getInt(sc);
		
		printHalfPyramid(ps, num, choice);
		
		sc.close();
		ps.close();
	}
	
	// User determines if output should be to the console or a file
	public static String fileOrConsole(Scanner sc) {
		System.out.print("Should Mario print to a file (f), or the console (c)? ");
		String choice = sc.next().toLowerCase();
		
		while(!choice.equals("f") && !choice.equals("c")) {
			System.out.print("Please enter f for file, or c for console: ");
			choice = sc.next().toLowerCase();
		}
		return choice;
	}
	
	// Asks the user for an int
	public static int getInt(Scanner sc) {
		System.out.print("Enter a number: ");
		String num = sc.next();
		
		// Makes sure the user enters an int
		while(!isInt(num)) {
			System.out.println("That is not a valid number.");
			System.out.print("Enter a number: ");
			num = sc.next();
		}
		return Integer.parseInt(num);
	}	
	
	// Returns true if the value is an int, false otherwise
	public static boolean isInt(String num) {
		try {
			Integer.parseInt(num);
			return true;
		} catch(NumberFormatException e) {
			return false;
		}
	}
	
	// Prints the half pyramid to either the console or a file
	public static void printHalfPyramid(PrintStream ps, int num, String choice) {
		
		boolean console = choice.equals("c");
		
		for(int i = 0; i < num; i++) {
			for(int j = i; j < num-1; j++) {
				if(console)
					System.out.print(" ");
				else
					ps.print(" ");
			}
			for(int k = 0; k < i+2; k++) {
				if(console)
					System.out.print("#");
				else					
					ps.print("#");
			}
			if(console)
				System.out.println();
			else
				ps.println();
		}
	}
}
