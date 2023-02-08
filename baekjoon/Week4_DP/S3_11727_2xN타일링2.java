package baekjoon.Week4_DP;

import java.io.*;

//문제 오류?
public class S3_11727_2xN타일링2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] dp = new int[1001];
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 3;
        for (int i = 3; i < 1001; i++) {
            dp[i] = dp[i - 1] + 2 * dp[i - 2];
        }

        System.out.println(dp[n]%10007);
    }
}
