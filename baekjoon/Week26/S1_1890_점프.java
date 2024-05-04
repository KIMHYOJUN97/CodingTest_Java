package baekjoon.Week26;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * bfs 로 탐색하며 풀기 -> 1번째 방안
 * dp 로 풀기 -> 2번째 방안
 */
public class S1_1890_점프 {
    static int answer = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = stoi(br.readLine());
        int[][] arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            String[] s = br.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                arr[i][j] = stoi(s[j]);
            }
        }

        dfs(0, 0, arr, n);
        System.out.println(answer);

    }

    static void dfs(int x, int y, int[][] arr, int n) {
        if(x >= n || y >= n) return;
        if (x == n-1 && y == n-1) {
            answer++;
            return;
        }

        int jump = arr[y][x];
        if(x + jump < n) dfs(x + jump, y, arr, n);
        if(y + jump < n) dfs(x, y + jump, arr, n);
    }

    static int stoi(String s) {
        return Integer.parseInt(s);
    }
}
