import java.util.concurrent.ThreadLocalRandom;

public class Dice {
	public int[] cast() {
		return new int[]{ThreadLocalRandom.current().nextInt(1, 7),
				ThreadLocalRandom.current().nextInt(1, 7)};
	}
}
