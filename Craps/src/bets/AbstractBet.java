package bets;

/*
 * Abstract class for all bets that can be made in a game of craps.
 * Odds will need to be set by the subclasses depending on the bet made,
 * and the betAmount will be set by the Method class that is using
 * said bets.AbstractBet.
 * 
 * @author Chase Klapperich
 *
 */
abstract public class AbstractBet {
	protected int[] odds = new int[2];
	protected int betAmount;

	public AbstractBet(int amountBet){
		betAmount = amountBet;
	}

	/**
	 * Determines which numbers result in a win for the current bet 
	 * 
	 * @param roll The sum of the last dice roll
	 * @return A boolean, whether the roll has resulted in a
	 * 		   winning bet
	 */
	abstract boolean betWon(int[] roll);
	
	/**
	 * Determines which numbers result in a loss for the current bet 
	 * 
	 * @param roll The sum of the last dice roll
	 * @return A boolean, whether or not the roll has resulted in a
	 * 		   winning bet
	 */
	abstract boolean betLost(int[] roll);
	
	/**
	 * Calculates the winnings/loss after a given roll
	 * 
	 * @param roll - The sum of the last dice roll
	 * @return An int, the winnings/loss of the roll
	 */
	public int processRoll(int[] roll) {
		if (betWon(roll))
			return betAmount / odds[1] * odds[0];
		else if (betLost(roll))
			return -betAmount;
		else
			return 0;
	}
	
	/**
	 * Increases the amount bet
	 * 
	 * @param increase - an int, the amount to increase by
	 */
	public void increaseBet(int increase) {
		betAmount += increase;
	}
	
	/**
	 * Decreases the amount bet, will 0 out if there trying to decrease by more
	 * than bet
	 * 
	 * @param decrease - an int, the amount to decrease by
	 */
	public void decreaseBet(int decrease) {
		if(decrease > betAmount)
			clearBet();
		else
			betAmount -= decrease;
	}
	/**
	 * Clears the amount bet
	 */
	public void clearBet() {
		betAmount = 0;
	}

	public boolean isEmpty() {
		return betAmount == 0;
	}

	public int pullDown() {
		int toReturn = betAmount;
		clearBet();
		return toReturn;
	}

	protected int diceSum(int[] dice) {
		return dice[0] + dice[1];
	}
}
