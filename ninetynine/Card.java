package ninetynine;

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
