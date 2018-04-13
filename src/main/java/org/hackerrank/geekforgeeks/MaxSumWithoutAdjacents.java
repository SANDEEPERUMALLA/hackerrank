package org.hackerrank.geekforgeeks;

import java.util.Scanner;

public class MaxSumWithoutAdjacents {

    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);

        int T = scanner.nextInt();

        while (T != 0) {

            int N = scanner.nextInt();

            int arr[] = new int[N];

            for (int i = 0; i < N; i++) {
                arr[i] = scanner.nextInt();
            }


            int evenSum = 0, oddSum = 0;
            for (int i = 0; i < N; i = i + 2) {

                evenSum += arr[i];
            }

            for (int i = 1; i < N; i = i + 2) {

                oddSum += arr[i];
            }

            System.out.println(evenSum > oddSum ? evenSum : oddSum);
            T--;
        }
    }
}
