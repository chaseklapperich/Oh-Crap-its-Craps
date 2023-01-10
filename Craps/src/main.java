public class main {

    public static void main(String[] args){
        Table table = new Table();
        Player c = new Player();
        Player dc = new Player();
        table.addPlayer(c);
        table.addPlayer(dc);
        while(true){
            table.roll();
        }

    }
}
