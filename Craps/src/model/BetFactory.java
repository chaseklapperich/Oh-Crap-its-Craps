package model;

import bets.*;
public class BetFactory {
    public AbstractBet placeBet(int amount, String betName){
        if (betName == null){
            return null;
        }
        if (betName.equalsIgnoreCase("PassLine")) {
            return new PassLine(amount);

        } else if (betName.equalsIgnoreCase("DontPass")){
            return new DontPass(amount);

        }
        else
            return null;
    }
}
