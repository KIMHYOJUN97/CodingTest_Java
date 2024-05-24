package baekjoon.Com;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 20 2
// 21

//6 4
//
public class G5_2225_합분해 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int n = stoi(s[0]);
        int k = stoi(s[1]);

        int[][] dp = new int[n + 1][k + 1];

        for (int i = 0; i <= n; i++) {
            dp[i][0] = 0;
            dp[i][1] = 1;
        }

        for (int i = 0; i <= k; i++) {
            dp[1][i] = i;
        }

        for (int i = 2; i <= n; i++) {
            for (int j = 2; j <= k; j++) {
                dp[i][j] = (dp[i - 1][j] + dp[i][j - 1]) % 1000000000;
            }
        }

        System.out.println(dp[n][k]);
    }

    static int stoi(String s) {
        return Integer.parseInt(s);
    }
}
