package baekjoon.Week13;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class S2_2630_색종이만들기 {
    static int n,blue=0,white=0;
    static int[][] board;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = stoi(br.readLine());
        board = new int[n][n];
        for (int i = 0; i < n; i++) {
            String[] inputs = br.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                board[i][j] = stoi(inputs[j]);
            }
        }
        dfs(0, 0, n);

        System.out.println(blue);
        System.out.println(white);
    }

    static void dfs(int a, int b, int size) {
        if (search(a, b, size)) {
            if(board[a][b]==0)blue++;
            else white++;
            return;
        }

        int new_size = size/2;

        dfs(a, b, new_size);
        dfs(a, b + new_size, new_size);
        dfs(a + new_size, b, new_size);
        dfs(a + new_size, b + new_size, new_size);
    }

    static boolean search(int a,int b,int size){
        int now = board[a][b];
        for (int i = a; i < a + size; i++) {
            for (int j=b; j < b + size; j++) {
                if(board[i][j]!=now)return false;
            }
        }
        return true;
    }

    static int stoi(String s){
        return Integer.parseInt(s);
    }
}
