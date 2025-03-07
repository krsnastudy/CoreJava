package com.prac.core.jdk8.gen.practice;

public class RandomBoolean {
    public static void main(String[] args) {
        for(int i=0; i<14; i++){
            System.out.println(getRandomBoolean());
        }
    }

    public static boolean getRandomBoolean() {
        return Math.random() < 0.5;
    }
}
