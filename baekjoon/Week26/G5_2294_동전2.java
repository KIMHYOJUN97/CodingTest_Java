package baekjoon.Week26;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class G5_2294_동전2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int n = stoi(s[0]);
        int k = stoi(s[1]);

        int[] dp = new int[k + 1];
        Arrays.fill(dp, Integer.MAX_VALUE - 1);
        dp[0] = 0;
        for (int i = 1; i <= n; i++) {
            int coin = stoi(br.readLine());
            for (int j = coin; j <= k; j++) {
                dp[j] = Math.min(dp[j], dp[j - coin] + 1);
            }
        }
        System.out.println(dp[k] == Integer.MAX_VALUE - 1 ? -1 : dp[k]);
    }

    static int stoi(String s) {
        return Integer.parseInt(s);
    }
}
