/**
 *<h1> Lab 4: PieceBlueHen Subclass </h1>
 * <h2> CISC 181 Summer 2022 </h2>
 * <h3> University of Delaware </h3>
 * Description: This subclass defines the blue hen piece as an extended sub class
 * of the main Piece abstract class.
 *
 * @author Sakhee Desai
 * @since 2022-07-22
 */
public class PieceBlueHen extends PieceEggLaying implements Attacker{
    private boolean fly;
    private int numAttacked;
    public PieceBlueHen(String symbol, String color, int numEggs, int numAttacked) {
        super(symbol, color, numEggs);
        //this.symbol = symbol;
        //this.color = color;
        //this.numEggs = numEggs;
        this.numAttacked = numAttacked;
        this.hidden = false;
        updateFly();
    }

    // constructor for when color information not available yet
    // and brand new piece that hasn’t laid eggs and hasn’t attacked
    public PieceBlueHen(String symbol) {
        this(symbol, "", 0, 0);
    }

    public void speak() {
        System.out.println("Go UD!");
    }



    public boolean canFly() {
        return this.fly;
    }

    public void incrementNumEggs() {
        this.numEggs++;
        updateFly();
    }

    public void incrementNumAttacked() {
        this.numAttacked++;
        updateFly();
    }

    @Override
    public boolean validPath(int originalRow, int originalColumn, int newRow, int newColumn) {
        if (!fly){
            if (((newRow == originalRow + 1) && (newColumn == originalColumn))|| ((newRow == originalRow -1) && (newColumn == originalColumn) )|| ((newColumn == originalColumn+1) && (newRow == originalRow) )|| ((newColumn == originalColumn-1) && (newRow == originalRow))){
                return true;
            }
            else{
                return false;
            }
        }

        System.out.println("If can't fly -> can move one space left, or right, or up, or down.\n" +"If can fly -> can move to any empty space on board.");
        return true;

    }

    public void attack(int attackerRow, int attackerColumn, int victimRow, int victimColumn) {
        this.incrementNumAttacked();
        speak();
        System.out.println("Attacks with claws – other piece removed from game.");
    }

    public PieceBlueHen layEgg() {
        // if this piece hasn't laid max eggs yet - allow it create new piece
        if (this.numEggs < MAX_EGGS) {
            this.incrementNumEggs();
            // creates a new piece that has the same number of eggs laid and attacked pieces
            // as this piece
            return new
                    PieceBlueHen(this.symbol, this.color, this.numEggs, this.numAttacked);
        } else {
            return null;
        }
    }

    private void updateFly() {
        if (this.numEggs < MAX_EGGS) {
            this.fly = true;
        } else if (this.numAttacked == 0) {
            this.fly = true;
        } else {
            this.fly = false;
        }
    }
    public int getNumAttacked() {
        return this.numAttacked;
    }


}
