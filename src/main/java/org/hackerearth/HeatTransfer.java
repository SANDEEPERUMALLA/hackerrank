package org.hackerearth;

import java.math.BigInteger;
import java.util.Scanner;

public class HeatTransfer {

    public static void main(String args[]) {

        Double d = Math.pow(10, 9) + 7;

        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int k = scanner.nextInt();
        int x = scanner.nextInt();


        BigInteger mat[][] = new BigInteger[m][n];
        BigInteger arr[][] = new BigInteger[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                mat[i][j] = scanner.nextBigInteger();

            }
        }

        for (int t = 1; t <= x; t++) {

            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    BigInteger temp = mat[i][j];

                    BigInteger sum = BigInteger.ZERO;

                    if (i - 1 >= 0) {
                        sum = sum.add(((mat[i - 1][j]).subtract(temp)));
                    }
                    if (i + 1 <= mat.length - 1) {
                        sum = sum.add(((mat[i + 1][j]).subtract(temp)));
                    }

                    if (j - 1 >= 0) {
                        sum = sum.add(((mat[i][j - 1]).subtract(temp)));
                    }

                    if (j + 1 <= mat[0].length - 1) {
                        sum = sum.add(((mat[i][j + 1]).subtract(temp)));
                    }

                    arr[i][j] = temp.add(sum);

                }
            }

            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {


                    mat[i][j] = arr[i][j];


                }

            }

        }


        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {


                Double mod = (Math.pow(10, 9) + 7d);

                long modlong = mod.longValue();

                if (mat[i][j].compareTo(BigInteger.ZERO) == -1) {

                    mat[i][j] = mat[i][j].mod(BigInteger.valueOf(modlong));
                } else {
                    mat[i][j] = mat[i][j].mod(BigInteger.valueOf(modlong));
                }

                System.out.print(mat[i][j]+" ");

            }
            System.out.println();
        }


    }
}
