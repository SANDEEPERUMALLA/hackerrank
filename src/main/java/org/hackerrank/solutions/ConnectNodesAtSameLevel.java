package org.hackerrank.solutions;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;




public class ConnectNodesAtSameLevel {

   static class Node {
        Node left;
        Node right;
        Node nextRight;
        public int data;

        Node(int data) {
            this.data = data;
        }
    }

    static Node connectNode1sAtSameLevel(Node root) {

        Queue<Node> q = new LinkedList<>();
        q.add(root);
        int size = q.size();

        List<Node> l = new LinkedList<>();
        while (!q.isEmpty()) {

            while (size != 0) {
                Node n = q.remove();
                l.add(n);
                size--;
                if (n.left != null) {
                    q.add(n.left);
                }
                if (n.right != null) {
                    q.add(n.right);
                }
            }

            for (int i = 0; i < l.size() - 1; i++) {
                l.get(i).nextRight = l.get(i + 1);
            }

            l.get(l.size()-1).nextRight = null;


            size = q.size();
        }


        return root;
    }

    public static void main(String args[]) {
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        Node n5 = new Node(5);
        Node n6 = new Node(6);
        Node n7 = new Node(7);
        Node n8 = new Node(8);
        Node n9 = new Node(9);

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
