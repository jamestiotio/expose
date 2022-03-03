package ninetynine;

public class Player {
    private final int id;
    public Hand hand = new Hand();

    public Player(int id) {
        this.id = id;
    }

    public int getPlayerID() {
        return this.id;
    }

    public void printHand() {
        StringBuilder sb = new StringBuilder();
        if (this.id == 0) {
            sb.append("You have " + hand.cards.size() + " cards:\n");
        } else {
            sb.append("CPU Player " + id + " has " + hand.cards.size() + " cards:\n");
        }
        sb.append(hand.getPrintableHand());
        System.out.println(sb.toString());
    }
}
