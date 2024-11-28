//TODO: Add logic for special cases involving a player that knocks and has the same score as their opponent.

package logic;

import cards.*;
import ui.*;

import java.util.ArrayList;
import java.util.Scanner;

public class Round { //This class represents a single round of thirty one.
    private Deck drawPile; //The logic requires a deck of cards to draw from if the player does not wish to pick up the top discard card.
    private Deck discardPile; //The game requires a discard pile with the top card available for pickup by the player.
    private ArrayList<Player> players; //Keeps track of how many players remain in the game.
    private Scanner scanner = new Scanner(System.in);
    private Player knocker;

    public Round(ArrayList<Player> players) {
        this.players = players;
    }

    public void startRound() {
        drawPile = new Deck(); //Create a new deck of 52 cards for the game.
        discardPile = new Deck(); //Create an empty discard pile for the game.
        discardPile.addCard(drawPile.drawCard()); //Adds the top card of the draw pile into the discard pile.
        drawCards(); //Each player draws cards from the draw pile.
        startGameplay();
        //Create a game play loop.
        revealCards();

    }//Start a self-terminating loop to progress through the round.

    public ArrayList<Player> updatePlayers() {
        return players;
    }

    private void drawCards() {
        for (Player player : players) {
            player.drawCards(drawPile);
        }
    }

    private void startGameplay() {
        UserInterface.playerTurnPrompt(players.get(Game.playerTurn));
        UserInterface.playerChoices(discardPile.getTopCard());
        int choice = scanner.nextInt();
        if (choice == 1) {
            takeFromDrawPile();
        } else if (choice == 2) {
            //take the top card of the discard pile
        } else if (choice == 3) {
            //knock.
        }
    }

    private void takeFromDrawPile() {
        System.out.println("You drew a " + drawPile.getTopCard() + " from the deck.");
        System.out.println("Would you like to take this card (1) or discard it (2)?");
        int choice = scanner.nextInt();
        if (choice == 1) {
            replaceCard(players.get(0));
        } else {
            discardPile.addCard(drawPile.getTopCard());
            System.out.println("The top card on the discard pile is now a " + discardPile.getTopCard());
        }
    }

    private void takeFromDiscardPile(Card card) {

    }

    private void replaceCard(Player player) {
        System.out.println("Which card would you like to replace? (1) " + player.getHand().getCard(1) + " (2) " + player.getHand().getCard(2) + " (3) " + player.getHand().getCard(3));
    }

    private void revealCards() {
        int lowestScore = 100;

        for (Player player : players) {
            if (player.getScore() <= lowestScore) {
                lowestScore = player.getScore();
            }
        } //Finds the lowest scoring hand among all players.

        //TODO: Add functionality to elimiate only the player that knocked if they share a score.
        for (Player player : players) {
            if (player.getScore() == lowestScore) {
                player.addStrikes();
                declareLoser(player);
            }
        } //Iterates through all players and add strikes if their hand score matches the lowest score.
    }

    private void declareLoser(Player player) {
        System.out.println("-----------POST ROUND REPORT------------");
        System.out.println(player.getName() + " has lost this round! They now have " + player.getStrikes() + " strikes.");
        if (player.getStrikes() == Game.maxNumberOfStrikes) {
            System.out.println(player.getName() + " has been eliminated from the game!");
        }
    } //Print the losing player to the terminal.

}
