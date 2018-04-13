package org.hackerrank.solutions;

import java.util.Arrays;
import java.util.Scanner;

public class MarkAndToys {

    static int maximumToys(int[] prices, int k) {

        Arrays.sort(prices);

        int toys = 0;
        for (int i = 0; i < prices.length; i++) {
            if(k>prices[i]){
                toys++;
                k-=prices[i];
            }

        }
        return toys;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int[] prices = new int[n];
        for (int prices_i = 0; prices_i < n; prices_i++) {
            prices[prices_i] = in.nextInt();
        }
        int result = maximumToys(prices, k);
        System.out.println(result);
        in.close();
    }
}
