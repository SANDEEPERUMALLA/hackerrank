package org.hackerrank.geekforgeeks;

public class PrefixSumOfMatrix {

    static int[][] prefixSumMatrix(int mat[][]) {


        int m = mat.length;
        int n = mat[0].length;
        int prefixMat[][] = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(mat[i][j] + " ");
            }
            System.out.println();
        }

        prefixMat[0][0] = mat[0][0];


        for (int i = 1; i < n; i++) {
            prefixMat[0][i] = prefixMat[0][i - 1] + mat[0][i];
        }

        for (int i = 1; i < m; i++) {
            prefixMat[i][0] = prefixMat[i - 1][0] + mat[i][0];
        }


        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                prefixMat[i][j] = prefixMat[i - 1][j] + prefixMat[i][j - 1] + mat[i][j] - prefixMat[i - 1][j - 1];
            }
        }


        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(prefixMat[i][j] + " ");
            }
            System.out.println();
        }


        return prefixMat;
    }

    public static void main(String args[]) {

        int mat[][] = {{1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1}};

        prefixSumMatrix(mat);

    }
}
