import bets.AbstractBet;
import java.util.ArrayList;

public class Player{
    private int bankroll;
    private int active;
    private ArrayList<AbstractBet> betsMade = new ArrayList<>();

    public void placeBet(int amountBet, AbstractBet newBet){
        bankroll -= amountBet;
        newBet.increaseBet(amountBet);
        active += amountBet;
        betsMade.add(newBet);
    }

    public void roll(int[] rollResult){
        betsMade.forEach( (bet) -> {
            int amount = bet.processRoll(rollResult);
            if (amount > 0)
                bankroll += amount;
            else
                active -= amount;
        });
    }

    public void pullDownBets(){
        betsMade.forEach( (bet) -> {
            int amountReturned = bet.pullDown();
            active -= amountReturned;
            bankroll += amountReturned;
        });
        removeEmptyBets();
    }

    public int getBankRoll(){
        return bankroll;
    }

    public int getActive(){
        return active;
    }

    private void removeEmptyBets(){
        betsMade.removeIf(AbstractBet::isEmpty);
    }
}