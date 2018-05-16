package org.hackerrank.solutions;

import java.util.Scanner;

public class Equal {
    static int equal(int[] arr) {


        int noOfOperations = 0;


        while (true) {

            int max = Integer.MIN_VALUE;
            int min = Integer.MAX_VALUE;
            int maxIndex = -1;
            for (int i = 0; i < arr.length; i++) {

                if (max < arr[i]) {
                    max = arr[i];
                    maxIndex = i;
                }

                if (min > arr[i]) {
                    min = arr[i];
                }
            }

            int diff = max - min;
            if (diff == 0) {
                break;
            }

            noOfOperations++;
            for (int i = 0; i < arr.length; i++) {

                if (i == maxIndex) {
                    continue;
                }
                arr[i] += diff;


            }
        }


        return noOfOperations;

    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int a0 = 0; a0 < t; a0++) {
            int n = in.nextInt();
            int[] arr = new int[n];
            for (int arr_i = 0; arr_i < n; arr_i++) {
                arr[arr_i] = in.nextInt();
            }
            int result = equal(arr);
            System.out.println(result);
        }
        in.close();
    }
}
