package ninetynine;

public class Player {
    private final int id;
    public Hand hand = new Hand();

    public Player(int id) {
        this.id = id;
    }

    public int getPlayerIndex() {
        return this.id;
    }

    public void printHand() {
        StringBuilder sb = new StringBuilder();
        sb.append("Player " + id + " has " + hand.cards.size() + " cards:\n");
        sb.append(hand.getPrintableHand());
        System.out.println(sb.toString());
    }
}
