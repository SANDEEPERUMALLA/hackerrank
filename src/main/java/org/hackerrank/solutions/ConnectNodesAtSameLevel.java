package org.hackerrank.solutions;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


class Node1 {
    Node1 left;
    Node1 right;
    Node1 sideLink;
    public int data;

    Node1(int data) {
        this.data = data;
    }
}

public class ConnectNodesAtSameLevel {

    static Node1 connectNode1sAtSameLevel(Node1 root) {

        Queue<Node1> q = new LinkedList<>();
        q.add(root);
        int size = q.size();

        List<Node1> l = new ArrayList<>();
        while (!q.isEmpty()) {

            while (size != 0) {
                Node1 n = q.remove();
                l.add(n);
                System.out.print(n.data + " ");
                size--;
                if (n.left != null) {
                    q.add(n.left);
                }
                if (n.right != null) {
                    q.add(n.right);
                }
            }

            for (int i = 0; i < l.size() - 1; i++) {
                l.get(i).sideLink = l.get(i + 1);
            }

            System.out.println();

            size = q.size();
        }


        return root;
    }

    public static void main(String args[]) {
        Node1 n1 = new Node1(1);
        Node1 n2 = new Node1(2);
        Node1 n3 = new Node1(3);
        Node1 n4 = new Node1(4);
        Node1 n5 = new Node1(5);
        Node1 n6 = new Node1(6);
        Node1 n7 = new Node1(7);
        Node1 n8 = new Node1(8);
        Node1 n9 = new Node1(9);

        n1.left = n2;
        n1.right = n3;

        n2.left = n4;
        n2.right = n5;

        n3.left = n6;
        n3.right = n7;

        n4.left = n8;
        n4.right = n9;

        System.out.println(connectNode1sAtSameLevel(n1));
    }
}
