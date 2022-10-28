/**
 *<h1> Lab 4: PieceSharkBait Subclass </h1>
 * <h2> CISC 181 Summer 2022 </h2>
 * <h3> University of Delaware </h3>
 * Description: This subclass defines the shark bait piece as an extended sub class
 * of the main Piece abstract class.
 *
 * @author Sakhee Desai
 * @since 2022-07-22
 */
public class PieceSharkBait extends Piece implements Recruiter{
    public PieceSharkBait(String symbol, String color){
        super(symbol, color);
//        this.symbol = symbol;
//        this.color = color;
       this.hidden = false;
    }
    // constructor for when color information is not available yet
    public PieceSharkBait(String symbol){
        this(symbol,"");
    }
    public void speak(){
        System.out.println("Shark bait oooh ha haa!");
    }

    @Override
    public boolean validPath(int originalRow, int originalColumn, int newRow, int newColumn) {
        //can move 2 spaces diagonally
        if ((newRow == (originalRow + 2)) && (newColumn == (originalColumn + 2)))
            return true;
        if ((newRow == (originalRow - 2)) && (newColumn == (originalColumn - 2)))
            return true;
        if ((newRow == (originalRow - 2)) && (newColumn == (originalColumn + 2)))
            return true;
        if ((newRow == (originalRow + 2)) && (newColumn == (originalColumn - 2)))
            return true;
        System.out.println("can move 2 spaces diagonally");
        return false;
    }
    public void recruit(int fromRow, int fromCol, int toRow, int toCol){
        System.out.println("You're on my team now! – other piece removed from other team and added to this team.");
    }

}