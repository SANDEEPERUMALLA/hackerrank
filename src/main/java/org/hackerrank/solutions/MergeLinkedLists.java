package org.hackerrank.solutions;

public class MergeLinkedLists {

    static class Node {
        Node next;

        int data;

        Node(int data) {

            this.data = data;
            next = null;
        }
    }

    static Node createList(int... arr) {


        if (arr.length == 0) {
            return null;
        }

        Node start = new Node(arr[0]);
        Node node = start;

        for (int i = 1; i < arr.length; i++) {

            node.next = new Node(arr[i]);
            node = node.next;

        }

        return start;


    }

    static Node mergeLists(Node node1, Node node2) {

        Node m = null;

        Node start = null;

        if (node1.data < node2.data) {
            m = new Node(node1.data);
            start = m;
            node1 = node1.next;
        } else if (node1.data > node2.data) {
            m = new Node(node2.data);
            start = m;
            node2 = node2.next;
        } else {
            m = new Node(node1.data);
            start = m;
            m.next = new Node(node2.data);
            m = m.next;

            node1 = node1.next;
            node2 = node2.next;
        }


        while (node1.next != null && node2.next != null) {

            if (node1.data < node2.data) {
                m.next = new Node(node1.data);
                m = m.next;
                node1 = node1.next;

            } else if (node1.data > node2.data) {

                m.next = new Node(node2.data);
                m = m.next;

                node2 = node2.next;
            } else {

                m.next = new Node(node1.data);
                m = m.next;
                m.next = new Node(node2.data);
                m = m.next;

                node1 = node1.next;
                node2 = node2.next;

            }
        }


        while (node1.next != null) {
            m.next = new Node(node1.data);
            m = m.next;

            node1 = node1.next;
        }

        while (node2.next != null) {
            m.next = new Node(node2.data);
            m = m.next;

            node2 = node2.next;
        }


        return start;
    }


    static Node mergeListsOptimized(Node l1, Node l2) {


        Node start = null;
        Node temp = null;
        if (l1.data < l2.data) {
            temp = l1;
            l1 = l2;
            l2 = temp;
        }

        start = l2;

        Node cur = l2;
        Node prev = null;

        while (l1 != null) {

            while (cur.next != null) {


                if (cur.data <= l1.data && cur.next != null && cur.next.data >= l1.data) {

                    temp = cur.next;

                    Node t = l1;
                    l1 = l1.next;
                    cur.next = t;
                    t.next = temp;
                    cur = t;
                    break;

                }

                prev = cur;
                cur = cur.next;

            }


            if (cur.next == null) {

                while (l1 != null) {
                    prev.next = new Node(l1.data);
                    prev = prev.next;
                    l1 = l1.next;
                }

                break;
            }


        }

        return start;


    }

    static void printList(Node n) {

        while (n != null) {
            System.out.print(n.data + "--->");
            n = n.next;
        }
        System.out.println();
    }


    public static void main(String args[]) {

        Node l1 = createList(1, 4, 5, 6, 10, 12);
        Node l2 = createList(0, 3, 3, 4, 4, 6, 7, 10);

        printList(l1);
        printList(l2);

        Node r = mergeLists(l1, l2);

        Node rE = mergeListsOptimized(l1, l2);

        printList(r);

        printList(rE);


    }
}
