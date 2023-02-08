package baekjoon.Week4_DP;

import java.util.*;
import java.io.*;

public class 스티커_9465 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int tc = Integer.parseInt(br.readLine());
        for (int t = 0; t < tc; t++) {
            int n = Integer.parseInt(br.readLine());
            int[][] board = new int[2][n+1];
            int[][] dp = new int[2][n+1];
            for (int i = 0; i < 2; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 1; j < n + 1; j++) {
                    board[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            dp[0][1] = board[0][1];
            dp[1][1] = board[1][1];
            int max = 0;
            for (int i = 2; i < n+1; i++) {
                dp[0][i] = Math.max(dp[1][i - 1] + board[0][i], dp[1][i - 2] + board[0][i]);
                dp[1][i] = Math.max(dp[0][i - 1] + board[1][i], dp[0][i - 2] + board[1][i]);
                max = Math.max(dp[0][i], dp[1][i]);
            }
            System.out.println(max);
        }
    }
}
