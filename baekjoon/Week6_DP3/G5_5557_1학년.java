package baekjoon.Week6_DP3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


//
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.StringTokenizer;
//
//public class G5_5557_1학년 {
//
//    static int count;
//    static int[] number;
//    static int n;
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        n = Integer.parseInt(br.readLine());
//        StringTokenizer st = new StringTokenizer(br.readLine());
//        number = new int[n];
//        for (int i = 0; i < n; i++) {
//            number[i] = Integer.parseInt(st.nextToken());
//        }
//
//        dfs(1, number[0]);
//        System.out.println(count);
//
//    }
//
//    private static void dfs(int idx,int sum) {
//        if (idx == n-1) {
//            if(sum >=0 && sum<=20){
//                if(sum==number[n-1]){
//                    count++;
//                }
//            }
//            return;
//        }
//
//        dfs(idx + 1, sum + number[idx]);
//        dfs(idx + 1, sum - number[idx]);
//
//    }
//}
public class G5_5557_1학년 {

    static int n;
    static int[] number;
    static long[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        number = new int[n];
        for (int i = 0; i < n; i++) {
            number[i] = Integer.parseInt(st.nextToken());
        }

        dp = new long[21][100];

        for (int i = 0; i < 21; i++) {
            for(int j=0;j<100;j++) dp[i][j] = -1;
        }

        System.out.println(dfs(number[0],0));
    }

    private static long dfs(int idx, int sum) {
        if(sum < 0 || sum > 20) return 0;

        if(idx == n-2) return (sum == number[n - 1]) ? 1 : 0;

        if(dp[sum][idx]!= -1) return dp[sum][idx];

        dp[sum][idx] = 0;

        return dp[sum][idx] += dfs(sum + number[idx + 1], idx + 1) + dfs(sum - number[idx + 1], idx + 1);
    }
}