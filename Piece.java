/**
 *<h1> Lab 4: Piece Abstract Class </h1>
 * <h2> CISC 181 Summer 2022 </h2>
 * <h3> University of Delaware </h3>
 * Description: This abstract class is the base class for all of the three piece classes
 * in this lab. It contains the common member fields of symbol, color, and hidden, as
 * well as a default constructor and the common methodn names that will be overridden in the
 * subclasses.
 *
 * @author Sakhee Desai
 * @since 2022-07-22
 */
public abstract class Piece {
    protected String symbol;
    protected String color;
    protected boolean hidden;

    public Piece(String symbol, String color){
        this.symbol = symbol;
        this.color = color;
        this.hidden = false;
    }

    public String getSymbol() {
        return symbol;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public boolean isHidden() {
        return hidden;
    }

    public void setHidden(boolean hidden) {
        this.hidden = hidden;
    }

    public String toString(){
        return color.charAt(0) + "-" + symbol;
    }
    public abstract void speak();
    public abstract boolean validPath(int originalRow, int originalColumn, int newRow, int newColumn);
}
