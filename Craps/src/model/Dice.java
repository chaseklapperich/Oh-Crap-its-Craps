package model;

import java.util.concurrent.ThreadLocalRandom;

public class Dice {
	private int dieOne;
	private int dieTwo;
	private boolean comeOut;
	private int point;

	public Dice() {
		comeOut = true;
		point = 0;
	}
	public void roll(){
		dieOne = ThreadLocalRandom.current().nextInt(1, 7);
		dieTwo = ThreadLocalRandom.current().nextInt(1, 7);
		int sum = sum();
		if (comeOut){
			// Non craps-numbers and 7
			if (!(sum == 2 || sum == 3 || sum == 7 || sum == 12) ){
				point = sum;
				comeOut = false;
			}
		} else {
			// Seven-out
			if (sum == 7) {
				comeOut = true;
				point = 0;
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
}
