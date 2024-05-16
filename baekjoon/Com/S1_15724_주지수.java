package baekjoon.Com;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class S1_15724_주지수 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int n = stoi(s[0]);
        int m = stoi(s[1]);

        int[][] arr = new int[n + 1][m + 1];
        int[][] preSum = new int[n + 1][m + 1];

        for (int i = 1; i <= n; i++) {
            s = br.readLine().split(" ");
            for (int j = 1; j <= m; j++) {
                arr[i][j] = stoi(s[j - 1]);
                preSum[i][j] = preSum[i - 1][j] + preSum[i][j - 1] - preSum[i - 1][j - 1] + arr[i][j];
            }
        }

        StringBuilder sb = new StringBuilder();
        int k = stoi(br.readLine());
        for (int i = 0; i < k; i++) {
            s = br.readLine().split(" ");
            int y1 = stoi(s[0]);
            int x1 = stoi(s[1]);
            int y2 = stoi(s[2]);
            int x2 = stoi(s[3]);

            sb.append(preSum[y2][x2] - preSum[y1-1][x2] - preSum[y2][x1-1] + preSum[y1-1][x1-1]+"\n");
        }

        System.out.println(sb);

    }

    static int stoi(String s) {
        return Integer.parseInt(s);
    }
}
