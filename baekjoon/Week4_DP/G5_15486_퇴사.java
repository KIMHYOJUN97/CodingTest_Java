package baekjoon.Week4_DP;

import java.util.*;
import java.io.*;

public class G5_15486_퇴사 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[][] board = new int[2][n+1];
        int[] dp = new int[n+1];
        for (int i = 1; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            board[0][i] = Integer.parseInt(st.nextToken());
            board[1][i] = Integer.parseInt(st.nextToken());
        }
        int max = 0;

        for (int i = 1; i <= n; i++) {
            if(max < dp[i]) max = dp[i];

            int nxt = i + board[i][0];
            if (nxt < n + 2) {
                dp[nxt] = Math.max(dp[nxt], max + board[i][1]);
            }
        }
        System.out.println(dp[n+1]);
    }
}
