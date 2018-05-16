package org.hackerrank.solutions;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigInteger;
import java.util.Scanner;

public class FillingJars {

    // Complete the solve function below.
    static int solve(int n, int[][] operations) {


        BigInteger avg = BigInteger.valueOf(0);

        for (int i = 0; i < operations.length; i++) {
            int start = operations[i][0];
            int end = operations[i][1];
            int value = operations[i][2];
            avg = avg.add(BigInteger.valueOf(value).multiply(BigInteger.valueOf(end - start + 1)));

        }


        return (avg.divide(BigInteger.valueOf(n))).intValue();

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("C:\\Users\\sperumal\\Documents\\output.txt"));

        String[] nm = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nm[0]);

        int m = Integer.parseInt(nm[1]);

        int[][] operations = new int[m][3];

        for (int operationsRowItr = 0; operationsRowItr < m; operationsRowItr++) {
            String[] operationsRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int operationsColumnItr = 0; operationsColumnItr < 3; operationsColumnItr++) {
                int operationsItem = Integer.parseInt(operationsRowItems[operationsColumnItr]);
                operations[operationsRowItr][operationsColumnItr] = operationsItem;
            }
        }

        int result = solve(n, operations);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
