import java.util.ArrayList;
import java.util.Scanner;

public class Table {
	Dice dice = new Dice();
	ArrayList<Player> players = new ArrayList<>();
	Scanner userIn = new Scanner(System.in);
	
	public void newShooter() {
		dice = new Dice();
	}
	
	public void roll() {
		int[] roll = dice.cast();
		userIn.next();
		System.out.println(roll);
		players.forEach( (player) -> player.roll(roll));
		players.forEach( (player) -> System.out.println(
				"Bankroll: " + player.getBankRoll() + ", Active: " + player.getActive()));
	}

	public void addPlayer(Player toAdd){
		players.add(toAdd);
	}
	
	
}
