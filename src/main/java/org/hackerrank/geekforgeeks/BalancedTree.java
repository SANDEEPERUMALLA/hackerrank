package org.hackerrank.geekforgeeks;

public class BalancedTree {
    boolean isBalanced(Node root) {

        if(root==null){
            return true;
        }


        boolean l = isBalanced(root.left);
        boolean r = isBalanced(root.right);

        return l && r;
    }
}
