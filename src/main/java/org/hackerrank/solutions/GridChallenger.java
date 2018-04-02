package org.hackerrank.solutions;

import java.util.Arrays;
import java.util.Scanner;

public class GridChallenger {

    static String gridChallenge(String[] grid) {

        int len = grid.length;

        char res[][] = new char[len][len];

        for(int i=0;i<len;i++){


            char[] chars = grid[i].toCharArray();

            Arrays.sort(chars);
            res[i] = chars;
        }


        boolean flag = true;
        for(int j=0;j<len;j++){
            for(int i=0;i<len-1;i++){
                if(!(res[i][j]<=res[i+1][j])){
                    flag = false;
                    break;
                }
            }
        }

        return flag ? "YES" : "NO";
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();

        while (t!=0){
            int n = in.nextInt();
            String[] grid = new String[n];
            for(int grid_i = 0; grid_i < n; grid_i++){
                grid[grid_i] = in.next();
            }
            String result = gridChallenge(grid);
            System.out.println(result);

        }

        in.close();
    }
}
