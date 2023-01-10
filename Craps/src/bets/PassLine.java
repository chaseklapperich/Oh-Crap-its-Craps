package bets;

public class PassLine extends AbstractBet {

    private boolean comeOut = true;
    private int point;

    public PassLine(int amountBet) {
        super(amountBet);
        odds = new int[] {1,1};
    }


    /**
     * Determines which numbers result in a win for the current bet
     *
     * @param roll The sum of the last dice roll
     * @return A boolean, whether the roll has resulted in a
     * winning bet
     */
    @Override
    boolean betWon(int[] roll) {
        int sum = diceSum(roll);
        if ( ((sum == 7 || sum == 11 ) && comeOut) || (sum == point) ){
            point = 0;
            comeOut = true;
            return true;
        }
        return false;
    }

    /**
     * Determines which numbers result in a loss for the current bet
     *
     * @param roll The sum of the last dice roll
     * @return A boolean, whether the roll has resulted in a
     * winning bet
     */
    @Override
    boolean betLost(int[] roll) {
        int sum = diceSum(roll);
        return ((sum == 2 || sum == 3 || sum == 12) && comeOut) || (sum == 7 && !comeOut);
    }

    /**
     * Calculates the winnings/loss after a given roll
     *
     * @param roll - The sum of the last dice roll
     * @return An int, the winnings/loss of the roll
     */
    @Override
    public int processRoll(int[] roll) {
        if (betWon(roll))
            return betAmount / odds[1] * odds[0];
        else if (betLost(roll))
            return -betAmount;
        else
            if (comeOut) {
                point = diceSum(roll);
                comeOut = false;
            }
            return 0;
    }
}
