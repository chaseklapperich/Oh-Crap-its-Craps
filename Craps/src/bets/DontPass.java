package bets;
import model.Dice;

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
    boolean betWon(Dice roll) {
        int sum = roll.sum();
        return ((sum == 2 || sum == 3) && roll.isComeOut()) || ((sum == 7) && !roll.isComeOut());
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
        return  ((sum == 7 || sum == 11 ) && roll.isComeOut()) || (sum == roll.getPoint());
    }
}
