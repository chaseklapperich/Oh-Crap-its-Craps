import bets.DontPass;

public class main {

    public static void main(String[] args){
        Table table = new Table();
        Player c = new Player("c", 1000);
        Player dc = new Player("dc", 1000);
        table.addPlayer(c);
        table.addPlayer(dc);
        int i = 1;
        while(true){
            if (i <= 4) {
                c.placeBet(100, "PassLine");
                dc.placeBet(100, "DontPass");
            }
            i++;
            table.roll();
        }

    }
}
