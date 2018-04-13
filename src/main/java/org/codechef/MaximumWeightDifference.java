package org.codechef;

import java.util.Arrays;
import java.util.Scanner;

 class MaximumWeightDifference {

    public static void main(String args[]){
        Scanner scanner = new Scanner(System.in);

        int T = scanner.nextInt();

        while (T!=0){
            int N = scanner.nextInt();
            int K = scanner.nextInt();

            int arr[] = new int[N];

            for(int i=0;i<N;i++){
                arr[i] = scanner.nextInt();
            }

            Arrays.sort(arr);
            int sum1 = 0;
            for(int i=0;i<K;i++){
                sum1+=arr[i];
            }

            int sum2 =0;
            for(int i=K;i<N;i++){
                sum2+=arr[i];
            }

            System.out.println(sum2-sum1>0?sum2-sum1: sum1-sum2);
        }
    }
}
