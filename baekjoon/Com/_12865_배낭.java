package baekjoon.Com;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _12865_배낭 {
    static int answer = 0, n, k;
    static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        n = stoi(s[0]);
        k = stoi(s[1]);

        map = new int[n][2];
        for (int i = 0; i < n; i++) {
            s = br.readLine().split(" ");
            int w = stoi(s[0]);
            int v = stoi(s[1]);

            map[i][0] = w;
            map[i][1] = v;
        }

        dfs(0, 0, 0);
        System.out.println(answer);

    }

    static void dfs(int depth, int weight, int value) {
        if (depth == n) {
            answer = Math.max(answer, value);
            return;
        }

        if (weight + map[depth][0] <= k) {
            dfs(depth + 1, weight + map[depth][0], value + map[depth][1]);
        }

        if (weight <= k) {
            dfs(depth + 1, weight, value);
        }
    }

    static int stoi(String s) {
        return Integer.parseInt(s);
    }
}
