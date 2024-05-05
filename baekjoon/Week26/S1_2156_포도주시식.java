package baekjoon.Week26;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class S1_2156_포도주시식 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = stoi(br.readLine());
        int[] wines = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            wines[i] = stoi(br.readLine());
        }

        int[] dp = new int[n + 1];
        dp[1] = wines[1];

        if (n > 1) {
            dp[2] = wines[1] + wines[2];
        }
        for (int i = 3; i <= n; i++) {
            dp[i] = Math.max(dp[i - 1], Math.max(dp[i - 2] + wines[i], dp[i - 3] + wines[i - 1] + wines[i]));
        }

        System.out.println(dp[n]);

    }

    static int stoi(String s) {
        return Integer.parseInt(s);
    }
}
