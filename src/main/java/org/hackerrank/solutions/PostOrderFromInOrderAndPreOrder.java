package org.hackerrank.solutions;

public class PostOrderFromInOrderAndPreOrder {

    static int preIndex = 0;


    static int findIndex(int d, int in[]) {
        for (int i = 0; i < in.length; i++) {
            if (d == in[i]) {
                return i;
            }
        }
        return -1;
    }

    static Node createTree(int pre[], int in[], int start, int end) {

        if (start > end) {
            return null;
        }

        Node node = new Node(pre[preIndex++]);

        if (start == end) {
            node.left = null;
            node.right = null;
        }


        int index = findIndex(node.data, in);

        node.left = createTree(pre, in, start, index - 1);
        node.right = createTree(pre, in, index + 1, end);
        return node;
    }

    static void postOrder(Node root) {
        if (root == null) {
            return;
        }
        postOrder(root.left);
        postOrder(root.right);
        System.out.println(root.data);
    }

    public static void main(String args[]) {

        Node n1 = new Node(1);

        Node root = createTree(new int[]{1, 2, 4, 5, 3, 6, 7}, new int[]{4, 2, 5, 1, 6, 3, 7}, 0, 6);

        postOrder(root);

    }
}

/*
        1
      2     3
    4   5  6  7

    Pre Order = 1245367
    In Order = 4251637
    Post Order = 45267331



 */
