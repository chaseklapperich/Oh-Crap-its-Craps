import bets.*;
public class BetFactory {
    public AbstractBet placeBet(int ammount, String betName){
        if (betName == null){
            return null;
        }
        if (betName.equalsIgnoreCase("PassLine")) {
            return new PassLine(ammount);

        } else if (betName.equalsIgnoreCase("DontPass")){
            return new DontPass(ammount);

        }
        else
            return null;
    }
}
