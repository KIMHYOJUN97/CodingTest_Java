package baekjoon.retry;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class S1_1992_쿼드트리 {
    static int n;
    static int[][] board;
    static String answer = "";
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = stoi(br.readLine());
        board = new int[n][n];
        for (int i = 0; i < n; i++) {
            String[] s = br.readLine().split("");
            for (int j = 0; j < n; j++) {
                board[i][j] = stoi(s[j]);
            }
        }
        divide_conquer(0,0,n);
        System.out.println(answer);
    }

    static void divide_conquer(int x,int y, int size) {
        if(check(x,y,size)){
            answer += String.valueOf(board[y][x]);
            return;
        }

        int new_size = size/2;
        answer += "(";
        //L U
        divide_conquer(x, y, new_size);
        //R U
        divide_conquer(x + new_size, y, new_size);
        //L D
        divide_conquer(x, y + new_size, new_size);
        //R D
        divide_conquer(x + new_size, y + new_size, new_size);
        answer += ")";
    }

    static boolean check(int x, int y, int size) {
        int now = board[y][x];
        for (int i = y; i < y + size; i++) {
            for (int j = x; j < x + size; j++) {
                if(board[i][j]!=now)return false;
            }
        }

        return true;
    }

    static int stoi(String s) {
        return Integer.parseInt(s);
    }
}
