package baekjoon.Week6_DP3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//N - 가장 긴 오름차순 갯수
public class G4_2631_줄세우기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] child = new int[n];
        for (int i = 0; i < n; i++) {
            child[i] = Integer.parseInt(br.readLine());
        }
        int[] dp = new int[n];
        dp[0] = 1;

        int ans = 0;
        for (int i = 1; i < n; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if(child[i]>child[j]) dp[i] = Math.max(dp[i], dp[j] + 1);
            }
            ans = Math.max(ans, dp[i]);
        }
        System.out.println(n-ans);
    }
}
