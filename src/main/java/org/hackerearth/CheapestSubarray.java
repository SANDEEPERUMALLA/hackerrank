package org.hackerearth;

import java.util.Scanner;

public class CheapestSubarray {

    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);

        int T = scanner.nextInt();


        while (T != 0) {

            int N = scanner.nextInt();

            int arr[] = new int[N];

            for (int i = 0; i < N; i++) {
                arr[i] = scanner.nextInt();
            }


            int minLeft[] = new int[N];

            int min = arr[0];
            minLeft[0] = -1;


            for (int i = 1; i < arr.length; i++) {


                if (arr[i] < min) {
                    min = arr[i];
                }
                minLeft[i] = min;
            }


            int maxLeft[] = new int[N];

            int max = arr[0];
            maxLeft[0] = -1;


            for (int i = 1; i < arr.length; i++) {


                if (arr[i] > min) {
                    max = arr[i];
                }

                maxLeft[i] = max;
            }

            int minCost = Integer.MAX_VALUE;

            for (int i = 1; i < arr.length; i++) {


                int minimum = minLeft[i];
                int maximum = maxLeft[i];

                if ((maximum + minimum) < minCost) {
                    minCost = minimum + maximum;
                }

            }


            System.out.println(minCost);


            T--;
        }


    }
}
