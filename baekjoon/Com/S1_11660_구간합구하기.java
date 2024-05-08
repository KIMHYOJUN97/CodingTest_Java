package baekjoon.Com;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class S1_11660_구간합구하기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int n = stoi(s[0]);
        int m = stoi(s[1]);
        int[][] arr = new int[n + 1][n + 1];
        int[][] preSum = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            s = br.readLine().split(" ");
            for (int j = 1; j <= n; j++) {
                arr[i][j] = stoi(s[j]);
                preSum[i][j] = preSum[i][j - 1] + preSum[i - 1][j] - preSum[i - 1][j - 1] + arr[i][j];
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) {
            s = br.readLine().split(" ");
            int x1 = stoi(s[0]);
            int y1 = stoi(s[1]);
            int x2 = stoi(s[2]);
            int y2 = stoi(s[3]);

        }
    }

    static int stoi(String s) {
        return Integer.parseInt(s);
    }
}
