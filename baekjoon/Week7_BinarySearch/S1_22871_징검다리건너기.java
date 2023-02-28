package baekjoon.Week7_BinarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class S1_22871_징검다리건너기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] rocks = new int[n];
        for (int i = 0; i < n; i++) {
            rocks[i] = Integer.parseInt(st.nextToken());
        }
        int[] dp = new int[n];
        Arrays.fill(dp,999999999);
        dp[0] = 0;

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                int power = Math.max((i - j) * (1 + Math.abs(rocks[i] - rocks[j])), dp[j]);
                dp[i] = Math.min(dp[i], power);
            }
        }
        System.out.println(dp[n-1]);
    }
}
