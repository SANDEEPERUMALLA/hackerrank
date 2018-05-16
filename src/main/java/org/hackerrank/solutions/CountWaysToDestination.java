package org.hackerrank.solutions;

public class CountWaysToDestination {


    static boolean isSafe(int i, int j, int m, int n) {

        if (i >= 0 && i < m && j >= 0 && j < n) {
            return true;
        }

        return false;
    }

    static int countWays(int mat[][]) {


        int m = mat.length;
        int n = mat[0].length;

        int count[][] = new int[m][n];


        for (int i = 0; i < m; i++) {
            if (mat[i][0] == 0) {
                break;
            }
            count[i][0] = 1;
        }

        for (int i = 0; i < n; i++) {
            if (mat[0][i] == 0) {
                break;
            }
            count[0][i] = 1;
        }


        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {

                int c = 0;

                if (isSafe(i - 1, j - 1, m, n) && mat[i - 1][j - 1] == 1) {
                    c += count[i - 1][j - 1];

                }

                if (isSafe(i - 1, j, m, n) && mat[i - 1][j] == 1) {
                    c += count[i - 1][j];
                }

                if (isSafe(i, j - 1, m, n) && mat[i][j - 1] == 1) {
                    c += count[i][j - 1];
                }

                count[i][j] = c;


            }
        }


        return count[m - 1][n - 1];
    }


    public static void main(String args[]) {

        int mat[][] = {
                {1, 0, 1, 1},
                {0, 1, 1, 0},
                {1, 1, 1, 1},
                {0, 0, 0, 1}
        };

        System.out.println(countWays(mat));
    }
}
