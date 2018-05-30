package org.hackerrank.solutions;

public class NextNumber {

    static void swap(char[] ch, int i, int j) {

        char temp = ch[i];
        ch[i] = ch[j];
        ch[j] = temp;

    }

    static int findNextNumber(int number) {

        char[] ch = String.valueOf(number).toCharArray();

        int breakPoint = -1;
        for (int i = ch.length-1; i >= 1; i--) {

            if (ch[i - 1] < ch[i]) {
                breakPoint = i-1;
                break;

            }
        }

        if(breakPoint==-1){
            return number;
        }

        swap(ch, breakPoint, ch.length - 1);

        for (int i = breakPoint + 1, j = ch.length - 1; i < j; i++, j--) {
            swap(ch, i, j);

        }


        return Integer.valueOf(String.valueOf(ch));


    }


    public static void main(String args[]){

        System.out.println(findNextNumber(142987));

    }
}
