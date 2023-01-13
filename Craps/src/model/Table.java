package model;

import java.util.HashMap;
import java.util.Scanner;

public class Table {
	private Dice dice;
	private final HashMap<String, Player> players = new HashMap<>();
	private final Scanner userIn = new Scanner(System.in);


	public Table() {
		newShooter();
	}
	public void newShooter() {
		dice = new Dice();
	}
	
	public void roll() {
		dice.roll();
		int[] result = dice.lookAtDice();
		System.out.println(result[0] + "," + result[1] + " = " + (result[0]+result[1]));
		players.values().forEach( (player) -> player.roll(dice));
		players.values().forEach( (player) -> System.out.println(player.getName() + "- " +
				"Bankroll: " + player.getBankRoll() + ", Active: " + player.getActive()));
		userIn.next();
	}
	public void addPlayer(Player toAdd){
		players.put(toAdd.getName(), toAdd);
	}

	public void addPlayer(String name, int buyIn){
		addPlayer(new Player(name, buyIn, this));
	}

	public Player getPlayer(String name){
		return players.get(name);
	}
	
	
}
