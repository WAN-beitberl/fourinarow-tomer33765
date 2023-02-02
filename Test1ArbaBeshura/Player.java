package Test1ArbaBeshura;
import Test1ArbaBeshura.Board;

public class Player {
    private String name;
    private static char currentChar = 'A';
    private char gameSign;
    private int numWins;

    public Player(String name)
    {
        this.name = name;
        this.numWins = 0;
        this.gameSign = currentChar;
        currentChar++;
    }

    public void win()
    {
        System.out.println(this.name+" Won");
        this.numWins++;
    }

    public String getName()
    {
        return this.name;
    }

    public char getGameSign() { return this.gameSign; }
    public int getNumWins() { return this.numWins; }
}
