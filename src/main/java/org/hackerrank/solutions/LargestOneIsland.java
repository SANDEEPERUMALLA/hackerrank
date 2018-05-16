package org.hackerrank.solutions;

public class LargestOneIsland {


    static int m;
    static int n;

    static class Counter {
        int count = 0;

        void increment() {
            count++;
        }

        void reset() {
            count = 0;
        }

        int getCount() {
            return count;
        }
    }

    static boolean isSafe(int i, int j, boolean visited[][], int mat[][]) {

        if (i >= 0 && i < m && j >= 0 && j < n && !visited[i][j] && mat[i][j] == 1) {
            return true;
        }

        return false;

    }


    static void DFS(int mat[][], boolean visited[][], int i, int j, Counter c) {


        visited[i][j] = true;

        int row[] = {-1, -1, 0, 0, 1, 1, -1, 1};
        int column[] = {-1, 0, -1, 1, 0, 1, 1, -1};


        for (int k = 0; k < row.length; k++) {

            if (isSafe(i + row[k], j + column[k], visited, mat)) {

                DFS(mat, visited, i + row[k], j + column[k], c);
                c.increment();
            }
        }
    }


    static int findCount(int mat[][], boolean visited[][]) {


        int maxCount = Integer.MIN_VALUE;

        for (int i = 0; i < mat.length; i++) {

            for (int j = 0; j < mat[0].length; j++) {
                if (!visited[i][j] && mat[i][j] == 1) {

                    Counter c = new Counter();
                    c.increment();

                    DFS(mat, visited, i, j, c);

                    int count = c.getCount();

                    if (count > maxCount) {
                        maxCount = count;
                    }

                }
            }
        }
        return maxCount;
    }

    static int largestOneIsLand(int mat[][]) {


        m = mat.length;
        n = mat[0].length;
        boolean visited[][] = new boolean[m][n];

        return findCount(mat, visited);

    }

    public static void main(String args[]) {


        int mat[][] = {
                {1, 1, 0, 0},
                {1, 1, 0, 1},
                {1, 1, 0, 1},
                {1, 1, 0, 0}
        };

        System.out.println(largestOneIsLand(mat));
    }
}
