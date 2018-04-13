package org.hackerrank.solutions;

public class ReverseAListInGroupsOfK {

    static LNode reverseListInGroupsOfK(LNode node, int k) {


        LNode curr = node;
        LNode prev = null;
        LNode next = null;

        for (int i = 0; curr != null && i < k; i++) {

            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        node.next = curr!=null ? reverseListInGroupsOfK(curr, k) : null;

        return prev;

    }


    public static void main(String args[]) {
        LNode startNode = AddTwoLargeLinkedLists.createLinkedList(1, 3, 4, 5, 6, 7, 8, 8, 9, 0);

        AddTwoLargeLinkedLists.printList(startNode);

        startNode = reverseListInGroupsOfK(startNode, 4);
        AddTwoLargeLinkedLists.printList(startNode);


    }
}
