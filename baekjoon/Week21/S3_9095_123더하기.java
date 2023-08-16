package baekjoon.Week21;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class S3_9095_123더하기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = stoi(br.readLine());
        int[] num = new int[T];
        int max = 0;
        for (int t = 0; t < T; t++) {
            num[t] = stoi(br.readLine());
            max = Math.max(num[t], max);
        }
        int[] dp = new int[max+1];
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;
        for (int i = 4; i <= max; i++) {
            dp[i] = dp[i-1] + dp[i-2] + dp[i-3];
        }
        for (int i = 0; i < T; i++) {
            System.out.println(dp[num[i]]);
        }
    }

    static int stoi(String s) {
        return Integer.parseInt(s);
    }

}
