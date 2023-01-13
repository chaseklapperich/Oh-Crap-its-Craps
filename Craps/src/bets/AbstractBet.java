package bets;
import model.Dice;

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
    protected String name;
    protected int[] odds = new int[2];
    protected int betAmount;
    protected boolean working;
    protected boolean stayUpAfterWin;
    public AbstractBet(int amountBet){
        betAmount = amountBet;
        working = true;
    }

    /**
     * Determines which numbers result in a win for the current bet
     *
     * @param roll The sum of the last dice roll
     * @return A boolean, whether the roll has resulted in a
     * 		   winning bet
     */
    abstract boolean betWon(Dice roll);

    /**
     * Determines which numbers result in a loss for the current bet
     *
     * @param roll The sum of the last dice roll
     * @return A boolean, whether the roll has resulted in a
     * 		   winning bet
     */
    abstract boolean betLost(Dice roll);

    /**
     * Calculates the winnings/loss after a given roll
     *
     * @param roll - The sum of the last dice roll
     * @return An int, the winnings/loss of the roll
     */
    public int processRoll(Dice roll) {
        int winnings = 0;
        if (betWon(roll)) {
            System.out.println(name + " Won!");
            winnings = betAmount / odds[1] * odds[0] + betAmount;
            betAmount = 0;
        }
        else if (betLost(roll)){
            System.out.println(name + " Lost!");
            betAmount = 0;
        }
        return winnings;
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
     * Clears the amount bet. Useful for clearing bets when lost
     */
    public void clearBet() {
        betAmount = 0;
    }

    /**
     * Checks if there is nothing left on the bet. Useful for removing empty bets
     * @return a boolean, whether the bet is empty
     */
    public boolean isEmpty() {
        return betAmount == 0;
    }

    /**
     * Getter for the amount of money placed on bet.
     * @return an int, the amount of money placed on the corresponding bet.
     */
    public int getBetAmount(){
        return betAmount;
    }

    /**
     * Pulls all money off of the bet and returns it. Useful for taking money off of a bet
     * @return an int, the amount of money that was previously on the bet
     */
    public int pullDown() {
        int toReturn = betAmount;
        clearBet();
        return toReturn;
    }
    public void setWorking(boolean toSet){
        working = toSet;
    }
    public void setStayUpAfterWin(boolean toSet){
        stayUpAfterWin = toSet;
    }
}
