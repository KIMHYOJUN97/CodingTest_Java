package baekjoon.Week4_DP;

import java.math.BigInteger;
import java.util.*;
import java.io.*;

public class S3_2407_조합 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);
        Long[] factorial_dp =new Long[101];
        factorial_dp[0] = 1L;
        for (int i = 1; i < 101; i++) {
            factorial_dp[i] = factorial_dp[i-1]*i;
        }
        Long ans = factorial_dp[n] / (factorial_dp[n - m] * factorial_dp[m]);
        System.out.println(ans);

    }

//    public static void main(String[] args) throws IOException{
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//
//        String[] input = br.readLine().split(" ");
//
//        int n = Integer.parseInt(input[0]);
//        int m = Integer.parseInt(input[1]);
//
//        BigInteger[][] bi = new BigInteger[101][101];
//
//        for(int i = 1; i<=n; i++){
//            for(int j = 0; j<=i; j++){
//
//                if(j==0||j == i)
//                    bi[i][j] = BigInteger.ONE;
//                else{
//                    bi[i][j] = bi[i-1][j].add(bi[i-1][j-1]);
//                }
//            }
//        }
//
//        System.out.println(bi[n][m]);
//    }
}
