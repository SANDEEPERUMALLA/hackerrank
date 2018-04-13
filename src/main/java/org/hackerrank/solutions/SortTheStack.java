package org.hackerrank.solutions;

import java.util.Stack;

public class SortTheStack {

    static void insertAtPosition(Stack<Integer> stack, Integer elm) {

        if (stack.isEmpty() || elm < stack.peek()) {
            stack.push(elm);
        } else {
            Integer e = stack.pop();
            insertAtPosition(stack, elm);
            stack.push(e);
        }
    }

    static void sortStack(Stack<Integer> stack) {


        if (!stack.isEmpty()) {
            Integer elem = stack.pop();
            sortStack(stack);
            insertAtPosition(stack, elem);

        }


    }


    public static void main(String args[]) {

        Stack<Integer> s = new Stack<>();

        s.push(1);
        s.push(56);
        s.push(4444);
        s.push(11);
        s.push(64545);
        s.push(612);

        sortStack(s);

        while (!s.isEmpty()) {
            System.out.println(s.pop());
        }
    }
}
