package org.hackerearth;


import java.util.*;

public class BobAndSubSet {


    static Set<Integer> uniqueNumbers = new HashSet<>();
    static List<List<Integer>> subSets = new ArrayList<>();

    static void findSubSetsOfSizeOfK(int arr[], int k) {


        int target[] = new int[k];
        findSubSetsOfSizeOfKInternal(arr, target, 0, 0, k);

    }

    static void findSubSetsOfSizeOfKInternal(int arr[], int target[], int arrIndex, int targetIndex, int k) {


        if (targetIndex == k) {
            List<Integer> subset = new ArrayList<>();

            int orResult = target[0];
            subset.add(target[0]);

            for (int i = 1; i < target.length; i++) {
                subset.add(target[i]);
                orResult |= target[i];
            }

            uniqueNumbers.add(orResult);
            subSets.add(subset);
            return;

        }

        if (arrIndex >= arr.length) {
            return;
        }

        target[targetIndex] = arr[arrIndex];
        findSubSetsOfSizeOfKInternal(arr, target, arrIndex + 1, targetIndex + 1, k);

        findSubSetsOfSizeOfKInternal(arr, target, arrIndex + 1, targetIndex, k);

    }

    public static void main(String args[]) {

        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();
        int size = scanner.nextInt();

        int arr[] = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = scanner.nextInt();
        }

        for (int i = 1; i <= size; i++) {
            findSubSetsOfSizeOfK(arr, i);

        }

        System.out.println(uniqueNumbers.size());


    }


}
