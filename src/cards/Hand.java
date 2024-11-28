package cards;

import java.util.HashMap;

public class Hand {
    private int pointValue;
    private int maxCardsInHand = 3;
    private Card[] hand = new Card[maxCardsInHand];

    public void drawHand(Deck deck) {
        for (int i = 0; i < maxCardsInHand; i++) {
            hand[i] = deck.drawCard();
        }
        pointValue = getPointValue();
    } //Draws a hand of three cards from the deck passed as a parameter.

    public void setPointValue() {
        HashMap<String, Integer> pointsPerSuit = new HashMap<>();

        for (int i = 0; i < maxCardsInHand; i++) {
            if (pointsPerSuit.containsKey(hand[i].getSuit())) {
                int newPoints = pointsPerSuit.get(hand[i].getSuit()) + hand[i].getPoints();
                pointsPerSuit.put(hand[i].getSuit(), newPoints);
            } else {
                pointsPerSuit.put(hand[i].getSuit(), hand[i].getPoints());
            }
        } //assigns a value to each suit within a players hand.

        int highestPointsValue = 0;

        for (int points : pointsPerSuit.values()) {
            if (points > highestPointsValue) {
                highestPointsValue = points;
            } //iterates through the suit/point pairs and finds the highest point value for each suit within the hand.
        }

        pointValue = highestPointsValue; //sets the players point value to the highest point value possible.
    } //Finds which like-suited cards within the hand have the highest combined point value.

    public int getPointValue() {
        setPointValue();
        return pointValue;
    } //Returns the total same-suit point value of the hand.

    public void exchangeCard(int index, Card card, Deck discardDeck) {
        discardDeck.addCard(hand[index]);
        hand[index] = card;
    }

    public Card getCard(int index) {
        if (index == 1) {
            return hand[0];
        } else if (index == 2) {
            return hand[1];
        } else if (index == 3) {
            return hand[2];
        } else {
            System.out.println("The player only has three cards in their hand. Please enter a value from 1-3");
        }
        return null;
    }

    public void replaceCard(int index, Card card) {
        hand[index] = card;
    } //Removes the card from the players hand at the index specified and replaces it with the card entered as a parameter.

    @Override
    public String toString() {
        return "Cards in hand: " + hand[0] + " " + hand[1] + " " + hand[2];
    }

}
