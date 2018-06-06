package org.hackerearth;

import java.util.Scanner;

public class OneSwapToPalindrome {


    /*
     abcba
     */

    static class Pair {
        char val1;
        char val2;

        public Pair(char val1, char val2) {
            this.val1 = val1;
            this.val2 = val2;
        }

        public char getVal1() {
            return val1;
        }

        public char getVal2() {
            return val2;
        }
    }

    static boolean canBePalindrome(String str) {

        int nonMatches = 0;
        int len = str.length();

        Pair pairs[] = new Pair[2];

        for (int i = 0; i < str.length() / 2; i++) {
            if (str.charAt(i) != str.charAt(len - i - 1)) {
                nonMatches++;

                if (nonMatches > 2) {
                    return false;
                }

                pairs[nonMatches - 1] = new Pair(str.charAt(i), str.charAt(len - i - 1));
            }

        }

        if (nonMatches==0){
            return true;
        }


        if (str.length() % 2 == 0) {
            if (nonMatches == 1) {
                return false;
            }

            if ((pairs[0].val1 == pairs[1].val1 && pairs[0].val2 == pairs[1].val2) || (pairs[0].val1 == pairs[1].val2 && pairs[0].val2 == pairs[1].val1)) {
                return true;
            }
            return false;
        } else {

            if (nonMatches == 1) {
                char midChar = str.charAt(str.length() / 2);
                if (midChar == pairs[0].val1 || midChar == pairs[0].val2) {
                    return true;
                }
                return false;

            } else {
                if ((pairs[0].val1 == pairs[1].val1 && pairs[0].val2 == pairs[1].val2) || (pairs[0].val1 == pairs[1].val2 && pairs[0].val2 == pairs[1].val1)) {
                    return true;
                }
                return false;
            }


        }

    }

    public static void main(String args[]) {

        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        while (T != 0) {

            String str = scanner.next();

            boolean result = canBePalindrome(str);

            System.out.println(result ? "Yes" : "No");

            T--;
        }

    }
}
