package baekjoon.Week5_DP2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class G5_9084_동전 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int tc = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int t = 0; t < tc; t++) {
            int n = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            int[] coin = new int[n];
            for (int i = 0; i < n; i++) {
                coin[i] = Integer.parseInt(st.nextToken());
            }
            int target = Integer.parseInt(br.readLine());
            int[] dp = new int[target+1];
            for (int i = 0; i < n; i++) {
                for (int j = 1; j <= target; j++) {
                    if(j>=coin[i]) dp[j] += dp[j - coin[i]];
                }
            }
            sb.append(dp[target]+"\n");
            System.out.println(sb);
        }
    }
}
