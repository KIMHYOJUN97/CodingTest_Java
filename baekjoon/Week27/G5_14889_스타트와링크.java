package baekjoon.Week27;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class G5_14889_스타트와링크 {
    static int[][] stats;
    static boolean[] visit;
    static int n, answer = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = stoi(br.readLine());
        stats = new int[n][n];
        visit = new boolean[n];
        for (int i = 0; i < n; i++) {
            String[] s = br.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                stats[i][j] = stoi(s[j]);
            }
        }

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = i + 1;
        }
        combi(0, 0);
        System.out.println(answer);
    }

    static void combi(int idx, int count) {
        if (count == n / 2) {
            logic();
            return;
        }

        for (int i = idx; i < n; i++) {
            if (!visit[i]) {
                visit[i] = true;
                combi(i + 1, count + 1);
                visit[i] = false;
            }
        }
    }

    static void logic() {
        int start = 0;
        int link = 0;

        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (visit[i] && visit[j]) {
                    start += stats[i][j] + stats[j][i];
                } else if (!visit[i] && !visit[j]) {
                    link += stats[i][j] + stats[j][i];
                }
            }
        }

        answer = Math.min(Math.abs(start - link), answer);
    }

    static int stoi(String s) {
        return Integer.parseInt(s);
    }
}
