package baekjoon.Week24;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class S2_2630_색종이만들기 {
    static int white = 0, blue = 0;
    static boolean[][] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = stoi(br.readLine());
        int[][] graph = new int[n][n];
        visit = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            String[] s = br.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                graph[i][j] = stoi(s[j]);
            }
        }

        dfs(graph, n, 0, 0);

        System.out.println(white);
        System.out.println(blue);
    }

    static void dfs(int[][] graph, int n, int x, int y) {
        // cutting 도 가능.
        if (sameColor(graph, x, y, n)) {
            return;
        }

        dfs(graph, n / 2, x, y);
        dfs(graph, n / 2, x + n / 2, y);
        dfs(graph, n / 2, x, y + n / 2);
        dfs(graph, n / 2, x + n / 2, y + n / 2);

    }

    static boolean sameColor(int[][] graph, int x, int y, int idx) {
        int number = graph[y][x];
        if (visit[y][x]) return false;
        for (int i = y; i < y + idx; i++) {
            for (int j = x; j < x + idx; j++) {
                if (graph[i][j] != number) {
                    return false;
                }
            }
        }

        for (int i = y; i < y + idx; i++) {
            for (int j = x; j < x + idx; j++) {
                visit[i][j] = true;
            }
        }

        if (graph[y][x] == 0) white++;
        else blue++;

        return true;
    }

    static int stoi(String s) {
        return Integer.parseInt(s);
    }
}
