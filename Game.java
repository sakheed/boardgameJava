import java.util.Collections;

public abstract class Game {
    protected Board board;
    protected Team playerOneTeam;
    protected Team playerTwoTeam;
    protected String turn;

    private void initializeGameBoard(int numRows, int numColumns){
        this.board = new Board(numRows, numColumns);
        for (Piece piece : playerOneTeam.getTeamPieces()){
            BoardSpace randomEmptySpace = this.board.findRandomEmptySpace();
            randomEmptySpace.setPiece(piece);
        }
        for (Piece piece : playerTwoTeam.getTeamPieces()){
            BoardSpace randomEmptySpace = this.board.findRandomEmptySpace();
            randomEmptySpace.setPiece(piece);
        }
    }


    public Game(int numRows, int numColumns, Team playerOneTeam, Team playerTwoTeam){
        this.playerOneTeam = playerOneTeam;
        this.playerTwoTeam = playerTwoTeam;
        this.turn = playerOneTeam.getTeamName();
        initializeGameBoard(numRows,numColumns);
    }

    public Board getBoard() {
        return board;
    }

    public Team getCurrentTeam() {
        return playerOneTeam;
    }

    public Team getOpponentTeam() {
        return playerTwoTeam;
    }

    public boolean isTurn(Team testTeam){
        if (testTeam == playerOneTeam){
            return true;
        }
        return false;
    }

    public void changeTurn(){
        this.turn = isTurn(playerOneTeam) ? playerTwoTeam.getTeamName() : playerOneTeam.getTeamName();
    }

    public abstract boolean isAWinner();

    public abstract Team getWinner();

    public abstract boolean isGameOver();

    @Override
    public String toString(){
        StringBuilder retString =new StringBuilder();
        retString.append("Game Board:\n")
                .append(String.join("", Collections.nCopies(50,"*")))
                .append("\n"+ getBoard().toString())
                .append(String.join("", Collections.nCopies(50,"*")))
                .append("\n"+ getCurrentTeam().toString() +"\n")
                .append(String.join("", Collections.nCopies(50,"*")))
                .append("\n"+ getOpponentTeam().toString()+"\n")
                .append(String.join("", Collections.nCopies(50,"*")))
                .append("\nIt is Team " + getCurrentTeam().getTeamName()+"'s turn\n");
        return retString.toString();
    }


}
