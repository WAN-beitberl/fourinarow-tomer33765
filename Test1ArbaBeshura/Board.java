package Test1ArbaBeshura;

public class Board {
    public enum square{EMPTY, RED, YELLOW}

    private square[][] matrix;

    public Board(int height, int width)
    {
        this.matrix = new square[height][width];

        for (int i = 0; i < height; i++)
            for (int j = 0; j < width; j++)
                this.matrix[i][j] = square.EMPTY;
    }

    public boolean isEmpty(int row, int col)
    {
        return (this.matrix[row][col] == square.EMPTY);
    }

    public void setSquare(int row, int col, square color)
    {
        this.matrix[row][col] = color;
    }

    public void display()
    {
        for (int i = 0; i < this.matrix.length; i++) {
            for (int j = 0; j < this.matrix[0].length; j++) {
                switch (this.matrix[i][j]) {
                    case EMPTY -> System.out.print(" |");
                    case RED -> System.out.print("R|");
                    case YELLOW -> System.out.print("Y|");
                }
            }
            System.out.println();
        }
    }

    public boolean checkRow(int row, int col)
    {
        boolean flag1 = true;
        boolean flag2 = true;
        for (int i = 1; i < 4; i++)
        {
            if(col+i == this.matrix[0].length) { flag1 = false;}
            else if(flag1)
            {
                if(this.matrix[row][col+i-1] != this.matrix[row][col+i]) flag1 = false;
            }
            if(col-i+1 == 0) { flag2 = false;}
            else if(flag2)
            {
                if(this.matrix[row][col-i+1] != this.matrix[row][col-i]) flag2 = false;
            }
        }

        return (flag1||flag2);
    }

    public boolean checkCol(int row, int col)
    {
        boolean flag1 = true;
        boolean flag2 = true;
        for (int i = 1; i < 4; i++)
        {
            if(row+i == this.matrix.length) { flag1 = false;}
            else if(flag1)
            {
                if(this.matrix[row+i-1][col] != this.matrix[row+i][col]) flag1 = false;
            }
            if(row-i+1 == 0) { flag2 = false;}
            else if(flag2)
            {
                if(this.matrix[row-i+1][col] != this.matrix[row-i][col]) flag2 = false;
            }
        }

        return (flag1||flag2);
    }

    public boolean checkDiag(int row, int col)
    {
        boolean flag1 = true;
        boolean flag2 = true;
        boolean flag3 = true;
        boolean flag4 = true;
        for (int i = 1; i < 4; i++)
        {
            if(row+i == this.matrix.length||col+i==this.matrix[0].length)
            { flag1 = false;}
            else if(flag1)
            {
                if(this.matrix[row+i-1][col+i-1] != this.matrix[row+i][col+i]) flag1 = false;
            }
            if(row+i == this.matrix.length||col-i+1==0) { flag2 = false;}
            else if(flag2)
            {
                if(this.matrix[row+i-1][col-i+1] != this.matrix[row+i][col-i]) flag2 = false;
            }
            if(row-i+1 == 0||col+i==this.matrix[0].length) { flag3 = false;}
            else if(flag3)
            {
                if(this.matrix[row-i+1][col+i-1] != this.matrix[row-i][col+i]) flag3 = false;
            }
            if(row-i+1 == 0||col-i+1==0) { flag4 = false;}
            else if(flag4)
            {
                if(this.matrix[row-i+1][col-i+1] != this.matrix[row-i][col-i]) flag4 = false;
            }
        }

        return (flag1||flag2||flag3||flag4);
    }
}
