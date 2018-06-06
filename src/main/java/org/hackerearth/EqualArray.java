package org.hackerearth;

import java.util.Scanner;

public class EqualArray {

    public static void main(String args[]) {

        Scanner scanner = new Scanner(System.in);


        int T = scanner.nextInt();

        while (T != 0) {
            int N = scanner.nextInt();

            int arr[] = new int[N];
            for (int i = 0; i < N; i++) {
                arr[i] = scanner.nextInt();
            }

            int left[] = new int[N];
            int right[] = new int[N];


            int sum = arr[0];
            left[0] = 0;


            for (int i = 1; i < arr.length; i++) {
                left[i] = sum;
                sum += arr[i];

            }

            right[arr.length - 1] = 0;
            sum = arr[arr.length - 1];

            for (int i = arr.length - 2; i >= 0; i--) {
                right[i] = sum;
                sum += arr[i];
            }


            int minAdd = Integer.MAX_VALUE;
            boolean flag = false;

            for (int i = 0; i < arr.length; i++) {

                if (left[i] + arr[i] < right[i]) {
                    if (right[i] - arr[i] - left[i] < minAdd) {
                        minAdd = right[i] - arr[i] - left[i];
                        flag = true;
                    }
                }

                if (right[i] + arr[i] < left[i]) {
                    if (left[i] - arr[i] - right[i] < minAdd) {
                        minAdd = left[i] - arr[i] - right[i];
                        flag = true;
                    }
                }

            }

            if (flag) {
                System.out.println(minAdd);
            } else {
                System.out.println(-1);
            }

            T--;
        }

    }
}
