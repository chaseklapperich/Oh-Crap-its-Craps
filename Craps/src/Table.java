
public class Table {
	Die[] dice = new Die[2];
	
	public void newShooter() {
		dice[0] = new Die();
		dice[1] = new Die();
	}
	
	public void roll() {
		System.out.println(dice[0].cast() + dice[1].cast());
	}
	
	
}
