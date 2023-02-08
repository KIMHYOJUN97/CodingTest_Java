package baekjoon.Week4_DP;

import java.util.*;
import java.io.*;

public class G5_1106_호텔 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int c = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int[] dp = new int[c+101];
        Arrays.fill(dp,50000);
        dp[0] = 0;
        int min = 100;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int cost = Integer.parseInt(st.nextToken());
            int person = Integer.parseInt(st.nextToken());

            for (int j = person; j < c + 101; j++) {
                dp[j] = Math.min(dp[j], cost + dp[j - person]);
                min = Math.min(min, dp[j]);
            }
        }
        System.out.println(min);
    }
}
