package baekjoon.Week5_DP2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//public class S1_11660_구간합구하기5 {
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine());
//        int n = Integer.parseInt(st.nextToken());
//        int k = Integer.parseInt(st.nextToken());
//        int[][] board = new int[n + 1][n + 1];
//        for (int i = 1; i <= n; i++) {
//            st = new StringTokenizer(br.readLine());
//            for (int j = 1; j <= n; j++) {
//                board[i][j] = Integer.parseInt(st.nextToken());
//            }
//        }
//
//        StringBuilder sb = new StringBuilder();
//        for (int K = 0; K < k; K++) {
//            st = new StringTokenizer(br.readLine());
//            int x1 = Integer.parseInt(st.nextToken());
//            int y1 = Integer.parseInt(st.nextToken());
//            int x2 = Integer.parseInt(st.nextToken());
//            int y2 = Integer.parseInt(st.nextToken());
//
//            int sum = 0;
//            for (int i = x1; i <= x2; i++) {
//                for (int j = y1; j <= y2; j++) {
//                    sum += board[i][j];
//                }
//            }
//            sb.append(sum).append("\n");
//        }
//
//        System.out.println(sb);
//    }
//}
public class S1_11660_구간합구하기5 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[][] board = new int[n + 1][n + 1];
        int[][] dp = new int[n + 1][n + 1];

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1] - dp[i - 1][j - 1] + board[i][j];
            }
        }

        StringBuilder sb = new StringBuilder();
        int x1, y1, x2, y2;
        for (int i = 1; i <= k; i++) {
            st = new StringTokenizer(br.readLine());
            x1 = Integer.parseInt(st.nextToken());
            y1 = Integer.parseInt(st.nextToken());
            x2 = Integer.parseInt(st.nextToken());
            y2 = Integer.parseInt(st.nextToken());

            sb.append((dp[x2][y2] - dp[x2][y1 - 1] - dp[x1 - 1][y2] + dp[x1 - 1][y1 - 1]) + "\n");
        }
        System.out.println(sb);
    }
}