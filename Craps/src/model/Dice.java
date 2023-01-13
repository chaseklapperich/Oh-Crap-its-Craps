package model;

import java.util.concurrent.ThreadLocalRandom;

public class Dice {
	private int dieOne;
	private int dieTwo;
	private int point;
	private boolean comeOut;
	private boolean newShooter;
	public Dice() {
		reset();
	}

	/**
	 * The purpose of this method is to simulate the roll of the dice. The
	 * numbers on both die get randomized, and the values for comeOut and point
	 * are adjusted accordingly.
	 */
	public void roll() {
		dieOne = ThreadLocalRandom.current().nextInt(1, 7);
		dieTwo = ThreadLocalRandom.current().nextInt(1, 7);
		int sum = sum();
		// Resets at the beginning to maintain state at end of previous roll
		if(newShooter){
			reset();
		}
		// Turns comeOut off if a point has been established
		if(comeOut && point != 0){
			comeOut = false;
		}
		if (comeOut) {
			// Non craps-numbers and 7
			if (!(sum == 2 || sum == 3 || sum == 7 || sum == 12)) {
				point = sum;
			}
		}
		else {
			// Seven-out
			if (sum == 7) {
				newShooter = true;
			}
		}
	}

	/**
	 * The purpose of this method is to provide the result containing the
	 * contents of both dice after the roll. This is useful for bets relying on
	 * the dice combinations such as hops or hard-ways.
	 * @return an int[] of length 2, the contents of both dice
	 */
	public int[] lookAtDice() {
		return new int[]{dieOne, dieTwo};
	}

	/**
	 * The purpose of
	 * @return
	 */
	public int sum(){
		return dieOne + dieTwo;
	}
	public boolean isComeOut(){
		return comeOut;
	}

	public int getPoint(){
		return point;
	}
	private void reset(){
		point = 0;
		comeOut = true;
		newShooter = false;
	}
}
