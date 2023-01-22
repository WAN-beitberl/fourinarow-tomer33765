package Test1ArbaBeshura;

public class ConnectFourGame extends Game{
    private Board gameBoard;
    public final int NUM_ROWS = 6;
    public final int NUM_COLS = 7;

    public ConnectFourGame(int numOfPlayers) {
        super(numOfPlayers);
        this.players[0].setColor(Board.square.RED);
        this.players[1].setColor(Board.square.YELLOW);
        this.gameBoard = new Board(NUM_ROWS, NUM_COLS);
    }

    @Override
    public boolean checkForWin() {
        for (int i = 0; i < NUM_ROWS; i++)
        {
            for (int j = 0; j < NUM_COLS; j++)
            {
                if(!this.gameBoard.isEmpty(i, j))
                {
                    if(this.gameBoard.checkRow(i, j)||
                            this.gameBoard.checkCol(i, j)||
                            this.gameBoard.checkDiag(i, j))
                    {
                        this.players[this.turn].win();
                        return true;
                    }
                }
            }
        }
        return false;
    }

    @Override
    public void turn() {
        int col;
        do
        {
            System.out.println("It's "+this.players[this.turn].getName()+"'s Turn. Enter column (0-6):");
            col = reader.nextInt();
        } while(!this.gameBoard.isEmpty(0, col));
        int row;

        for (row = 0; row < NUM_ROWS-1; row++)
        {
            if(!this.gameBoard.isEmpty(row + 1, col))
            {
                this.gameBoard.setSquare(row, col, this.players[this.turn].getColor());
                break;
            }
        }

        if(row==NUM_ROWS-1) this.gameBoard.setSquare(row, col, this.players[this.turn].getColor());
        this.gameBoard.display();
    }

    @Override
    public void incTurn() {
        this.turn++;
        this.turn %= 2;
    }


}