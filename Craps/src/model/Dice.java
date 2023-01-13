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
	public void roll() {
		dieOne = ThreadLocalRandom.current().nextInt(1, 7);
		dieTwo = ThreadLocalRandom.current().nextInt(1, 7);
		int sum = sum();
		if(newShooter){
			reset();
		}
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
	public int[] lookAtDice() {
		return new int[]{dieOne, dieTwo};
	}
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
