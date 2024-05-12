package baekjoon.Week26;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class G5_15486_퇴사2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = stoi(br.readLine());
        int[][] arr = new int[n + 2][2];
        int[] dp = new int[n + 2];
        for (int i = 1; i <= n; i++) {
            String[] s = br.readLine().split(" ");
            arr[i][0] = stoi(s[0]);
            arr[i][1] = stoi(s[1]);
        }

        int max = -1;
        for (int i = 1; i <= n + 1; i++) {
            max = Math.max(max, dp[i]);

            int nxt = i + arr[i][0];
            if (nxt <= n + 1) {
                dp[nxt] = Math.max(dp[nxt], max + arr[i][1]);
            }
        }

        System.out.println(dp[n + 1]);
    }

    static int stoi(String s) {
        return Integer.parseInt(s);
    }
}
