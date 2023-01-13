package model;

import bets.AbstractBet;
import java.util.ArrayList;

public class Player{
    private int bankroll;
    private int active;
    private String name;
    private ArrayList<AbstractBet> betsMade = new ArrayList<>();
    private final static BetFactory betFactory = new BetFactory();;

    public Player(String name, int initialBankroll){
        this.name = name;
        bankroll = initialBankroll;
    }
    public void placeBet(int amountToPlace, String betName){
        AbstractBet newBet = betFactory.placeBet(amountToPlace, betName);
        if (bankroll < amountToPlace)
            return;
        bankroll -= amountToPlace;
        active += amountToPlace;
        betsMade.add(newBet);
    }

    public void roll(Dice dice){
        active = 0;
        betsMade.forEach( (bet) -> {
            bankroll += bet.processRoll(dice);
            active += bet.getBetAmount();
        });
        removeEmptyBets();
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
    public String getName(){
        return name;
    }

    private void removeEmptyBets(){
        betsMade.removeIf(AbstractBet::isEmpty);
    }
}