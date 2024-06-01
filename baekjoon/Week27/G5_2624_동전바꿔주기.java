package baekjoon.Week27;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class G5_2624_동전바꿔주기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = stoi(br.readLine());
        int n = stoi(br.readLine());
        int[][] coins = new int[n][2];

        for (int i = 0; i < n; i++) {
            String[] s = br.readLine().split(" ");
            coins[i][0] = stoi(s[0]);
            coins[i][1] = stoi(s[1]);
        }

        int[] dp = new int[T + 1];

        dp[0] = 1;

        for (int i = 0; i < n; i++) {
            for (int j = T; j >= 0; j--) {
                for (int k = 1; k <= coins[i][1]; k++) {
                    if (j - coins[i][0] * k >= 0) {
                        dp[j] += dp[j - coins[i][0] * k];
                    }
                }
            }
        }

        System.out.println(dp[T]);
    }

    static int stoi(String s) {
        return Integer.parseInt(s);
    }
}
