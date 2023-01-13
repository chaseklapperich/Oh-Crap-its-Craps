package model;

public class main {

    public static void main(String[] args){
        Table table = new Table();
        table.addPlayer("Pass", 1000);
        table.addPlayer("Dont", 1000);
        int i = 1;
        while(true){
            if (i <= 4) {
                table.getPlayer("Pass").placeBet(100, "PassLine");
                table.getPlayer("Dont").placeBet(100, "DontPass");
            }
            i++;
            table.roll();
        }

    }
}
