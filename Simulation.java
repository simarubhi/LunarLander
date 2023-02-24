/**
 * 
 * This program simulates a rocket landing on the moon. A user is given control of rocket in the process of landing. They may specify the fuel that shall be burnt during each second.
 * The goal of the game is to reach the ground with a velocity of 4m/s or less, otherwise the spaceship will crash!
 * 
 */

import java.util.Scanner; // Scanner import

public class Simulation { // Simulation environment

	final int MAXIMUM_FINAL_VELOCITY = 4; // User must have the Lander's final velocity be equal to or less than 4m/s
	static int endUserVelocity = 0; // Store the Lander's end velocity one the Lander reaches the ground
	
	public static void main(String[] args) {
		
		Scanner r = new Scanner(System.in); // Scanner for user input
		
		LunarLander lander = new LunarLander(); // Lunar Lander with default constructor
		
		System.out.println("Welcome to the Lunar Lander game!"); // Welcome message
		System.out.println("\nLets begin! Safely land the Lundar Lander with at most a velocity of 4m/s. Enter -1 to quit."); // Goal of the game
		
		while (lander.getAltitude() > 0) { // Keep going until the Lander reaches the ground/the altitude is less than or equal to 0
			printStats(lander); // Get the current Lander statistics
			System.out.println("How much thrust would you like to burn?"); // Prompt user
			int userFuelChoice = r.nextInt(); // Get user input
			
			if (userFuelChoice == -1) {
				System.out.println("\nThanks for playing!"); // Goodbye message
				System.exit(0); // End the game if the user selects -1
				
			}
			
			lander.doOneSecond(userFuelChoice); // Simulate one second with the user's fuel choice
		}
		
		endUserVelocity = lander.getVelocity(); // Get the final velocity
		if (endUserVelocity < 5) { // If the velocity is equal to or less than 4m/s the user wins
			System.out.println("You won!");
		} else { // If the velocity is greater than 4m/s the user loses
			System.out.println("\nYou Lost!");
		}
		
		System.out.print("\nYour final stats:"); // Print the final Lander statistics so the user may get feedback
		printStats(lander);
		
		r.close();
	}
	
	// Helper method that prints the Lander statistics
	public static void printStats(LunarLander lander) {
		System.out.println("\nAlt = " + lander.getAltitude() + "m | Vel = " + lander.getVelocity() + "m/s | Fuel = " + lander.getFuel() + "g");
	}

}
