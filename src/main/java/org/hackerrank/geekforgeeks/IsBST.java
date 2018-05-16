package org.hackerrank.geekforgeeks;


public class IsBST {

    static class Node
    {
        int data;
        Node left, right;
        Node(int item)
        {
            data = item;
            left = right = null;
        }
    }

   static boolean isBinarySearchTree(Node node, int max, int min) {

        if (!(node.data < max && node.data > min)) {
            return false;
        }


        boolean l = true;
        if (node.left != null) {
            l = isBinarySearchTree(node.left, node.data, min);
        }

        if (!l) {
            return false;
        }


        if (node.right == null) {
            return true;
        }


        return isBinarySearchTree(node.right, max, node.data);


    }


   static int isBST(Node root) {
        if(root == null){
            return 0;
        }

        boolean res = isBinarySearchTree(root, Integer.MAX_VALUE, Integer.MIN_VALUE);

        return res ? 1 : 0;

    }

    public static void main(String args[]){
        IsBST.Node node = new IsBST.Node(0);

        System.out.println(isBST(node));
    }
}
