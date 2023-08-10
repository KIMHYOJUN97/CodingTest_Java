package baekjoon.Week20;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class S1_1074_Z {
    static int[][] board;
    static int cnt = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int r = Integer.parseInt(s[1]);
        int c = Integer.parseInt(s[2]);
        int size = (int) Math.pow(2,n);
        board = new int[size][size];
        divide_conqaure(size, 0, 0);
        System.out.println(board[r][c]);
    }

    static void divide_conqaure(int n,int i, int j ) {
        if(n==1)return;
        if (n == 2) {
            board[i][j] = cnt++;
            board[i][j+1] = cnt++;
            board[i+1][j] = cnt++;
            board[i+1][j+1] = cnt++;
        }

        int size = n/2;
        divide_conqaure(size, i, j);
        divide_conqaure(size, i, j + size);
        divide_conqaure(size, i + size, j);
        divide_conqaure(size, i + size, j + size);
    }

}
