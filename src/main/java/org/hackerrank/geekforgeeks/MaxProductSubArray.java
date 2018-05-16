package org.hackerrank.geekforgeeks;

public class MaxProductSubArray {


    static public int findMaxSubArrayProduct(int arr[]) {


        int maxNegativeNum = Integer.MAX_VALUE;
        int negativeCount = 0;
        int zeroCount = 0;
        int maxProduct = 1;
        for (int i = 0; i < arr.length; i++) {

            if (arr[i] == 0) {
                zeroCount++;
                continue;
            }

            if (arr[i] < 0) {
                negativeCount++;

                if (arr[i] < maxNegativeNum) {
                    maxNegativeNum = arr[i];
                }

            }
            if (arr[i] != 0) {
                maxProduct *= arr[i];
            }

        }

        if (zeroCount == arr.length) {
            return 0;
        }
        if (negativeCount % 2 == 1) {

            if (negativeCount == 1 && zeroCount == arr.length - 1) {
                return 0;
            }
            maxProduct = maxProduct / maxNegativeNum;
        }


        return maxProduct;
    }

    public static void main(String args[]) {

        System.out.println(findMaxSubArrayProduct(new int[]{1, 3, 4, 5, 5, 5, 5}));
        System.out.println(findMaxSubArrayProduct(new int[]{-1, 3, 4, -5, 5, -5, -5}));
        System.out.println(findMaxSubArrayProduct(new int[]{-1, 3, 4, -5, 5, 5, -5}));
        System.out.println(findMaxSubArrayProduct(new int[]{0,0,0,0,0,0}));
        System.out.println(findMaxSubArrayProduct(new int[]{0,0,0,0,-9,-1}));
        System.out.println(findMaxSubArrayProduct(new int[]{0,0,0,0,0,-1}));

    }
}
