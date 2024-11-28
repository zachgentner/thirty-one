package logic;

import ui.UserInterface;

import java.util.ArrayList;
import java.util.HashMap;

public class Game { //This class represents a single game of thirty one, which consists of multiple rounds of player elimination.

    private int numberOfPlayers = 4; //Specifies the total number of players a user wishes to have.
    private ArrayList<Player> players = new ArrayList<>(); //Creates an array of players to accommodate the number of players specified in the constructor.
    private HashMap<Player, Integer> strikes = new HashMap<>(); //Keep track of the strikes of each player outside of the player class.
    public static int playerTurn = 0; // Keeps track of which player acts first in a round. Advances following each round.
    public static int maxNumberOfStrikes = 4; //Controls the maximum number of strikes a player is allowed to have before elimination.

    public Game() {
        createPlayers();
    }

    public void startGame() {
        UserInterface.welcomeMessage();
        int roundNum = 1;
        while (!this.gameOver()) { // Continue the loop as long as the game is not over.
            System.out.println("Round: " + roundNum);
            Round round = new Round(players); //Creates a new round with the remaining players.
            round.startRound(); //Starts the new round, which progresses through a game play loop.
            players = round.updatePlayers();//Update the player strikes by referencing the updated strikes at the end of the round.
            removePlayers(); //Removes the players that have received the maximum number of strikes.
            //the game then begins instructions on what to do next.
            //the player then chooses an action.
            //setPlayerTurn();//the game advances and the next player is now able to play.
            //updatePlayerTurn();
            roundNum++;
        }
    }

    public Player getPlayer(int index) {
        return players.get(index);
    }

    public ArrayList<Player> getPlayers() {
        return players;
    }

    public void removePlayers() {
        ArrayList<Player> remainingPlayers = new ArrayList<>();
        for (Player player : players) {
            if (player.getStrikes() < maxNumberOfStrikes) {
                remainingPlayers.add(player);
            }
        }
        players = remainingPlayers;
    } //Checks to see if the player has the maximum number strikes. If they do, they are removed from the game.

    public void setNumberOfPlayers() {

        UserInterface.howManyPlayers();

        if (numberOfPlayers <= 10) {
            this.numberOfPlayers = numberOfPlayers;
        } else {
            this.numberOfPlayers = 10;
        }
    }

    public int getNumberOfPlayers() {
        return players.size();
    }

    public void printNumberOfPlayers() {
        if (players.size() == 0) {
            System.out.println("There are no players participating in this game.");
        } else if (players.size() == 1) {
            System.out.println("There is " + numberOfPlayers + " player participating in this game.");
        } else {
            System.out.println("There are " + numberOfPlayers + " players participating in this game.");
        }
    }

    public void createPlayers() {
        for (int i = 0; i < numberOfPlayers; i++) {
            String name = "Player " + Integer.toString(players.size() + 1);//Names each player with an increasing number. Player 1, Player 2, etc.
            players.add(new Player(name));
        }
    } //Creates an array of new players, naming them by assigning increasing player numbers.

    public boolean gameOver() {
        if (players.size() == 1) {
            System.out.println(players.get(0) + " is the winner of the game!"); //Declare the winner of the game.
            return true;
        }
        if(players.size() == 0){
            System.out.println("You broke the game!");
            return true;
        }

        return false;
    } //Check to see if only one player remains. If so, they win the game.

    private void updatePlayerTurn(){
        for(Player player : players){
            if(players.size() > 1 && playerTurn < players.size()){
                playerTurn++;
            }
        }
    }
}

