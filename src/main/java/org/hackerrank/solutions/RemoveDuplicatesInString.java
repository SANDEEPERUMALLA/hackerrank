package org.hackerrank.solutions;

import java.util.Arrays;

public class RemoveDuplicatesInString {

    static public String removeDuplicates(String s) {

        char[] chars = s.toCharArray();

        Arrays.sort(chars);

        int i = 0;
        int index = 0;

        while (i < chars.length) {
            while (i + 1 < chars.length && chars[i] == chars[i + 1]) {
                i++;
            }
            chars[index++] = chars[i];
            i++;

        }

        if (i == chars.length - 1)
            chars[index++] = chars[i];

        s = new String(chars);
        return s.substring(0, index);
    }

    public static void main(String args[]) {

        System.out.println(removeDuplicates("aaabbbccd"));
    }
}
