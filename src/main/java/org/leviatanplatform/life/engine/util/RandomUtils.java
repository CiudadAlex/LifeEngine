package org.leviatanplatform.life.engine.util;

import java.util.Random;

public class RandomUtils {

    public static int getInt(int bound) {

        Random rand = new Random();
        return rand.nextInt(bound);
    }
}
