package org.codechef;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

 public class Lapindromes {

    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        while (T != 0) {

            String s = scanner.next();
            Map<Character, Integer> m = new HashMap<>();

            for (int i = 0; i < s.length() / 2; i++) {

                Integer c = m.get(s.charAt(i));

                m.put(s.charAt(i), c != null ? c + 1 : 1);
            }

            int start = s.length() % 2 == 0 ? s.length() / 2 : s.length() / 2 + 1;
            boolean flag = true;
            for (int i = start; i < s.length(); i++) {
                Integer c = m.get(s.charAt(i));
                if(c==null){
                    flag = false;
                    break;
                }

                m.put(s.charAt(i), --c);


            }


            if(!flag){
                System.out.println("NO");
            }
            else {
                 flag = true;
                for(Integer c : m.values()){
                    if(c!=0){
                        flag = false;
                    }
                }

                if(flag){
                    System.out.println("YES");
                }
                else {
                    System.out.println("NO");
                }
            }

            T--;
        }
    }
}
