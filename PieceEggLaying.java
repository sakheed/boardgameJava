/**
 *<h1> Lab 4: Piece Egg Laying Class </h1>
 * <h2> CISC 181 Summer 2022 </h2>
 * <h3> University of Delaware </h3>
 * Description: This egg laying class extends the Piece base class and includes all of the methods and variables relating to pieces that lay eggs such as the hen and penguin.
 *
 *
 * @author Sakhee Desai
 * @since 2022-07-21
 */
public abstract class PieceEggLaying extends Piece{
    protected int numEggs;
    final protected static int MAX_EGGS = 2;

    public PieceEggLaying(String symbol, String color, int numEggs){
        super(symbol, color);
        this.numEggs = numEggs;
    }

    public int getNumEggs()  {
        return this.numEggs;
    }


    public void incrementNumEggs() {
        this.numEggs++;
    }
    public abstract PieceEggLaying layEgg();

}
