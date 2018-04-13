package org.hackerrank.solutions;


import static org.hackerrank.solutions.AddTwoLargeLinkedLists.*;

public class DetectAndRemoveCycleInALinkedList {

    static LNode loopExists(LNode node) {

        LNode slow = node;
        LNode fast = node;

        while (slow != null && fast != null && fast.next != null) {

            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return slow;
            }


        }

        return null;
    }

    static void removeLoop(LNode node, LNode loopNode) {

        LNode t = null;
        LNode linkNode = null;

        boolean found = false;
        while (node != null) {
            t = node;
            LNode s = loopNode;
            s = s.next;
            while (s != loopNode) {
                s = s.next;
                if (s == t) {
                    found = true;
                    break;
                }
            }
            if (found == true) {
                linkNode = s;
                break;
            }
            node = node.next;
        }

        LNode s = linkNode;

        int count = 0;
        linkNode = linkNode.next;
        count++;
        while (linkNode != s) {
            count++;
            linkNode = linkNode.next;
        }

        count--;

        while (count != 0) {
            s = s.next;
            count--;
        }
        s.next = null;


    }

    public static void main(String args[]) {
        LNode startNode = createLinkedList(1, 2, 3, 4, 5, 6, 7, 8);

        startNode.next.next.next.next.next.next.next.next = startNode.next.next;

        LNode loopNode = null;
        if ((loopNode = loopExists(startNode)) != null) {
            System.out.println("LOOP EXISTS");
            removeLoop(startNode, loopNode);
            printList(startNode);
        }
    }
}
