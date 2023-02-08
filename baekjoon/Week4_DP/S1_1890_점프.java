package baekjoon.Week4_DP;

import java.util.*;
import java.io.*;

public class S1_1890_점프 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[][] board = new int[N][N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        Long[][] dp = new Long[N][N];
        dp[0][0] = 1L;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                int nxt = board[i][j];
                if(nxt ==0)break;
                if(j+nxt<N)dp[i][j+nxt] += dp[i][j];
                if(i+nxt<N)dp[i+nxt][j] += dp[i][j];
            }
        }

        System.out.println(dp[N-1][N-1]);
    }
}
