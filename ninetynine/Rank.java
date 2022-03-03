package ninetynine;

import java.security.SecureRandom;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public enum Rank {
    TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, JACK, QUEEN, KING, ACE;

    public String toString() {
        return name().charAt(0) + name().substring(1).toLowerCase();
    }

    // Cache the result of values() and use one SecureRandom instance
    private static final List<Rank> RANKS = Collections.unmodifiableList(Arrays.asList(values()));
    private static final int SIZE = RANKS.size();
    private static final SecureRandom RANDOM = new SecureRandom();

    public static Rank getRandomRank() {
        return RANKS.get(RANDOM.nextInt(SIZE));
    }

    public int getValue() {
        return ordinal() + 2;
    }
}
