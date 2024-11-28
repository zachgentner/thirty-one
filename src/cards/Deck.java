package cards;

import java.util.ArrayList;
import java.util.Collections;

public class Deck {

    private ArrayList<Card> deck = new ArrayList<>();
    private final int cardsPerDeck = 52;
    private final int suitsPerDeck = 4;
    private final int cardsPerSuit = cardsPerDeck / suitsPerDeck;

    public Deck() { //Creates a standard deck of 52 playing cards with 4 suits and 13 cards per suit.
        for (int i = 0; i < suitsPerDeck; i++) {
            for (int j = 1; j <= cardsPerSuit; j++) {
                deck.add(new Card(i + 1, j));
            }
        }

        shuffleDeck(deck);
    }

    public Deck(int numberOfCardsInDeck) {
        Deck fullDeck = new Deck();

        while(numberOfCardsInDeck > 0){
            this.deck.add(fullDeck.drawCard());
            numberOfCardsInDeck--;
        }
    } //Adds random cards from a full deck unless the number is set to zero.

    public Card drawCard() {
        deck.get(0).toString(); //draws the first card in the array, which would be the top card of the deck.
        Card drawCard = deck.get(0); //the draw card information is retained by using a separate variable.
        deck.remove(0); //removes the draw card from the array permanently.
        return drawCard; //returns the card that was drawn.
    } //Remove and return a card from the deck and return the card when called.

    public void shuffleDeck(ArrayList<Card> deck) {
        Collections.shuffle(deck);
    } //Randomizes the order of the cards within the deck.

    public void addCard(Card card) {
        deck.add(card);
    } //Adds the card passed as a parameter to the deck this method is called on.

    public int getCardsRemaining() {
        return deck.size();
    } //Returns the number of cards within the deck as an integer.

    public boolean hasCardsRemaining(){
        return (getCardsRemaining() >= 1);
    } //Returns true if the deck still contains cards and false if it does not.

    public void printCardsRemaining() {
        if (deck.size() == 1) {
            System.out.println(deck.size() + " card remains.");
        } else {
            System.out.println(deck.size() + " cards remain.");
        }
    } //Returns the number of cards within the deck as a string.

    public Card getTopCard(){
        if(deck.size() == 0){
            return null;
        }
        return deck.get(deck.size() - 1);
    }

    public void printTopCard(){
        if(deck.size() > 0){
            System.out.println("The top card in the deck is a " + getTopCard());
        } else {
            System.out.println("There are no cards in this deck.");
        }
    }

    @Override
    public String toString() {
        for (Card card : deck) {
            System.out.println(card.toString());
        }
        return "The cards above remain in the deck.";
    } //Prints all of the remaining cards left in the deck.


}
