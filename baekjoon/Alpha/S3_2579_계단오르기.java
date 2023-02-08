package baekjoon.Alpha;

import java.io.*;
public class S3_2579_계단오르기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] top = new int[n+1];
        for (int i = 1; i <= n; i++) {
            top[i] = Integer.parseInt(br.readLine());
        }
        int[] dp = new int[n + 1];
        dp[1] = top[1];
        dp[2] = dp[1] + top[2];
        dp[3] = Math.max(dp[1], dp[2]) + top[3];
        for (int i = 4; i <= n; i++) {
            dp[i] = Math.max(dp[i - 3] + top[i - 1], dp[i - 2]) + top[i];
        }
        System.out.println(dp[n]);
    }
}
