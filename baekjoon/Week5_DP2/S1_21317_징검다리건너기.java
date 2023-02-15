package baekjoon.Week5_DP2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//N의 크기가 적어 dfs로 가능
public class S1_21317_징검다리건너기 {

    static int answer = Integer.MAX_VALUE;
    static int n;
    static int k;
    static int[][] board;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        board = new int[n+1][2];
        for (int t = 1; t < n-1; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            board[t][0] = Integer.parseInt(st.nextToken());
            board[t][1] = Integer.parseInt(st.nextToken());
        }
        k = Integer.parseInt(br.readLine());


    }

    private static void dfs(int sum, int rock, boolean flag) {
        if (rock == n) {
            answer = Math.min(answer, sum);
        }

        if(rock>n)return;

        dfs(sum + board[rock][0], rock + 1, flag);
        dfs(sum + board[rock][1], rock + 2, flag);

        if (!flag) {
            dfs(sum+k,rock+3,true);
        }
    }
}
