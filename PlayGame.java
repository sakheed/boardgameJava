/**
 *<h1> Lab 6: PlayGame Class </h1>
 * <h2> CISC 181 Summer 2022 </h2>
 * <h3> University of Delaware </h3>
 * Description: This final class has a main method that allows two players to actually create and play
 * a game using all of the previously created classes.
 *
 * @author Sakhee Desai
 * @since 2022-8-02
*/

import java.util.ArrayList;
import java.util.*;

public class PlayGame {
    private Game181 game181;

    public PlayGame(Game181 game181){
        this.game181 = game181;
    }


    private char getValidActionType(){
            Scanner action = new Scanner(System.in);
            char c;
            while(true) {
                System.out.print("Enter a character: ");
                c = action.next().charAt(0);
                if (c=='m'){
                    return c;
                }
                if (c=='a'){
                    return c;
                }
                if (c=='r'){
                    return c;
                }
            }
    }



    private void nextPlayersAction(){

        //calls getValid action type
        char c = getValidActionType();

        System.out.println("Enter the row and then the column index of your from space: ");
        Scanner scnr = new Scanner(System.in);
        int fromRow = scnr.nextInt();
        int fromCol = scnr.nextInt();

        System.out.println("Enter the row and then the column index of your to space: ");

        int toRow = scnr.nextInt();
        int toCol = scnr.nextInt();

        //creates instance of action subclass based on user's selection


        if (c=='a' || c =='A'){
            ActionAttack attack = new ActionAttack(game181, fromRow, fromCol, toRow, toCol);
            if (attack.validAction()) {
                attack.performAction();
            }
        }
        if (c=='r' || c =='R'){
            ActionRecruit recruit = new ActionRecruit(game181, fromRow, fromCol, toRow, toCol);
            if (recruit.validAction()) {
                recruit.performAction();
            }
        }
        if (c=='m' || c =='M'){
            ActionMove move = new ActionMove(game181, fromRow, fromCol, toRow, toCol);
            if (move.validAction()) {
                move.performAction();
            }
        }

        //if not valid, repeat previous steps
    }

    public void playOurGame(){
        while(!game181.isGameOver()){
            nextPlayersAction();
            System.out.println(game181);
        }
        System.out.println("Game over! Team" + game181.getCurrentTeam().getTeamName() + "has won!");
    }

    public static void main(String[] args){
        // Create 3 pieces for Team A
        Piece nemoA = new PieceSharkBait("Nemo","Red");
        Piece blueHenA = new PieceBlueHen("Hen ","Red",0,0);
        Piece penguinA = new PiecePenguin("Peng","Red",0,0);
        // Create an array list to hold Team A's pieces
        ArrayList<Piece> piecesTeamA = new ArrayList<>();
        piecesTeamA.add(nemoA);
        piecesTeamA.add(blueHenA);
        piecesTeamA.add(penguinA);
        // Create 3 pieces for Team B
        Piece nemoB = new PieceSharkBait("Nemo","Green");
        Piece blueHenB = new PieceBlueHen("Hen ","Green",0,0);
        Piece penguinB = new PiecePenguin("Peng","Green",0,0);
        // Create an array list to hold Team B's pieces
        ArrayList<Piece> piecesTeamB = new ArrayList<>();
        piecesTeamB.add(nemoB);
        piecesTeamB.add(blueHenB);
        piecesTeamB.add(penguinB);
        // Create TeamA and TeamB objects and pass them the array lists of pieces
        Team teamA = new Team("A", "Red",piecesTeamA);
        Team teamB = new Team("B",  "Green",piecesTeamB);
        // Create an instance of the game
        Game181 ourGame = new Game181(4, 4,teamA, teamB);
        // Print Board at start of game
        System.out.println(ourGame.getBoard().toString());
        // Create PlayGame object and play the game
        PlayGame play = new PlayGame(ourGame);
        play.playOurGame();
    }
}
