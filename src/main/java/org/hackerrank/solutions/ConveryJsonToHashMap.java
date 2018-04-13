package org.hackerrank.solutions;

import java.util.HashMap;
import java.util.Map;

public class ConveryJsonToHashMap {


    static Map<String,Object> convert(String s, int position){

        Map<String,Object> m = new HashMap<>();

        String key = "",value="";

        for(int i=position;i<s.length();i++){

            if(s.charAt(i) =='{' || s.charAt(i) ==',')
                continue;

            if(s.charAt(i) =='"') {
                int j=i+1;
                StringBuilder sb = new StringBuilder();
                while (j<s.length() && s.charAt(j)!='"'){
                    sb.append(s.charAt(j));
                    j++;
                }
                key = sb.toString();
                i=j+1;
            }
            else if(s.charAt(i)==':'){
                i++;
                while (i  <s.length()&& s.charAt(i)=='\u0000' || s.charAt(i)==' '){
                    i++;
                }
                if(s.charAt(i)=='{'){
                    m.put(key,convert(s,i+1));
                }
                else {

                    int j=i+1;
                    j++;
                    StringBuilder sb = new StringBuilder();
                    while (j<s.length() && s.charAt(j)!='"'){
                        sb.append(s.charAt(j));
                        j++;
                    }
                    value = sb.toString();
                    m.put(key,value);
                    i=j+1;

                }
            }
            else if(s.charAt(i)=='}'){
                return m;
            }
        }

        return m;
    }

    public static void main(String args[]){

        String json = "{\n" +
                "  \"abc\" : \"def\",\n" +
                "  \"test\" : {\n" +
                "    \"ab\" : \"23\",\n" +
                "    \"qw\" : \"34\"\n" +
                "  }\n" +
                "}";

        System.out.println(convert(json,0));

        System.out.println("test"+'\u0000');

    }
}
