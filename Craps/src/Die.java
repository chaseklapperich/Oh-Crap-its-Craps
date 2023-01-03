import java.util.concurrent.ThreadLocalRandom;

public class Die {
	public int cast() {
		return ThreadLocalRandom.current().nextInt(1, 7);
	}
}
