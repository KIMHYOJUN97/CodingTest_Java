package baekjoon.Week26;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class S1_21317_징검다리건너기 {
    static int ans = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = stoi(br.readLine());
        int[] small = new int[n - 1];
        int[] big = new int[n - 1];

        for (int i = 0; i < n - 1; i++) {
            String[] s = br.readLine().split(" ");
            small[i] = stoi(s[0]);
            big[i] = stoi(s[1]);
        }

        int k = stoi(br.readLine());

        dfs(0, n, 0, k, small, big, false);
        System.out.println(ans);
    }

    static void dfs(int idx, int n, int energy, int k, int[] small, int[] big, boolean flag) {
        if (idx == n-1) {
            ans = Math.min(ans, energy);
            return;
        }
        if (idx >= n) return;


        dfs(idx + 1, n, energy + small[idx], k, small, big, false);

        dfs(idx + 2, n, energy + big[idx], k, small, big, false);

        if (!flag) {
            dfs(idx + 3, n, energy + k, k, small, big, true);
        }
    }

    static int stoi(String s) {
        return Integer.parseInt(s);
    }
}
