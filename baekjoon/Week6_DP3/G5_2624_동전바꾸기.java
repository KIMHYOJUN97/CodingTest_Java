package baekjoon.Week6_DP3;

import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class G5_2624_동전바꾸기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        int k = Integer.parseInt(br.readLine());
        int[][] coins = new int[k][2];
        for (int i = 0; i < k; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int coin = Integer.parseInt(st.nextToken());
            int count = Integer.parseInt(st.nextToken());
            coins[i][0] = coin;
            coins[i][1] = count;
        }
        int[][] dp = new int[k + 1][t + 1];


    }
}
