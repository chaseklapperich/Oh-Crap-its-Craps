package bets;
import model.Dice;

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
    boolean betWon(Dice roll) {
        int sum = roll.sum();
        return ( ((sum == 7 || sum == 11 ) && roll.isComeOut()) || (sum == roll.getPoint()) );
    }

    /**
     * Determines which numbers result in a loss for the current bet
     *
     * @param roll The sum of the last dice roll
     * @return A boolean, whether the roll has resulted in a
     * winning bet
     */
    @Override
    boolean betLost(Dice roll) {
        int sum = roll.sum();
        return ((sum == 2 || sum == 3 || sum == 12) && roll.isComeOut()) || (sum == 7 && !roll.isComeOut());
    }
}
