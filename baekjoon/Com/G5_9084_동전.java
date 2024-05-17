package baekjoon.Com;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class G5_9084_동전 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = stoi(br.readLine());
        for (int t = 0; t < T; t++) {
            int n = stoi(br.readLine());
            int[] coins = new int[n];
            String[] s = br.readLine().split(" ");
            int target = stoi(br.readLine());
            int[] dp = new int[target + 1];
            dp[0] = 1;
            for (int i = 0; i < n; i++) {
                coins[i] = stoi(s[i]);
                for (int j = coins[i]; j <= target; j++) {
                    dp[j] += dp[j - coins[i]];
                }
            }
            System.out.println(dp[target]);
        }
    }

    static int stoi(String s) {
        return Integer.parseInt(s);
    }
}
