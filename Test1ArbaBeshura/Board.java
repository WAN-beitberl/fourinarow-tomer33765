package Test1ArbaBeshura;

public class Board {

    private char[][] matrix;

    public Board(int height, int width)
    {
        this.matrix = new char[height][width];

        for (int i = 0; i < height; i++)
            for (int j = 0; j < width; j++)
                this.matrix[i][j] = ' ';
    }

    public boolean isEmpty(int row, int col)
    {
        return (this.matrix[row][col] == ' ');
    }

    public void setSquare(int row, int col, char sign)
    {
        this.matrix[row][col] = sign;
    }

    public void display()
    {
        for (int i = 0; i < this.matrix.length; i++) {
            for (int j = 0; j < this.matrix[0].length; j++) {
                System.out.print(" | "+this.matrix[i][j]);
            }
            System.out.println(" |");
        }
    }

    public boolean checkRow(int row, char color)
    {
        int discsInARow = 0;

        for (int i = 0; i < this.matrix[0].length; i++)
        {
            if(this.matrix[row][i] == color)
            {
                discsInARow++;
                if(discsInARow == ConnectFourGame.NUM_OF_DISCS_TO_WIN)
                    return true;
            }
            else discsInARow = 0;
        }

        return false;
    }

    public boolean checkCol(int col, char color)
    {
        int discsInARow = 0;

        for (int i = 0; i < this.matrix.length; i++)
        {
            if(this.matrix[i][col] == color)
            {
                discsInARow++;
                if(discsInARow == ConnectFourGame.NUM_OF_DISCS_TO_WIN)
                    return true;
            }
            else discsInARow = 0;
        }

        return false;
    }

    public boolean checkDiagByIndex(int row, int col, char color)
    {
        int startRowLeft = row;
        int startRowRight = row;
        int startColRight = col;
        int startColLeft = col;

        while(startRowLeft > 0 && startColLeft > 0)
        {
            startRowLeft--; startColLeft--;
        }

        while(startRowRight > 0 && startColRight < this.matrix[0].length - 1)
        {
            startRowRight--; startColRight++;
        }

        return (checkDiagFront(startRowLeft, startColLeft, color) ||
                checkDiagBack(startRowRight, startColRight, color));
    }

    public boolean checkDiagFront(int row, int col, char color)
    {
        int discsInARow = 0;
        int curRow = row;

        for (int curCol = col; curCol < this.matrix[0].length &&
                curRow < this.matrix.length; curCol++, curRow++)
        {
            if(this.matrix[curRow][curCol] == color)
            {
                discsInARow++;
                if(discsInARow == ConnectFourGame.NUM_OF_DISCS_TO_WIN)
                    return true;
            }
            else discsInARow = 0;
        }

        return false;
    }

    public boolean checkDiagBack(int row, int col, char color)
    {
        int discsInARow = 0;
        int curRow = row;

        for (int curCol = col; curCol > 0 &&
                curRow < this.matrix.length; curCol--, curRow++)
        {
            if(this.matrix[curRow][curCol] == color)
            {
                discsInARow++;
                if(discsInARow == ConnectFourGame.NUM_OF_DISCS_TO_WIN)
                    return true;
            }
            else discsInARow = 0;
        }

        return false;
    }

}
