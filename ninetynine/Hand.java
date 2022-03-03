package ninetynine;

import java.util.ArrayList;
import java.security.SecureRandom;

public class Hand {
    public ArrayList<Card> cards = new ArrayList<Card>();
    public SecureRandom rng = new SecureRandom();

    public void initialize(int handSize) {
        // Add cards of random suit and rank to the hand, where number of cards is handSize
        for (int i = 0; i < handSize; i++) {
            cards.add(new Card());
        }
    }

    public void addSpecificCard(Card card) {
        cards.add(card);
    }

    public void addRandomCard() {
        cards.add(new Card());
    }

    public Card selectSpecificCard(int id) {
        Card selectedCard = cards.get(id);
        cards.remove(id);
        this.addRandomCard();
        return selectedCard;
    }

    public Card selectRandomCard() {
        int randomIndex = rng.nextInt(cards.size());
        Card randomCard = cards.get(randomIndex);
        cards.remove(randomIndex);
        this.addRandomCard();
        return randomCard;
    }

    public String getPrintableHand() {
        StringBuilder sb = new StringBuilder();
        for (Card card : cards) {
            sb.append(card.toString() + "\n");
        }
        return sb.toString();
    }
}
