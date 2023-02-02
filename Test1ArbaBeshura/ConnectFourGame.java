package Test1ArbaBeshura;

public class ConnectFourGame extends Game{
    private Board gameBoard;
    private int currentTurnRow;
    private int currentTurnCol;
    public final int NUM_ROWS = 6;
    public final int NUM_COLS = 7;
    public static final int NUM_OF_DISCS_TO_WIN = 4;

    public ConnectFourGame(int numOfPlayers) {
        super(numOfPlayers);
        this.gameBoard = new Board(NUM_ROWS, NUM_COLS);
    }

    @Override
    public boolean checkForWin() {
        char signToCheck = this.players[this.turn].getGameSign();
        return (this.gameBoard.checkCol(this.currentTurnCol, signToCheck) ||
                this.gameBoard.checkRow(this.currentTurnRow, signToCheck) ||
                this.gameBoard.checkDiagByIndex(this.currentTurnRow, this.currentTurnCol, signToCheck));
    }

    @Override
    public void turn() {

        inputColumn();

        for (this.currentTurnRow = NUM_ROWS-1; this.currentTurnRow >= 0; this.currentTurnRow--)
        {
            if(this.gameBoard.isEmpty(this.currentTurnRow, this.currentTurnCol))
            {
                this.gameBoard.setSquare(this.currentTurnRow, this.currentTurnCol,
                                         this.players[this.turn].getGameSign());
                break;
            }
        }

        if(this.currentTurnRow == -1)
        {
            System.out.println("Row is full.");
            turn();
        }

        else this.gameBoard.display();
    }

    private void inputColumn()
    {
        do
        {
            System.out.println("It's "+this.players[this.turn].getName()+"'s Turn. Enter column (0-6):");
            this.currentTurnCol = reader.nextInt();

            if(!(this.currentTurnCol >= 0 && this.currentTurnCol <= NUM_COLS-1))
                System.out.println("Illegal column.");
        } while(!(this.currentTurnCol >= 0 && this.currentTurnCol <= NUM_COLS-1));
    }

    @Override
    public void incTurn() {
        this.turn++;
        this.turn %= this.players.length;
    }

    @Override
    public void gameLoop() {
        int turnsPlayed;
        this.gameBoard.display();
        for (turnsPlayed = 0; turnsPlayed < NUM_COLS*NUM_ROWS; turnsPlayed++)
        {
            turn();
            if(checkForWin())
            {
                this.players[this.turn].win();
                break;
            }
            incTurn();
        }

        if(turnsPlayed == NUM_COLS*NUM_ROWS) System.out.println("It's a Tie");
    }


}