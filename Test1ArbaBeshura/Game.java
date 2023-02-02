package Test1ArbaBeshura;

import java.util.Scanner;

public abstract class Game {
    protected Player[] players;
    protected int turn;
    public static Scanner reader = new Scanner(System.in);

    public Game(int numOfPlayers)
    {
        this.turn = 0;
        this.players = new Player[numOfPlayers];

        for (int i = 0; i < numOfPlayers; i++)
        {
            System.out.println("Enter player name:");
            this.players[i] = new Player(reader.nextLine());
        }
    }

    public abstract boolean checkForWin();
    public abstract void turn();
    public abstract void incTurn();
    public abstract void gameLoop();
}
