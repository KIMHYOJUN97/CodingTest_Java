package baekjoon.Week18;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class S3_1463_1로만들기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int x = Integer.parseInt(br.readLine());
        //1과 가까운 연산을 하기 위해선 어떤 전처리 과정이 필요할까?
        int[] dp = new int[x+1];

        dp[1] = 0;
        dp[2] = 1;
        for (int i = 3; i <= x; i++) {
            //1을 뺀 경우이다.
            dp[i] = dp[i-1]+1;

            if (i % 3 == 0) {
                dp[i] = Math.min(dp[i], dp[i / 3] + 1);
            }

            if (i % 2 == 0) {
                dp[i] = Math.min(dp[i], dp[i / 2] + 1);
            }
        }
        System.out.println(dp[x]);
    }

}
