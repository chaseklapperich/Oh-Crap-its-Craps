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
		System.out.println(roll[0] + "," + roll[1] + " = " + (roll[0]+roll[1]));
		players.forEach( (player) -> player.roll(roll));
		players.forEach( (player) -> System.out.println(player.getName() + "- " +
				"Bankroll: " + player.getBankRoll() + ", Active: " + player.getActive()));
		userIn.next();
	}

	public void addPlayer(Player toAdd){
		players.add(toAdd);
	}
	
	
}
