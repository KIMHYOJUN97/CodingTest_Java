package baekjoon.Com;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class S1_14631_1로만들기 {
    static int[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = stoi(br.readLine());
        dp = new int[n+1];

        System.out.println(recur(n));
    }

    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    static int recur(int n) {
        if (dp[n] == 0) {
            if(n==1){
                if (n % 6 == 0) {
                    dp[n] = Math.min(recur(n-1), Math.min(recur(n/3), recur(n/2))) + 1;
                } else if (n % 3 == 0) {
                    dp[n] = Math.min(recur(n / 3), recur(n - 1)) + 1;
                } else if (n % 2 == 0) {
                    dp[n] = Math.min(recur(n/2), recur(n-1)) + 1;
                }else{
                    dp[n] = recur(n-1) + 1;
                }
            }
        }
        return dp[n];
    }
}
