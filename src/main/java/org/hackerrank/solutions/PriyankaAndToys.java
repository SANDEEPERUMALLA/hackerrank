package org.hackerrank.solutions;

import java.util.*;

public class PriyankaAndToys {

    static int toys(int[] w) {

        Arrays.sort(w);

        int containers = 1, prev = w[0];
        for (int i = 1; i < w.length; i++) {
            if(w[i] -prev >4){
                containers++;
                prev = w[i];
            }

        }

        return containers;

    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] w = new int[n];
        for (int w_i = 0; w_i < n; w_i++) {
            w[w_i] = in.nextInt();
        }
        int result = toys(w);
        System.out.println(result);
        in.close();
    }


}
