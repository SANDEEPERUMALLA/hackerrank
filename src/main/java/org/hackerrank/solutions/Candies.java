package org.hackerrank.solutions;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Candies {


    static long candies(int n, int[] rating) {

        int count[] = new int[n];

        for (int i = 0; i < n; i++) {
            count[i] = 1;
        }

        for (int i = 1; i < n; i++) {
            if (rating[i] > rating[i - 1]) {

                count[i] = count[i - 1] + 1;
            }
        }

        for(int i=n-2;i>=0;i--){
            if(rating[i] > rating[i+1] && count[i] <= count[i+1]){
                count[i] = count[i+1]+1;
            }
        }

        long result = 0;

        for(int c : count){
           // System.out.println(c);
            result = result + c;
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];
        for (int arr_i = 0; arr_i < n; arr_i++) {
            arr[arr_i] = in.nextInt();
        }
        long result = candies(n, arr);
        System.out.println(result);
        in.close();
    }
}
