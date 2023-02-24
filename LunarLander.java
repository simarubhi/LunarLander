/**
 * 
 * This class represents the Lunar Landing spaceship
 * It has methods storing the altitude, velocity, and fuel of the ship
 * It can perform actions such as a rocket thrust which uses fuel and decreases downward velocity
 *
 */

public class LunarLander { // Lunar Landing spaceship

	final int GRAVITY_VELOCITY = 2; // Constant velocity of gravity which is 2m/s
	int altitude; // The Lunar Lander's altitude
	int velocity; // The Lunar Lander's velocity
	int fuel; // The Lunar Lander's fuel
	
	// Default constructor
	LunarLander() {
		altitude = 1000;
		velocity = 40;
		fuel = 25;
	}
	
	// Select values other than default constructor
	LunarLander(int altitude, int velocity, int fuel) {
		this.altitude = altitude;
		this.velocity = velocity;
		this.fuel = fuel;
	}
	
	// Get the Lander's velocity
	public int getVelocity() {
		return velocity;
	}
	
	// Get the Lander's altitude
	public int getAltitude() {
		return altitude;
	}
	
	// Get the the Lander's fuel
	public int getFuel() {
		return fuel;
	}
	
	// Perform a rocket thrust, removes one fuel unit and subtracts 4m/s from the velocity (causes the rocket to go upwards)
	public void thrust() {
		fuel--;
		velocity -= 4; // Every fuel unit subtracts 4m/s of velocity
	}
	
	// Simulate one second
	public void doOneSecond(int fuelUnits) {
		if (fuel <= 0) { // If the Lander has no fuel left
			System.out.println("You have no fuel left!");
		} else if (fuel - fuelUnits < 0) { // If the selected amount of fuel is less than the fuel the Lander currently has
			for (int i = 0; i < fuel; i++) {
				thrust();
			}
		} else { // Default case, remove the amount of fuel requested by the user
			for (int i = 0; i < fuelUnits; i++) {
				thrust();
			}
		}
		
		velocity += GRAVITY_VELOCITY; // 2m/s of gravity is added each second
		altitude -= velocity; // We find the new altitude by subtracted the downward velocity since it is in m/s and this is simulating a second
	}
}
