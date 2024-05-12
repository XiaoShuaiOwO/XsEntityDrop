package com.xssssss.xsentitydrop.Utils;

import java.util.Random;

public class Probability {
    public static boolean checkProbability(double probability) {
        Random rand = new Random();
        double randomValue = rand.nextDouble();
        return randomValue <= probability;
    }
}
