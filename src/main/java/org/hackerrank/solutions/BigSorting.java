package org.hackerrank.solutions;

import java.util.Arrays;
import java.util.Scanner;

public class BigSorting {

    static String[] bigSorting(String[] arr) {


        Arrays.sort(arr, (s1,s2)->{
            if(s1.length() > s2.length()){
                return 1;
            }
            else if(s1.length() < s2.length()){
                return -1;
            }
            else {
                return s1.compareTo(s2);
            }

        });

        return arr;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        String[] arr = new String[n];
        for(int arr_i = 0; arr_i < n; arr_i++){
            arr[arr_i] = in.next();
        }
        String[] result = bigSorting(arr);
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + (i != result.length - 1 ? "\n" : ""));
        }
        System.out.println("");


        in.close();
    }
}
