package baekjoon.Week26;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class S1_1890_점프_DP {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = stoi(br.readLine());
        int[][] arr = new int[n][n];

        for (int i = 0; i < n; i++) {
            String[] s = br.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                arr[i][j] = stoi(s[j]);
            }
        }

        long[][] dp = new long[n][n];

        dp[0][0] = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int jump = arr[i][j];
                if (jump == 0) continue;
                if (i + jump < n) dp[i + jump][j] += dp[i][j];
                if (j + jump < n) dp[i][j + jump] += dp[i][j];
            }
        }

        System.out.println(dp[n - 1][n - 1]);
    }

    static int stoi(String s) {
        return Integer.parseInt(s);
    }
}
