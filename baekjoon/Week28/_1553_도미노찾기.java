package baekjoon.Week28;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _1553_도미노찾기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[][] board = new int[8][8];
        for (int i = 0; i < 8; i++) {
            String[] s = br.readLine().split("");
            for (int j = 0; j < 7; j++) {
                board[i][j] = stoi(s[j]);
            }
        }


    }

    static int stoi(String s) {
        return Integer.parseInt(s);
    }
}
