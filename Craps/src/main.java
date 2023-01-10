import bets.DontPass;
import bets.PassLine;

public class main {

    public static void main(String[] args){
        Table table = new Table();
        Player c = new Player("c", 1000);
        Player dc = new Player("dc", 1000);
        table.addPlayer(c);
        table.addPlayer(dc);
        while(true){
            c.placeBet(100, new PassLine(100));
            dc.placeBet(100, new DontPass(100));
            table.roll();
        }

    }
}
