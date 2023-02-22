package baekjoon.Week6_DP3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class G5_9251_LCS {

    static char[] str;
    static char[] str2;
    static Integer[][] dp;
    static int max = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        str = br.readLine().toCharArray();
        str2 = br.readLine().toCharArray();

        dp = new Integer[str.length][str2.length];

        System.out.println(lcs(str.length-1,str2.length-1));
    }

    private static int lcs(int a, int b) {
        if(a <0||b<0)return 0;

        if (dp[a][b] == null) {
            dp[a][b]=0;
            if(str[a]==str2[b])dp[a][b] = lcs(a-1,b-1)+1;
            else dp[a][b] = Math.max(lcs(a - 1, b), lcs(a, b - 1));
        }

        return dp[a][b];
    }
}
