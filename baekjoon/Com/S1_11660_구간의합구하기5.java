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
        int[][] graph = new int[n][n];
        int[][] preSum = new int[n][n];

        for (int i = 0; i < n; i++) {
            String[] input = br.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                graph[i][j] = stoi(input[j]);
            }
        }

        preSum[0][0] = graph[0][0];

        for (int i = 1; i < n; i++) {
            preSum[i][0] = preSum[i - 1][0] + graph[i][0];
            preSum[0][i] = preSum[0][i - 1] + graph[0][i];
        }

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < n; j++) {
                preSum[i][j] = preSum[i - 1][j] + preSum[i][j - 1] - preSum[i - 1][j - 1] + graph[i][j];
            }
        }

        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                sb.append(preSum[i][j] + " ");
            }
            sb.append("\n");
        }
        System.out.println(sb);

        for (int i = 0; i < m; i++) {
            String[] input = br.readLine().split(" ");
            int x1 = stoi(input[0]) - 1;
            int y1 = stoi(input[1]) - 1;
            int x2 = stoi(input[2]) - 1;
            int y2 = stoi(input[3]) - 1;
            System.out.println(preSum[y2][x2] - preSum[y2][x1] - preSum[y1][x2] + preSum[y1][x1]);
        }
    }

    static int stoi(String s) {
        return Integer.parseInt(s);
    }
}
