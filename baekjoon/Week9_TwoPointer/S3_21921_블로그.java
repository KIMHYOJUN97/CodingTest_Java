package baekjoon.Week9_TwoPointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class S3_21921_블로그 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int x = Integer.parseInt(input[1]);
        int[] dp = new int[n+1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] numbers = new int[n+1];
        for (int i = 1; i <= n; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i <= x; i++) {
            dp[i] = dp[i-1]+numbers[i];
        }
        for (int i = x+1; i <= n; i++) {
            dp[i] = dp[i - 1] - numbers[i - x] + numbers[i];
        }

        Arrays.sort(dp);
        int max = dp[n];
        int cnt = 0;
        for (int i = 1; i <= n; i++) {
            if(max==dp[i])cnt++;
        }

        if(max==0) System.out.println("SAD");
        else{
            System.out.println(max);
            System.out.println(cnt);
        }
    }
}
