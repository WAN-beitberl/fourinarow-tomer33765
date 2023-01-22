package Test1ArbaBeshura;

public class Main {
    public static void main(String[] args)
    {
        ConnectFourGame game1 = new ConnectFourGame(2);
        int turnsPlayed;
        for (turnsPlayed = 0; turnsPlayed < game1.NUM_COLS* game1.NUM_ROWS; turnsPlayed++)
        {
            game1.turn();
            if(game1.checkForWin()) break;
            game1.incTurn();
        }

        if(turnsPlayed == game1.NUM_COLS* game1.NUM_ROWS) System.out.println("It's a Tie");
    }

}
