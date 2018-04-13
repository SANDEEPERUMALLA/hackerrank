package org.hackerrank.solutions;

import java.util.HashMap;
import java.util.Map;

public class PhoneDialPad {


    static void printCombinations(String str, Map<Integer, String> m, int index, char res[]) {


        if (index == str.length()) {
            for (int i = 0; i < res.length; i++) {
                System.out.print(res[i]);
            }
            System.out.println();
            return;
        }
        int num = str.charAt(index) - 48;

        String s = m.get(num);

        for (int i = 0; i < s.length(); i++) {

            res[index] = s.charAt(i);
            printCombinations(str, m, index + 1, res);
        }


    }

    static void printCombinationsWrapper(String in, Map<Integer, String> m) {


        printCombinations(in, m, 0, new char[in.length()]);

    }


    public static void main(String args[]) {

        Map<Integer, String> map = new HashMap<>();

        map.put(1, "abc");
        map.put(2, "def");
        map.put(3, "ghi");
        map.put(4, "jkl");
        map.put(5, "mno");
        map.put(6, "pqr");
        map.put(7, "stu");
        map.put(8, "wxz");
        map.put(9, "z!@");
        map.put(0, "#$%");

        String input = "143546";

        printCombinationsWrapper(input, map);


    }
}
