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
            sb.append("You have ").append(hand.cards.size()).append(" cards:\n");
        } else {
            sb.append("CPU Player ").append(this.id).append(" has ").append(hand.cards.size())
                    .append(" cards:\n");
        }
        sb.append(hand.getPrintableHand());
        System.out.println(sb.toString());
    }
}
