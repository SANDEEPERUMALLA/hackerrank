package org.hackerrank.solutions;

import java.util.Scanner;

public class SherlockAndTheBeast {

    public static void main(String args[]){
        Scanner scanner = new Scanner(System.in);

        int T = scanner.nextInt();

        while (T!=0){

            int n = scanner.nextInt();

            if(n<0 || n==1 || n==2){
                System.out.println(-1);
                continue;
            }

            int count5= n - n%3;

            int count3 = n - count5;

            boolean flag = true;
            while (count3%5!=0){

                count5 -= 3;

                count3 +=3;

                if(count5 <0){
                    if(n%5==0){
                        count3 = n;
                        count5 = 0;
                        break;
                    }
                    else {
                        flag = false;
                        break;

                    }

                }


            }

            if(flag){
                StringBuilder sb = new StringBuilder();
                if(count5>0){
                    for(int i=0;i<count5;i++){
                        sb.append("5");
                    }
                }

                if(count3>0){
                    for(int i=0;i<count3;i++){
                        sb.append("3");
                    }
                }
                System.out.println(sb.toString());
            }
            else {
                System.out.println(-1);
            }
            T--;
        }
    }
}
