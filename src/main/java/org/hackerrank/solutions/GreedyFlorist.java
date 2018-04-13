package org.hackerrank.solutions;

import java.util.*;

public class GreedyFlorist {

    static int getMinimumCost(int n, int k, int[] t){

        Integer[] c = Arrays.stream( t ).boxed().toArray( Integer[]::new );

        Arrays.sort(c,Collections.reverseOrder());

        int index = 0;
        int cost = 0;
        int iteration = 0;
        while(n>0){

            for(int i=0;i<k&&n>0;i++){
                cost += (iteration + 1) * c[index];

                index++;
                n--;
            }
            iteration++;
        }

        return cost;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int[] c = new int[n];
        for(int c_i=0; c_i < n; c_i++){
            c[c_i] = in.nextInt();
        }
        int minimumCost = getMinimumCost(n, k, c);
        System.out.println(minimumCost);
    }
}
