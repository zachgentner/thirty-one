//TODO: Make methods static so that they can be implemented in both the game class and the round class.

package ui;

import cards.Card;
import logic.Player;

import java.util.Scanner;

public abstract class UserInterface {

    public static Scanner scanner = new Scanner(System.in);

    public UserInterface(Scanner scanner) {
        this.scanner = scanner;
    }

    public static void welcomeMessage() {
        System.out.println("Welcome to Thirty-One!\n");
    }

    public static void playerChoices(Card topDiscard) {
        System.out.println("Would you like to draw from the deck (1), take a " + topDiscard + " (2), or knock (3)?");
    }

    public static void playerTurnPrompt(Player player) {
        System.out.println("It's " + player.getName() + "'s turn to play.");
    }

    public static void howManyPlayers() {
        System.out.println("How many players would you like to have in this game?");
        System.out.println("Please, select a number between 2 and 10.");
    }

    public void knock() {
        System.out.println("Player has knocked!");
    }

}