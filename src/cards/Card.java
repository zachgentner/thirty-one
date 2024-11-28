package cards;

public class Card {
    private int suit; //1 = Hearts, 2 = Diamonds, 3 = Spades, 4 = Clubs.
    private char icon; //displays an icon that corresponds with the suit of the card.
    private int value; //1 = A, 2 = 2, 3 = 3... 11 = J, 12 = Q, 13 = K
    private int points; //A(1) is 11 points. 2-10 are face value. J(11), Q(12), K(13) are also 10 points. All must be same suited.

    public Card(int suit, int value) {
        this.suit = suit;
        this.value = value;
        this.points = getPoints();
    }

    public String getSuit() {
        if (suit == 1) {
            return "hearts";
        }
        if (suit == 2) {
            return "diamonds";
        }
        if (suit == 3) {
            return "spades";
        }
        if (suit == 4) {
            return "clubs";
        }


        return null;
    } //Returns the suit of the card, where 1 = H, 2 = D, 3 = S, and 4 = C.

    private String getValue() {
        if (value >= 2 && value <= 10) {
            return Integer.toString(value);
        } else if (value == 11) {
            return "J";
        } else if (value == 12) {
            return "Q";
        } else if (value == 13) {
            return "K";
        } else if (value == 1) {
            return "A";
        }

        return null;
    } //Returns the face value of the card. A - K.

    public int getPoints() {
        if (value == 1) {
            return 11;
        } else if (value >= 11 && value <= 13) {
            return 10;
        }

        return value;
    } //Returns the point value of the card.

    private char getIcon(){
        if(suit == 1){
            icon = '♡';
        }
        if(suit == 2){
            icon = '♢';
        }
        if(suit == 3){
            icon = '♤';
        }
        if(suit == 4){
            icon = '♧';
        }
        return icon;
    }

    public String cardInfo(){
        return this.getValue() + " of " + getSuit() + " is worth " + points + " points.";
    }

    @Override
    public String toString() {
        return this.getIcon() + " " + this.getValue();
    }

}
