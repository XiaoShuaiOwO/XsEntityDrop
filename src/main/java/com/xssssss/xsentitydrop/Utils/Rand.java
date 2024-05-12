package com.xssssss.xsentitydrop.Utils;

import java.util.Random;

public class Rand {
    public static boolean checkProbability(double probability) {
        Random rand = new Random();
        double randomValue = rand.nextDouble();
        return randomValue <= probability;
    }
    public static int randInt(int min, int max) {
        Random rand = new Random();
        return rand.nextInt((max - min) + 1) + min;
    }
}
