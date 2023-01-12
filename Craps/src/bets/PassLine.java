package bets;

public class PassLine extends AbstractBet {
    public PassLine(int amountBet) {
        super(amountBet);
        name = "PassLine";
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
}
