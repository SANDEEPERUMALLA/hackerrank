package org.codechef;

import java.util.Scanner;

public class CountSubstrings {

    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);

        int T = scanner.nextInt();
        while (T != 0) {


            int N = scanner.nextInt();
            String s = scanner.next();

            int count0=0, count1 =0;
            for(int i=0;i<s.length();i++){

                if(s.charAt(i)=='0'){
                    count0++;
                }
                else{
                    count1++;
                }
            }

            if(count1<2){
                System.out.println(0);
            }
            else {
                int countOfSubStrings = 0;
                for(int i=2;i<=N;i++){
                    int left = N;
                    int right = N-1;

                    int delta = i -2;
                    if(delta>0){
                        int mid = nCr(N-2,delta);
                        countOfSubStrings+= left*right*mid;
                    }
                    else {
                        countOfSubStrings += left*right;
                    }



                }
            }

        }
    }

    public static int fact(int num)
    {
        int fact=1, i;
        for(i=1; i<=num; i++)
        {
            fact = fact*i;
        }
        return fact;
    }

    static int nCr(int n ,int r){

        return (fact(n)/(fact(n-r)*fact(r)));
    }
}


