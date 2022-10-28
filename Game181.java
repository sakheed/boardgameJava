public class Game181 extends Game{

    public Game181(int numRows, int numColumns, Team teamOne, Team teamTwo){
        super(numRows, numColumns, teamOne,teamTwo);
    }
    @Override
    public boolean isAWinner() {
        if (isGameOver()){
            return true;
        }
        return false;
    }

    @Override
    public Team getWinner() {
        if (!isAWinner()){
            return null;
        }
        if (getCurrentTeam().getTeamPieces().isEmpty()){
            return getOpponentTeam();
        }
        if (getOpponentTeam().getTeamColor().isEmpty()){
            return getCurrentTeam();
        }
        return null;
    }

    @Override
    public boolean isGameOver() {
        if (getCurrentTeam().getTeamPieces().isEmpty()){
            return true;
        }
        if (getOpponentTeam().getTeamPieces().isEmpty()){
            return true;
        }
        return false;
    }
}
