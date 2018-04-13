package org.hackerrank.solutions;

import java.util.Stack;

public class ReverseAStack {

    static void insertAtBottom(Integer elm, Stack<Integer> stack) {

        if (stack.isEmpty()) {
            stack.push(elm);
            return;
        }
        Integer e = stack.pop();
        insertAtBottom(elm, stack);
        stack.push(e);

    }

    static void reverseStack(Stack<Integer> stack) {


        if (!stack.isEmpty()) {
            Integer elm = stack.pop();
            reverseStack(stack);
            insertAtBottom(elm, stack);

        }

    }

    public static void main(String args[]) {

        Stack<Integer> s = new Stack<>();

        s.push(1);
        s.push(2);
        s.push(3);
        s.push(4);
        s.push(5);
        s.push(6);

        reverseStack(s);

        while (!s.isEmpty()) {
            System.out.println(s.pop());
        }
    }
}
