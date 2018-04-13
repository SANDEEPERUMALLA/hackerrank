package org.hackerrank.geekforgeeks;

import java.util.*;

class Node {
    private String value;

    public Node(String value) {
        this.value = value;

    }

    Node left;
    Node right;

    String getValue() {
        return this.value;
    }
}


class QItem {
    public Node node;
    public int level;

    public QItem(Node n, int l) {
        this.node = n;
        this.level = l;
    }
}

public class BottomViewOfTree {

    static Map<Integer, String> levelMap = new TreeMap<>();

    static void bottomView(Node root) {


        Queue<QItem> q = new LinkedList<>();


        q.add(new QItem(root, 0));

        while (!q.isEmpty()) {

            QItem item = q.remove();

            int currentLevel = item.level;
            Node currentNode = item.node;
            levelMap.put(currentLevel, currentNode.getValue());

            if (currentNode.left != null) {
                q.add(new QItem(currentNode.left, currentLevel - 1));
            }


            if (currentNode.right != null) {
                q.add(new QItem(currentNode.right, currentLevel + 1));
            }


        }

    }

    public static void main(String args[]) {

        Node n1 = new Node("A");
        Node n2 = new Node("B");
        Node n3 = new Node("C");
        Node n4 = new Node("D");
        Node n5 = new Node("E");
        Node n6 = new Node("F");

        n1.left = n2;
        n1.right = n3;

        n2.left = n4;
        n2.right = n5;
        n4.left = n6;

        bottomView(n1);

        for (String val : levelMap.values()){
            System.out.println(val);
        }
    }
}
