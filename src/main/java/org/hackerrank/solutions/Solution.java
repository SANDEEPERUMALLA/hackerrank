package org.hackerrank.solutions;

import javax.xml.soap.SOAPEnvelope;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class Solution {

    static class SinglyLinkedListNode {

        SinglyLinkedListNode(int data){
            this.data= data;
        }
        int data;
        SinglyLinkedListNode next;
    }

    static SinglyLinkedListNode sort(int k, SinglyLinkedListNode list) {

        SinglyLinkedListNode node = list;
        while (node != null) {

            int i = 1;

            SinglyLinkedListNode t = node;
            List<Integer> l = new ArrayList<Integer>();
            while (i <= k) {
                l.add(t.data);
                t=t.next;
                i++;
                if (t.next == null) {
                    break;
                }
            }

            i--;

            if(i==0){
                break;
            }
          // l.sort((a,b)-> a.compareTo(b));

            int j=0;

            while(j<i){
                node.data = l.get(j);
                j++;
                node = node.next;
            }


        }

        return list;
    }


    static long calculateCombinations(int n, int k) {


        BigDecimal num = BigDecimal.ONE;


        for (int i = 1; i <= k; i++) {
            num = num.multiply(BigDecimal.valueOf(n));
            n--;
        }

        BigDecimal den = BigDecimal.ONE;

        for (int i = 1; i <= k; i++) {
            den = den.multiply(BigDecimal.valueOf(i));
        }

        return num.divide(den).longValue();
    }

    public static void main(String args[]) {
//
//        SinglyLinkedListNode node1 = new SinglyLinkedListNode(3);
//        SinglyLinkedListNode node2 = new SinglyLinkedListNode(4);
//        SinglyLinkedListNode node3 = new SinglyLinkedListNode(2);
//        SinglyLinkedListNode node4 = new SinglyLinkedListNode(7);
//        SinglyLinkedListNode node5 = new SinglyLinkedListNode(4);
//        SinglyLinkedListNode node6 = new SinglyLinkedListNode(2);
//
//        SinglyLinkedListNode node7 = new SinglyLinkedListNode(10);
//
//        node1.next = node2;
//        node2.next = node3;
//        node3.next = node4;
//        node4.next = node5;
//        node5.next = node6;
//        node6.next = null;
//
//        sort(3,node1);


        System.out.println(calculateCombinations(10,3));
        System.out.println(calculateCombinations(Integer.MAX_VALUE,5));
        long l =10;

        l = l*Integer.MAX_VALUE;
        System.out.println(Integer.MAX_VALUE);
        System.out.println(l);


    }
}
