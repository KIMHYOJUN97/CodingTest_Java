package baekjoon.Week6_DP3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class G5_14567_선수과목 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] dp = new int[n + 1];
        boolean[][] list = new boolean[n + 1][n + 1];
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            list[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())] = true;
        }


        for (int i = 1; i <= n; i++) {
            dp[i] = 1;

            for (int j = 1; j < i; j++) {
                if(list[j][i]) dp[i] = Math.max(dp[i], dp[j] + 1);
            }
        }

        for (int i = 1; i <= n; i++) {
            System.out.println(dp[i]);
        }
    }
}
