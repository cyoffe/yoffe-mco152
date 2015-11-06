package yoffe.connectFour;

import java.util.InputMismatchException;
import java.util.Scanner;

public class PatternRecognition {

	public static void main(String[] args) {

		int[][] numberArray; // array to hold data of user input
		int numOfRows;
		int numOfCol;

		// make connection between to user
		try {
			Scanner keyboard = new Scanner(System.in);

			// get number of rows from user
			do {
				System.out.println("Enter the number of rows for the board:");
				numOfRows = keyboard.nextInt();
				if (numOfRows < 4) {
					System.out.println("invalid number - number entered must be greater than or equal to four");
				}
			} while (numOfRows < 4);

			// get number of columns from user
			do {
				System.out.println("Enter the number of columns for the board:");
				numOfCol = keyboard.nextInt();
				if (numOfCol < 4) {
					System.out.println("invalid number - number entered must be greater than or equal to four");
				}
			} while (numOfCol < 4);

			numberArray = new int[numOfRows][numOfCol];

			// invoke userInput method to get the numbers for the board from
			// user
			int[][] grid = userInput(numberArray);

			// invoke isConsecutiveFour method to check if there are four of the
			// same number in a row
			boolean isFour = isConsecutiveFour(grid, numOfRows, numOfCol);

			if (isFour == true) {
				System.out.println("there are four!");
			} else {
				System.out.println("there aren't four");
			}
		} catch (InputMismatchException ex1) {
			System.out.println("input error - application is closing");
			System.exit(1);
		}

	}

	/**
	 * this method will get the users input for the board
	 * 
	 * @return - array of all numbers that user entered in
	 */

	public static int[][] userInput(int[][] numberArray) throws InputMismatchException {
		Scanner keyboard = new Scanner(System.in);

		// get the numbers from user for the array
		System.out.println("Enter the numbers for the array:");
		for (int row = 0; row < numberArray.length; row++) {
			System.out.println();
			for (int col = 0; col < numberArray[row].length; col++) {
				do {
					System.out.print("Enter number (" + row + "," + col + "):");
					numberArray[row][col] = keyboard.nextInt();
					if ((numberArray[row][col] < 0) || (numberArray[row][col] > 9)) {
						System.out.println("invalid number - number must be between 0 and 9");
					}
				} while (numberArray[row][col] < 0);
			}
		}

		// display the board
		for (int row = 0; row < numberArray.length; row++) {
			System.out.println();
			for (int col = 0; col < numberArray[row].length; col++) {
				System.out.print(numberArray[row][col] + " ");
			}
		}

		System.out.println(); // to enter on to a new line

		return numberArray;
	}

	/**
	 * this method will test if a 2D array has 4 consecutive numbers
	 * 
	 * @return hasFour - true if there are 4 consecutive numbers in the array
	 */

	public static boolean isConsecutiveFour(int[][] numbers, int numOfRows, int numOfCol) {

		boolean isFour = false;

		// check if in rows there are 4 consecutive numbers
		for (int row = 0; row < numbers[0].length; row++) {
			int count = 1; // count of how many of a number are in a row
			for (int col = 1; col < numbers.length; col++) {
				// compare current element with the previous element
				if (numbers[row][col] == numbers[row][col - 1]) {
					count++;
				} else {
					count = 1;
				}

				// check if four or more of same consecutively
				if (count == 4) {
					return isFour = true;
				}
			}
		}

		// check if in columns there are 4 numbers consecutively
		for (int col = 0; col < numbers[0].length; col++) {
			int count = 1; // count of how many of a number are in a row
			for (int row = 1; row < numbers.length; row++) {
				if (numbers[row][col] == numbers[row - 1][col]) {
					count++;
				} else {
					count = 1;
				}

				// check if have a match
				if (count == 4) {
					return isFour = true;
				} else {
					isFour = false;
				}
			}
		}

		// check if have diagonals going from top left to bottom right
		for (int col = 0; col < numbers[0].length; col++) {
			int count = 1; // count how many numbers are in a row
			for (int row = 1; row < numbers.length; row++) {
				if ((row + col) >= numOfRows) {
					break;
				}
				if (numbers[row - 1][(col + row) - 1] == numbers[row][col + row]) {
					count++;
				} else {
					count = 1;
				}

				if (count == 4) {
					return isFour = true;
				}

			}
		}

		// check diagonals going from top-right to bottom left
		for (int col = 0; col < numbers[0].length; col++) {
			int count = 1;
			for (int row = 1; row < numbers.length; row++) {
				if ((col - row) < 0) {
					break;
				}
				if (numbers[row - 1][(col - row) + 1] == numbers[row][col - row]) {
					count++;
				} else {
					count = 1;
				}

				// check if have four in row
				if (count == 4) {
					return isFour = true;
				}
			}
		}
		return isFour;
	}// end of method
}