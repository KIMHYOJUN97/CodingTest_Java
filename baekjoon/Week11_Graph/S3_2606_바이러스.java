package baekjoon.Week11_Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class S3_2606_바이러스 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int k = Integer.parseInt(br.readLine());
        int[][] board = new int[n + 1][n + 1];
        int[] visited = new int[n + 1];
        for (int i = 0; i < k; i++) {
            String[] inputs = br.readLine().split(" ");
            int a = Integer.parseInt(inputs[0]);
            int b = Integer.parseInt(inputs[1]);
            board[a][b] = 1;
            board[b][a] = 1;
        }

        int cnt = 0;
        Queue<Integer> queue = new LinkedList<>();
        visited[1] = 1;
        queue.offer(1);
        while (!queue.isEmpty()) {
            int now = queue.poll();
            for (int i = 1; i < n + 1; i++) {
                if (board[now][i] == 1 && visited[i] == 0) {
                    queue.offer(i);
                    visited[i] = 1;
                    cnt++;
                }
            }
        }

        System.out.println(cnt);
    }
}

