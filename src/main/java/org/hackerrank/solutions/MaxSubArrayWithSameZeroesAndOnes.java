package org.hackerrank.solutions;

import java.util.HashMap;
import java.util.Map;

public class MaxSubArrayWithSameZeroesAndOnes {

    static void maxSubArrayWithSameZeroesAndOnes(int arr[]) {

        Map<Integer, Integer> m = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {
                arr[i] = -1;
            }
        }


        int sum = 0;
        int maxRange = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];

            if (sum == 0) {
                maxRange = i + 1;
            }

            if (m.containsKey(sum)) {
                int j = m.get(sum);

                if (maxRange < i - j) {
                    maxRange = i - j;
                }
            } else {
                m.put(sum, i);
            }
        }

        System.out.println(maxRange);


    }

    public static void main(String args[]) {

        int arr[] = {1, 0, 1, 0, 1, 0, 1, 1, 0, 0, 0, 1};
        maxSubArrayWithSameZeroesAndOnes(arr);


    }
}
