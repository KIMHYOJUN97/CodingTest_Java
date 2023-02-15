package baekjoon.Week5_DP2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S1_22869_징검다리건너기small {

    static int n;
    static int k;
    static boolean[] dp;
    static int[] rock;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        rock = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            rock[i] = Integer.parseInt(st.nextToken());
        }
        dp = new boolean[n + 1];

        dfs(1);

        System.out.println(dp[n]?"YES":"NO");
    }

    private static void dfs(int idx) {
        if (idx == n) {
            dp[idx] = true;
            return;
        }
        if(dp[idx])return;

        dp[idx] = true;
        for (int i = idx + 1; i <= n; i++) {
            if((i-idx)*(1+Math.abs(rock[idx-1]-rock[i-1]))<=k) dfs(i);
        }
    }
}
