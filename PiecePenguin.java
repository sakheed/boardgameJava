/**
 *<h1> Lab 4: PiecePenguin Subclass </h1>
 * <h2> CISC 181 Summer 2022 </h2>
 * <h3> University of Delaware </h3>
 * Description: This subclass defines the penguin piece as an extended sub class
 * of the main Piece abstract class.
 *
 * @author Sakhee Desai
 * @since 2022-07-22
 */
public class PiecePenguin extends PieceEggLaying implements Attacker, Recruiter {
    private int numAttacked;

    public PiecePenguin(String symbol, String color, int numEggs, int numAttacked){
        super(symbol, color, numEggs);
        //this.symbol = symbol;
        //this.color = color;
        //this.numEggs = numEggs;
        this.numAttacked = numAttacked;
        this.hidden = false;
    }
    // constructor for when color information not available yet
    public PiecePenguin(String symbol){
        this(symbol,"",0,0);
    }
    public void speak(){
        System.out.println("Smile and wave boys. Smile and wave.");
    }

    @Override
    public boolean validPath(int originalRow, int originalColumn, int newRow, int newColumn){
        if (originalRow == newRow){
            return true;
        }
        if ((originalColumn == newColumn) && ((newRow == (originalRow + 1)) || (newRow == (originalRow - 1)))){
            return true;
        }
        System.out.println("Slide - piece can move left or right (one or more spaces) and NOT up and down");
        System.out.println("Or it can move one space up or down the board");
        return false;
    }
    public void attack(int fromRow, int fromCol, int toRow, int
            toCol){
        this.numAttacked++;
        System.out.println("Attack with lasers other piece removed from other team and added to this team.");
    }
    public PiecePenguin layEgg(){
        // if this piece hasn't laid max eggs yet - allow it create new piece
        if( this.numEggs < MAX_EGGS){
            this.incrementNumEggs();
            // this creates a new piece that has not laid any eggs
            // and has not attacked any pieces yet it will belong to this team so pass in Color
            return new PiecePenguin(this.symbol, this.color,0,0);
        }
        else{
            return null;
        }
    }
    public int getNumAttacked() {
        return this.numAttacked;
    }

    public void incrementNumAttacked( ){
        this.numAttacked++;
    }

    @Override
    public void recruit(int recruiterRow, int recruiterColumn, int recruitedRow, int recruitedColumn) {
        speak();
        System.out.println("Penguin recruiting");
    }
}