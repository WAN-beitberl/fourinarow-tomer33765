package Test1ArbaBeshura;
import Test1ArbaBeshura.Board;

public class Player {
    private String name;
    private Board.square color;
    private int numWins;

    public Player(String name)
    {
        this.name = name;
        this.numWins = 0;
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

    public void setColor(Board.square color)
    {
        this.color = color;
    }

    public Board.square getColor() {
        return color;
    }
}
