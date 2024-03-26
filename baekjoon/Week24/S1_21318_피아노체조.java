package baekjoon.Week24;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class S1_21318_피아노체조 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = stoi(br.readLine());
        String[] s = br.readLine().split(" ");
        int[] musics = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            musics[i] = stoi(s[i - 1]);
        }

        int[] preSum = new int[n + 1];
        for (int i = 1; i < n; i++) {
            int sum = 0;
            if (musics[i] > musics[i + 1]) sum = 1;
            preSum[i] = preSum[i - 1] + sum;
        }
        preSum[n] = preSum[n-1];

        StringBuilder sb = new StringBuilder();
        int m = stoi(br.readLine());
        for (int i = 0; i < m; i++) {
            s = br.readLine().split(" ");
            int x = stoi(s[0]);
            int y = stoi(s[1]);
            sb.append(preSum[y-1] - preSum[x-1]);
            sb.append("\n");
        }

        System.out.println(sb);
    }

    static int stoi(String s) {
        return Integer.parseInt(s);
    }
}
