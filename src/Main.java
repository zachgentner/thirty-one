import logic.*;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Main {
    public static void main(String args[]){
        /*ArrayList<Player> players = new ArrayList<>();
        Player p1 = new Player("Player 1");
        Player p2 = new Player("Player 2");
        players.add(p1);
        players.add(p2);

        Round round = new Round(players);
        round.startRound();
        for(Player player : players){
            System.out.println(player.getName());
            System.out.println("Score: " + player.getScore());
            System.out.println("Strikes: " + player.getStrikes());
        }*/


        Game game = new Game();
        game.startGame();

    }

}
