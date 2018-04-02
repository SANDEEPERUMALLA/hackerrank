package org.hackerrank.solutions;

import java.util.Scanner;

public class LargestPermutation {

    static int[] largestPermutation(int k, int[] arr) {

        int pos[] = new int[arr.length];


        for (int i = 0; i < arr.length; i++) {
            pos[arr[i]-1] = i;
        }



        int n = arr.length;
        int swaps =0;
        for(int i=0;i< arr.length;i++){

            if(arr[i] != n-i) {

                int temp = pos[n-i-1];

                pos[arr[i]-1] = temp;
                pos[n-i-1] = i;

                int t = arr[temp];
                arr[temp] = arr[i];
                arr[i] = t;
                swaps++;
                if(swaps ==k){
                    break;
                }

            }
        }

        return arr;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int[] arr = new int[n];
        for (int arr_i = 0; arr_i < n; arr_i++) {
            arr[arr_i] = in.nextInt();
        }
        int[] result = largestPermutation(k, arr);
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + (i != result.length - 1 ? " " : ""));
        }
        System.out.println("");


        in.close();
    }
}
