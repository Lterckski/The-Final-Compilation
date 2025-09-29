package utils;

import java.util.Random;

public class RandomUtil {
    private static final Random chance = new Random();

    public static Random get(){
        return chance;
    }

    public static int range(int min, int max) {
        return chance.nextInt((max - min) + 1) + min;
    }

    public static double range(double min, double max){
        return min + (max - min) * chance.nextDouble();
    }

}
