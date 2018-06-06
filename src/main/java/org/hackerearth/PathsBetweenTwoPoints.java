package org.hackerearth;

public class PathsBetweenTwoPoints {

    static int noOfWaysBetweenPoints(int x, int y) {

        int ways[] = new int[y - x];

        ways[0] = 0;
        ways[1] = 1;

        for (int i = 2; i < ways.length; i++) {

            int w = 0;
            for (int j = 0; j < i; j++) {
                w += ways[j];
            }

            ways[i] = 1 + w;
        }

        return ways[ways.length - 1];


    }

    public static void main(String args[]) {
        int noOfPoints = 10;

        System.out.println(noOfWaysBetweenPoints(1, 10));


    }
}
