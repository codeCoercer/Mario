
// Prints the half pyramid as seen in the classic
// Mario game. The size of the pyramid is determined
// by user input.

import java.util.Scanner;

public class Mario {
	public static void main(String[] args) {
		
		int num = getInt();
		printHalfPyramid(num);
		
	}
	
	// Asks the user for an int
	public static int getInt() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter a number: ");
		String num = sc.next();
		
		// Makes sure the user enters an int
		while(!isInt(num)) {
			System.out.println("That is not a valid number.");
			System.out.print("Enter a number: ");
			num = sc.next();
		}
		sc.close();
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
	
	// Prints the half pyramid given an int
	public static void printHalfPyramid(int num) {
		for(int i = 0; i < num; i++) {
			for(int j = i; j < num-1; j++) {
				System.out.print(" ");
			}
			for(int k = 0; k < i+2; k++) {
				System.out.print("#");
			}
			System.out.println();
		}
	}
}
