package org.hackerearth;

import java.util.Scanner;

class Point {
    public int x;
    public int y;
    public Point left;
    public Point right;
    public Point top;
    public Point down;

}


public class PlusPlus {

    Point buildPoint(int arr[][], int x, int y) {


        return
    }

    public static int findMaxPlusProduct(int arr[][]) {


        int m = arr.length;
        int n = arr[0].length;


        for (int i = 1; i < m - 1; i++) {
            for (int j = 1; j < n - 1; j++) {
                if ()
            }
        }

        return 1;

    }

    public static void main(String args[]) {

        Scanner scanner = new Scanner(System.in);

        int m = scanner.nextInt();
        int n = scanner.nextInt();
        int arr[][] = new int[m][n];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; i < arr[0].length; j++) {
                arr[i][j] = scanner.nextInt();
            }
        }


    }
}
