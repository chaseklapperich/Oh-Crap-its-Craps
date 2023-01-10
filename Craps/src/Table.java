
public class Table {
	Dice dice = new Dice();
	
	public void newShooter() {
		dice = new Dice();
	}
	
	public void roll() {
		System.out.println(dice.cast());
	}
	
	
}
