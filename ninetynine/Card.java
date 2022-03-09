package ninetynine;

// TODO: Implement the Card class
// The Card class should have a Rank attribute and a Suit attribute
// The class should have a constructor, which sets the rank and the suit of the card randomly
// Hint: To get a random rank, you can call: Rank.getRandomRank()
// To get a random suit, you can call: Suit.getRandomSuit()
// This class contains 2 methods: toString() and getValue()
// toString() returns a String representation of the card, that consists of the rank and the suit
// (e.g., "Seven of Diamonds")
// getValue() returns the value of the card (e.g., 7 for a "Seven of Diamonds")
// Hint: To get the value of a rank, you can call: rank.getValue()
public class Card {
    public Rank rank;
    public Suit suit;

    public Card(Rank rank, Suit suit) {
        this.rank = rank;
        this.suit = suit;
    }

    public Card() {
        this(Rank.getRandomRank(), Suit.getRandomSuit());
    }

    public String toString() {
        return rank + " of " + suit;
    }

    public int getValue() {
        return this.rank.getValue();
    }
}
