/**
 *<h1> Lab 6: Action Class </h1>
 * <h2> CISC 181 Summer 2022 </h2>
 * <h3> University of Delaware </h3>
 * Description: This is an abstract class that checks if the current space in the game contains the accurate pieces
 * and that the actions are valid paths based on the individual piece methods.
 *
 * @author Sakhee Desai
 * @since 2022-8-02
 */
public abstract class Action{
    protected Game181 game181;
    protected int fromRow;
    protected int fromCol;
    protected int toRow;
    protected int toCol;

    public Action(Game181 game181, int fromRow, int fromCol, int toRow, int toCol){
        this.game181 = game181;
        this.fromRow = fromRow;
        this.fromCol = fromCol;
        this.toRow = toRow;
        this.toCol = toCol;
    }

    public boolean fromSpaceValid(){
        //checks if the from space is in bounds
        boolean checkOne = game181.getBoard().inBounds(fromRow,fromCol);

        if (!checkOne) return false;

        //checks if the boardspace with the from index contains a piece from the current team
        BoardSpace fromSpace = game181.getBoard().getSpaces()[fromRow][fromCol];
        boolean checkTwo = game181.getCurrentTeam().getTeamPieces().contains(fromSpace.getPiece());
        return checkTwo;
    }

    public boolean toSpaceValid(boolean shouldEmpty){
        boolean checkOne = game181.getBoard().inBounds(toRow, toCol);
        if (!checkOne) return false;

        boolean checkIsEmpty = game181.getBoard().getSpaces()[toRow][toCol].isEmpty();

        if (shouldEmpty && checkIsEmpty){
                return true;
        }
        if (!shouldEmpty && !checkIsEmpty){
            Piece toSpace = game181.getBoard().getSpaces()[toRow][toCol].getPiece();
            if (game181.getOpponentTeam().getTeamPieces().contains(toSpace)) {
                return true;
            }
            return false;
        }
        return false;
    }

    public boolean validActionPath(){
        //checks if path from space to space is valid based on type of piece on from space
        Piece fromPiece = game181.getBoard().getSpaces()[fromRow][fromCol].getPiece();

        if (fromPiece.validPath(fromRow,fromCol,toRow,toCol)){
            return true;
        }
        return false;
    }

    public abstract boolean validAction();
    public abstract void performAction();

        }
