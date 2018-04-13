package org.hackerrank.solutions;


class Node {
    Node left;
    Node right;
    public int data;

    Node(int data) {
        this.data = data;
    }
}

public class BoundaryTraversal {

    static void printLeaves(Node root){

        if(root ==null){
            return;
        }
        if(root.left ==null && root.right ==null){
            System.out.println(root.data);
        }

        printLeaves(root.left);
        printLeaves(root.right);
    }


    static void printLeftBoundary(Node node){

        if(node.left!=null){
            System.out.println(node.data);
            printLeftBoundary(node.left);
        }
        else if(node.right!=null){
            System.out.println(node.data);
            printLeftBoundary(node.right);
        }
    }

    static void printRightBoundary(Node node){

        if(node.right!=null){

            printRightBoundary(node.left);
            System.out.println(node.data);

        }
        else if(node.left!=null){
            printRightBoundary(node.right);
            System.out.println(node.data);
        }
    }
    static void boundaryTraversal(Node root){

        System.out.println(root.data);
        printLeftBoundary(root.left);
        printLeaves(root);
        printRightBoundary(root.right);

    }

    public static void main(String args[]){
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

        boundaryTraversal(n1);

    }
}
