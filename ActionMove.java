/**
 *<h1> Lab 6: ActionMove Class </h1>
 * <h2> CISC 181 Summer 2022 </h2>
 * <h3> University of Delaware </h3>
 * Description: This class will represent an action the user can take where they move their own piece from the from
 * space on the board to an empty to space on the board.
 *
 * @author Sakhee Desai
 * @since 2022-8-02
 */
public class ActionMove extends Action{
    public ActionMove(Game181 game181, int fromRow, int fromCol, int toRow, int toCol){
        super(game181, fromRow, fromCol, toRow, toCol);
    }

    @Override
    public boolean validAction() {
        if (super.fromSpaceValid()&& super.toSpaceValid(true) && super.validActionPath()) {
            return true;
        }
        return false;
    }

    @Override
    public void performAction() {
        Piece fromPiece = game181.getBoard().getSpaces()[fromRow][fromCol].getPiece();
        //remove piece from the from space
        game181.getBoard().getSpaces()[fromRow][fromCol].removePiece();
        //set piece on the to space
        game181.getBoard().getSpaces()[toRow][toCol].setPiece(fromPiece);
        // change turn
        game181.changeTurn();

    }
}
