package org.hackerrank.solutions;


import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringSpaceRemover {

    static String removeSpaces(String s) {

        int k = 0;

        char ch[] = s.toCharArray();


        for (int i = 0; i < ch.length; i++) {

            if (ch[i] != ' ') {
                ch[k++] = ch[i];
            }
        }


        return new String(Arrays.copyOfRange(ch, 0, k));
    }

    public static void main(String args[]) {

        String str = "acb  def feg frggg     eef";

        System.out.println(removeSpaces(str));

        String s = "abcsefrsefkjgnjrsefjgnrjsef";

        System.out.println(s.replaceAll("sef","123"));

        Pattern p = Pattern.compile("[0-9]+");

        Matcher m = p.matcher("abc1234jrjgh234334njfg2343");

        while (m.find()){
            System.out.println(m.group());
        }

        System.out.println(m.replaceAll("000"));

    }
}
