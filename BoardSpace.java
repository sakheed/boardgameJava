/**
 *<h1> Lab 4: BoardSpace Class </h1>
 * <h2> CISC 181 Summer 2022 </h2>
 * <h3> University of Delaware </h3>
 * Description: This board space class has a row index, column index, color, and piece. It uses the toString method to render either the piece name
 * or an ---- in the grid to indicate empty.
 *
 *
 * @author Sakhee Desai
 * @since 2022-07-21
 */
public class BoardSpace {
    private int row;
    private int column;
    private String spaceColor;
    private boolean empty;
    private Piece piece;

    public BoardSpace(int row,int column,String spaceColor){
        this.row = row;
        this.column = column;
        this.spaceColor = spaceColor;
        empty = true;
    }

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }

    public String getSpaceColor() {
        return spaceColor;
    }

    public boolean isEmpty() {
        return empty;
    }

    public Piece getPiece() {
        return piece;
    }

    public void setPiece(Piece piece) {
        this.piece = piece;
        empty = false;
    }

    public Piece removePiece(){
        Piece removedPiece;
        removedPiece = piece;
        piece = null;
        empty = true;
        return removedPiece;
    }

    @Override
    public String toString() {
        if (empty){
            return "------";
        }
        return "" +
                piece +
                "";
    }
}
