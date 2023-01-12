import java.util.concurrent.ThreadLocalRandom;

public class Dice {
	int dieOne;
	int dieTwo;
	public void roll(){
		dieOne = ThreadLocalRandom.current().nextInt(1, 7);
		dieTwo = ThreadLocalRandom.current().nextInt(1, 7);
	}
	public int[] lookAtDice() {
		return new int[]{dieOne, dieTwo};
	}
	public int sum(){
		return dieOne + dieTwo;
	}
}
