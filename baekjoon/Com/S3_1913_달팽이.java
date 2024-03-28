package baekjoon.Com;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class S3_1913_달팽이 {
    static int[][] graph;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {-1, 0, 1, 0};
    static int target, n;
    static int[] answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        target = Integer.parseInt(br.readLine());
        graph = new int[n][n];

        snail();
    }

    static void snail() {
        int[] start = {n / 2, n / 2};
        int x = start[0];
        int y = start[1];

        int num = 1;
        int idx = 0;
        while (num <= n * n) {
            graph[y][x] = num;
            if (num == target) answer = new int[]{x, y};
            int ny = y + dy[idx];
            int nx = x + dx[idx];
            // 정상일 때
            if (nx >= 0 && ny >= 0 && nx < n && ny < n) {
                if (graph[ny][nx] == 0) {
                    x = nx;
                    y = ny;
                    idx++;
                } else {
                    idx--;
                    if (idx < 0) idx = 3;
                    x = x + dx[idx];
                    y = y + dy[idx];
                    idx++;
                }
                idx %= 4;
                num++;
            }
        }
        echo();
        StringBuilder sb = new StringBuilder();
        sb.append(answer[0]).append(" ").append(answer[1]);
    }

    static void echo() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                sb.append(graph[i][j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }
}
