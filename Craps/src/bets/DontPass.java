package bets;

public class DontPass extends AbstractBet{
    public DontPass(int amountBet) {
        super(amountBet);
        name = "DontPass";
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
        boolean winConditionMet = ((sum == 2 || sum == 3) && comeOut) || ((sum == 7) && !comeOut);
        if ( winConditionMet ){
            point = 0;
            comeOut = true;
        }
        return winConditionMet;
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
        return  ((sum == 7 || sum == 11 ) && comeOut) || (sum == point);
    }
}
