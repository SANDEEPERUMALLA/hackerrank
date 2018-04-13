package org.hackerrank.solutions;

import com.sun.org.apache.regexp.internal.RE;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PrintAllPermutations {

    static List<String> getAllPermutations(String str){

        if(str.length()==1){
            return Arrays.asList(str);
        }
        char firstChar = str.charAt(0);

        List<String> childPermutations = getAllPermutations(str.substring(1));

        List<String> res = new ArrayList<>();

        for(String cStr : childPermutations){

            String t = cStr;
            for(int i=0;i<=t.length();i++){
                String l = t.substring(0,i);
                String r = t.substring(i);
                res.add(l+firstChar+r);
            }
        }

        return res;
    }

    public static void main(String args[]){
        System.out.println( getAllPermutations("ABCD"));;
    }
}
