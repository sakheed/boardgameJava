import java.util.ArrayList;
import java.util.List;


public class Team {
    private String teamName;
    private String teamColor;
    private ArrayList <Piece> pieces;

    public Team(String teamName, String color, ArrayList <Piece> pieces){
        this.teamName = teamName;
        this.teamColor = color;
        this.pieces = pieces;
    }

    public String getTeamName() {
        return teamName;
    }

    public String getTeamColor() {
        return teamColor;
    }

    public ArrayList<Piece> getTeamPieces() {
        return pieces;
    }

    public void removePieceFromTeam(Piece piece){
        //remove piece from pieces
        pieces.remove(piece);
    }

    public void addPieceToTeam(Piece piece){
        //add piece to pieces
        pieces.add(piece);
        piece.color = teamColor;
    }

    @Override
    public String toString(){
        return "Team " + teamName+": " + teamColor+
                "Pieces : " + pieces;
    }
}
