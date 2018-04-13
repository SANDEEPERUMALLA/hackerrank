package org.hackerrank.solutions;

import java.util.*;

public class JimAndTheOrders {

    static int[] jimOrders(int[][] orders) {

        Map<Integer,TreeSet<Integer>> m = new TreeMap<>();

        for(int i=0;i<orders.length;i++){
            Integer t = orders[i][0] + orders[i][1];
            if(m.containsKey(t)){
                m.get(t).add(i+1);
            }
            else {
                TreeSet<Integer> set = new TreeSet<>();
                set.add(i+1);
                m.put(t,set);
            }

        }

        int index = 0;
        int res[] = new int[orders.length];
        for(Integer t : m.keySet()){

            for(Integer o : m.get(t)){
                res[index] = o;
                index++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[][] orders = new int[n][2];
        for(int orders_i = 0; orders_i < n; orders_i++){
            for(int orders_j = 0; orders_j < 2; orders_j++){
                orders[orders_i][orders_j] = in.nextInt();
            }
        }
        int[] result = jimOrders(orders);
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + (i != result.length - 1 ? " " : ""));
        }
        System.out.println("");


        in.close();
    }
}
