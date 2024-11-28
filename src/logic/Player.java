package logic;

import cards.*;

public class Player {

    private String name;
    private Hand hand = new Hand(); // Each player has a hand of 3 cards, which will determine their total point value.
    private int score; // The player's score represents the current same-suit value of the cards in their hand.
    private int strikes = 0; //Each player has a tally of strikes based upon how many rounds they have lost.

    public Player(String name) {
        this.name = name;
        strikes = 0;
    }

    public void exchangeCard(int index, Card card, Deck discardDeck) {
        hand.exchangeCard(index - 1, card, discardDeck);
    } //Exchanges a card from the players hand with another card passed to the method as a parameter. The card is then discarded into the deck passed as a parameter.

    public Hand getHand() {
        return hand;
    } //Returns the hand of the player as an object variable.

    public void checkHand() {
        System.out.println(name);
        System.out.println(hand.toString());
        System.out.println("Total point value: " + hand.getPointValue());
    } //Returns the three cards within the player's hand as a string.

    public void drawCards(Deck deck){
        hand.drawHand(deck);
    } //Draws three cards into the players hand from the deck passed as a parameter.

    public String getName(){
        return name;
    }

    public int getScore() {
        score = hand.getPointValue();
        return score;
    } //Returns the point value of the same-suited cards within the player's hand.

    public int getStrikes() {
        return strikes;
    } //Returns the number of strikes the player has as an integer.

    public void printStrikes(){
        if(strikes == 1){
            System.out.println(name +  " has " + strikes + " strike.");
        } else {
            System.out.println(name + " has " + strikes + " strikes.");
        }
    } //Returns the number of strikes the player has as a string.

    public void addStrikes(){
        strikes++;
    } //Adds a strike to the player's total number of strikes.

    @Override
    public String toString(){
        return name;
    }
}
