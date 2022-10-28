/**
 *<h1> Lab 6: ActionAttack Class </h1>
 * <h2> CISC 181 Summer 2022 </h2>
 * <h3> University of Delaware </h3>
 * Description: This class will represent an action the player can take where they attack an opponent’s piece on the to
 * space with their own piece on the from space
 *
 * @author Sakhee Desai
 * @since 2022-8-02
 */
public class ActionAttack extends Action {
    // constructor
    public ActionAttack(Game181 game, int fromSpaceRow, int fromSpaceCol, int
            toSpaceRow, int toSpaceCol) {
        super(game, fromSpaceRow,fromSpaceCol,toSpaceRow,toSpaceCol);
    }
    // Check to see if this is valid Attack Action
    public boolean validAction() {
        // check if from space valid
        if(fromSpaceValid() ) {
            // get the piece that is in the from BoardSpace
            Piece fromPiece = game181.getBoard().getSpaces()
                    [fromRow][fromCol].getPiece();
            // check to see if this piece has implemented the Attacker interface
            if (Attacker.class.isAssignableFrom(fromPiece.getClass())) {
                // if to space is valid - should NOT be empty so pass false to the method
                if (toSpaceValid(false)) {
                    return validActionPath();
                }
            } else {
                System.out.println("The piece on first space can't attack.");
                return false;
            }
        }
        return false;
    }
    // this method calls the Piece's attack method
    private void attack(){
        // Get the piece that is in the fromSpace
        Piece attPiece = game181.getBoard()
                .getSpaces()[fromRow][fromCol].getPiece();
        // check to see which type of Piece we have
        // we can't call the attack method on all pieces in the game
        // we can only call these methods on pieces that have this method - ie -Pieces that have implemented the Attacker Interface
        // so we will cast the Piece to its subclass type so we can call attack
        if(attPiece instanceof PieceBlueHen){
            // cast and call BlueHen's attack method
            ((PieceBlueHen) attPiece)
                    .attack(fromRow,fromCol,toRow,toCol);
        }
        else if(attPiece instanceof PiecePenguin){
            // cast and call Penguin's attack method
            ((PiecePenguin) attPiece)
                    .attack(fromRow,fromCol,toRow,toCol);
        }
    }
    @Override
    public void performAction() {
        // call helper method attack
        attack();

        //get from space piece
        BoardSpace fromSpace = game181.getBoard().getSpaces()[fromRow][fromCol];
        Piece pieceFromSpace = fromSpace.getPiece();

        //get to space piece
        BoardSpace toSpace = game181.getBoard().getSpaces()[toRow][toCol];
        Piece pieceToSpace = toSpace.getPiece();

        //remove the attacked Piece from the board
        game181.getBoard().getSpaces()[toRow][toCol].removePiece();

        //remove the attacked Piece from the opponent’s team
        game181.getOpponentTeam().getTeamPieces().remove(pieceToSpace);

        //move the Piece in the from space to the to space
        toSpace.setPiece(pieceFromSpace);

        //change the turn
        game181.changeTurn();
    }
}