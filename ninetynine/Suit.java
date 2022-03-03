package ninetynine;

import java.security.SecureRandom;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public enum Suit {
    CLUBS, DIAMONDS, HEARTS, SPADES;

    public String toString() {
        return name().charAt(0) + name().substring(1).toLowerCase();
    }

    // Cache the result of values() and use one SecureRandom instance
    private static final List<Suit> SUITS = Collections.unmodifiableList(Arrays.asList(values()));
    private static final int SIZE = SUITS.size();
    private static final SecureRandom RANDOM = new SecureRandom();

    public static Suit getRandomSuit() {
        return SUITS.get(RANDOM.nextInt(SIZE));
    }
}
