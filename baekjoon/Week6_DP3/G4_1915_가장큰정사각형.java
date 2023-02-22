package baekjoon.Week6_DP3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class G4_1915_가장큰정사각형 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] dp = new int[n + 1][m + 1];
        int[][] graph = new int[n+1][m+1];
        int max = Integer.MIN_VALUE;
        for (int i = 1; i <= n; i++) {
            String input = br.readLine();
            for (int j = 1; j <= m; j++) {
                int tmp = input.charAt(j - 1) - '0';
                if (tmp == 1) {
                    dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i][j - 1], dp[i - 1][j]));
                    max = Math.max(max, dp[i][j]);
                }
            }
        }
        System.out.println(max*max);
    }
}
