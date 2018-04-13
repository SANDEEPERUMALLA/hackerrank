package org.hackerrank.solutions;


import java.util.Arrays;

class LNode {
    LNode next;
    int data;

    LNode(int data) {
        this.data = data;
    }
}

public class AddTwoLargeLinkedLists {

    static LNode createLinkedList(Integer... nums) {


        if (nums.length == 0) {
            return null;
        }


        LNode node = new LNode(nums[0]);
        LNode start = node;

        for (int i = 1; i < nums.length; i++) {
            node.next = new LNode(nums[i]);
            node = node.next;
        }

        return start;

    }

    static LNode reverseList(LNode node) {
        LNode prev = null;
        LNode curr = node;
        LNode next = null;

        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }

    static LNode addTwoLinkedLists(LNode node1, LNode node2) {

        node1 = reverseList(node1);
        node2 = reverseList(node2);

        int carry = 0;


        StringBuilder sb = new StringBuilder();
        boolean done = false;
        while (node1 != null && node2 != null) {

            int sum = node1.data + node2.data + carry;

            node1 = node1.next;
            node2 = node2.next;

            if (node1 == null && node2 == null) {
                sb.append(sum);
                done = true;
                break;
            }
            sb.append(sum % 10);
            carry = sum / 10;
        }

        if (!done) {
            node1 = node1 == null ? node2 : node1;

            while (node1 != null) {
                int sum = node1.data + carry;

                node1 = node1.next;
                if (node1 == null) {
                    sb.append(sum);
                    break;
                }
                sb.append(sum % 10);
                carry = sum / 10;
            }

        }


        char[] chars = sb.reverse().toString().toCharArray();

        Integer nums[] = new Integer[chars.length];


        for (int i = 0; i < chars.length; i++) {
            nums[i] = chars[i] - '0';
        }

        return createLinkedList(nums);

    }


    static void printList(LNode node) {

        while (node != null) {
            System.out.print(node.data + "--->");
            node = node.next;
        }
        System.out.print("NULL");

        System.out.println();
    }


    public static void main(String args[]) {

        LNode node1 = createLinkedList(1, 2, 3);
        LNode node2 = createLinkedList(2, 3, 4, 5, 6, 7, 7, 9);

        LNode res = addTwoLinkedLists(node1, node2);
        printList(res);

        System.out.println(123 + 23456779);

    }
}
