package baekjoon.Com;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 4 3
 * 1 2 3 4
 * 2 3 4 5
 * 3 4 5 6
 * 4 5 6 7
 * 2 2 3 4
 * 3 4 3 4
 * 1 1 4 4
 */
public class S1_11660_구간의합구하기5 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] nm = br.readLine().split(" ");
        int n = stoi(nm[0]);
        int m = stoi(nm[1]);
        int[][] graph = new int[n + 1][n + 1];
        int[][] preSum = new int[n + 1][n + 1];

        for (int i = 1; i <= n; i++) {
            String[] input = br.readLine().split(" ");
            for (int j = 1; j <= n; j++) {
                graph[i][j] = stoi(input[j-1]);
            }
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                preSum[i][j] = preSum[i - 1][j] + preSum[i][j - 1] - preSum[i - 1][j - 1] + graph[i][j];
            }
        }

        for (int i = 0; i < m; i++) {
            String[] input = br.readLine().split(" ");
            int x1 = stoi(input[0]);
            int y1 = stoi(input[1]);
            int x2 = stoi(input[2]);
            int y2 = stoi(input[3]);
            System.out.println(preSum[x2][y2] - preSum[x1 - 1][y2] - preSum[x2][y1 - 1] + preSum[x1 - 1][y1 - 1]);
        }
    }

    static int stoi(String s) {
        return Integer.parseInt(s);
    }
}
