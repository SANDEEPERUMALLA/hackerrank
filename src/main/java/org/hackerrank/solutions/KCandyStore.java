package org.hackerrank.solutions;

import java.math.BigInteger;
import java.util.Scanner;

public class KCandyStore {

    static int solve(int n, int k) {

        return C(n + k - 1, n - 1);

    }

    static int C(int n, int r) {

        if(n-r < r){
            return  C(n,n-r);
        }
        BigInteger res = BigInteger.ONE;

        for (int i = 1; i <=r; i++) {

            res = res.multiply(BigInteger.valueOf(n-i+1).divide(BigInteger.valueOf(i)));
        }

        return res.intValue();

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String args[]){

        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            int n = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int k = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int result = solve(n, k);
            System.out.println(result);
        }


        scanner.close();

    }

}
