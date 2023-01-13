import model.Table;

public class main {

    public static void main(String[] args){
        Table table = new Table();
        table.addPlayer("Pass", 1000);
        table.addPlayer("Dont", 1000);
        while(true){
            if(table.getPlayer("Pass").getActive() == 0){
                table.getPlayer("Pass").placeBet(100, "PassLine");
            }
            if(table.getPlayer("Dont").getActive() == 0){
                table.getPlayer("Dont").placeBet(100, "DontPass");
            }
            table.roll();
        }

    }
}
