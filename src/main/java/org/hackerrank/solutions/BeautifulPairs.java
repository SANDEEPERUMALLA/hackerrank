package org.hackerrank.solutions;

import java.io.*;
import java.time.Instant;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class BeautifulPairs {


    static int beautifulPairs(int[] A, int[] B) {


    Map<Integer, Integer> countMap = new HashMap<>();

    for (int n : A) {

        Integer c = countMap.get(n);
        countMap.put(n, c == null ? 1 : c + 1);
    }

    int pairs = 0;
    for (int n : B) {
        Integer c = countMap.get(n);
        if (c != null) {
            pairs++;
            countMap.put(n, c--);
        }
    }

    return pairs+1;
}

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] A = new int[n];
        for(int A_i = 0; A_i < n; A_i++){
            A[A_i] = in.nextInt();
        }
        int[] B = new int[n];
        for(int B_i = 0; B_i < n; B_i++){
            B[B_i] = in.nextInt();
        }
        int result = beautifulPairs(A, B);
        System.out.println(result);
        in.close();
    }
}
