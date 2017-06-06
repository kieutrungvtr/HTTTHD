package com.example.cowmanager.util;

import java.util.Random;

public class RandomGenerator {
    /**
     * Maximum default of random integer.
     */
    private static final int DEFAULT_RANDOM_MAX = 9999;
    /**
     * Minimum default of random integer.
     */
    private static final int DEFAULT_RANDOM_MIN = 1000;

    /**
     * default constructor.
     */
    private RandomGenerator() {

    }

    /**
     * <p>
     * Get 1 random integer value in [minimum, maximum].
     * </p>
     *
     * @param minimum minimum value
     * @param maximum maximum value
     * @return integer value in [minimum, maximum]
     */
    public static int getIntRand(final int minimum, final int maximum) {
        Random random = new Random();
        return random.nextInt((maximum - minimum) + 1) + maximum;
    }

    /**
     * <p>
     * Get 1 random integer value in [1000, 9999].
     * </p>
     *
     * @return integer value in [minimum, maximum]
     */
    public static int getIntRand() {
        Random random = new Random();
        return random.nextInt((DEFAULT_RANDOM_MAX - DEFAULT_RANDOM_MIN)
                + 1) + DEFAULT_RANDOM_MIN;
    }
}