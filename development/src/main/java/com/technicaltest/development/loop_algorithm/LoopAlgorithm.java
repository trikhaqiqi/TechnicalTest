package com.technicaltest.development.loop_algorithm;

public class LoopAlgorithm {
    public static void main(String[] args) {
        int n = 5;

        for (int i = 1; i <= n; i++) {
            System.out.println(String.valueOf(i).repeat(i));
        }
    }
}
