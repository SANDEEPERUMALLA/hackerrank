package org.hackerrank.solutions;

import java.util.Arrays;
import java.util.Scanner;

public class MaxMin {
    static int angryChildren(int k, int[] arr) {


        Arrays.sort(arr);

        int res = Integer.MAX_VALUE;
        for (int i = 0;i+k-1<arr.length ; i++) {

            if (arr[i + k - 1] - arr[i] < res) {
                res = arr[i + k - 1] - arr[i];
            }
        }


        return res;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int[] arr = new int[n];
        for (int arr_i = 0; arr_i < n; arr_i++) {
            arr[arr_i] = in.nextInt();
        }
        int result = angryChildren(k, arr);
        System.out.println(result);
        in.close();
    }
}
