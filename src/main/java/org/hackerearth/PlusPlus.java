package org.hackerearth;

import sun.java2d.pipe.ParallelogramPipe;

import java.nio.channels.Pipe;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Point {
    public int x;
    public int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

}


    public class PlusPlus {

    static List<Point> pointList = new ArrayList<Point>();

    static int maxProduct = 1;

    static double findDistance(Point p1, Point p2) {

        double X = Math.pow(p1.x - p2.x, 2);
        double Y = Math.pow(p1.y - p2.y, 2);

        return Math.sqrt(X + Y);


    }

    static boolean doPlusesOverlap(Point p1, Point p2) {


        if (p1.x == p2.x && Math.abs(p1.y - p2.y) < 3) {
            return true;
        } else if (p1.y == p2.y && Math.abs(p1.x - p2.x) < 3) {
            return true;
        } else if (findDistance(p1, p2) < 3.0) {
            return true;
        }

        return false;
    }

    static void findProduct(Point p1, Point p2, int arr[][]) {
        int product = 0;

        int d1[] = {1, -1, 0, 0, 0};
        int d2[] = {0, 0, -1, 1, 0};

        for (int i = 0; i < d1.length; i++) {
            product += (arr[p1.x + d1[i]][p1.y + d2[i]] * arr[p2.x + d1[i]][p2.y + d2[i]]);
        }

        if (product > maxProduct) {
            maxProduct = product;
        }

    }


    public static int findMaxPlusProduct(int arr[][]) {


        int m = arr.length;
        int n = arr[0].length;


        for (int i = 1; i <m - 1; i++) {
            for (int j = 1; j <n - 1; j++) {
                pointList.add(new Point(i, j));
            }
        }


        for (int i = 0; i < pointList.size(); i++) {
            for (int j = 0; j < pointList.size(); j++) {
                if (i != j) {

                    boolean overlap = doPlusesOverlap(pointList.get(i), pointList.get(j));

                    if (!overlap) {
                        findProduct(pointList.get(i), pointList.get(j), arr);
                    }

                }

            }
        }

        return maxProduct;

    }

    public static void main(String args[]) {

        Scanner scanner = new Scanner(System.in);

        int m = scanner.nextInt();
        int n = scanner.nextInt();
        int arr[][] = new int[m][n];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                arr[i][j] = scanner.nextInt();
            }
        }

        System.out.println(findMaxPlusProduct(arr));


    }
}
