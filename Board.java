/**
 *<h1> Lab 4: Board Class </h1>
 * <h2> CISC 181 Summer 2022 </h2>
 * <h3> University of Delaware </h3>
 * Description: This board class uses a 2D array of the board spaces class to create a grid with certain pieces on it.
 *
 *
 * @author Sakhee Desai
 * @since 2022-07-21
 */
public class Board {
    private int numRows;
    private int numColumns;
    private BoardSpace[][] spaces;

    public Board(int numRows, int numColumns){
        this.numRows = numRows;
        this.numColumns = numColumns;
        this.spaces = new BoardSpace[numRows][numColumns];
        setUpEmptyBoard();
    }

    public int getNumRows() {
        return numRows;
    }

    public int getNumColumns() {
        return numColumns;
    }

    public BoardSpace[][] getSpaces() {
        return spaces;
    }
//returns a boolean value representing whether the location of this space is within the
//bounds of the board  (for example  inBounds(5,5) should return false for any board
//with less than 6 rows or less than 6 columns)
    public boolean inBounds(int rowIndex, int columnIndex){
        boolean notNegative = rowIndex >=0 && columnIndex >=0;
        boolean inBounds = rowIndex < this.numRows && columnIndex < this.numColumns;

        return notNegative && inBounds;
    }
//creates a BoardSpace object for each location in the spaces 2 dimensional array.
//Use nested loops!  You can set the color of each space to anything you’d like, you can
//make them all the same color or alternate colors –
    public void setUpEmptyBoard() {
        for (int i = 0; i < this.numRows; i++) {
            for (int j = 0; j < this.numColumns; j++) {
                if (j%2 ==0){
                    BoardSpace white = new BoardSpace(i,j,"White");
                    spaces[i][j] = white;
                }
                else{
                    BoardSpace blue = new BoardSpace(i,j,"Blue");
                    spaces[i][j] = blue;
                }
            }
        }

        for (int i =0; i<this.numRows;i = i+2){
            for(int j =0; j<this.numColumns; j++){
                if (j%2 ==0){
                    BoardSpace white = new BoardSpace(i,j,"White");
                    spaces[i][j] = white;
                }

                else{
                    BoardSpace blue = new BoardSpace(i,j, "Blue");
                    spaces[i][j] = blue;
                }
            }
        }
    }
    public BoardSpace findRandomEmptySpace() {
         boolean empty = false;
         int row = 0;
         int column =0;
        while(!empty){
            row = (int) (Math.random() * (this.numRows-1));
            column = (int) (Math.random() * (this.numColumns-1));
            empty = this.spaces[row][column].isEmpty();
            }
        return this.spaces[row][column];
    }
    @Override
    public String toString(){
        StringBuilder boardString = new StringBuilder();
        boardString.append("Col :     ");
        for(int col = 0; col < spaces[0].length; col++){
            boardString.append(col + "       ");
        }
        boardString.append("\n");
        for(int row = 0; row < spaces.length; row++){
            boardString.append("Row : " + row + "   ");
            for(int col = 0; col < spaces[row].length; col++){
                boardString.append(spaces[row][col].toString() + "  ");
            }
            boardString.append("\n");
        }
        return boardString.toString();
    }


}
