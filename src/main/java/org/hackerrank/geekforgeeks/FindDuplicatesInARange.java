package org.hackerrank.geekforgeeks;

public class FindDuplicatesInARange {


    static int noOfDuplicates(int arr[]) {

        int bitNumber = 0;

        int dubCount = 0;

        for (int i = 0; i < arr.length; i++) {

            if ((1 << arr[i] & bitNumber) != 0) {
                dubCount++;
                continue;
            }

            bitNumber |= (1 << arr[i]);

        }

        return dubCount;
    }

    public static void main(String args[]) {

        int arr[] = {1, 3, 4, 4, 4, 6, 7, 7, 7, 7, 8, 8, 9, 9, 10};

        System.out.println(noOfDuplicates(arr));

    }

}
