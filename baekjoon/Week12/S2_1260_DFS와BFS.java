package baekjoon.Week12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class S2_1260_DFS와BFS {

    static int[][] graph;
    static int[] visited;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");
        int n = Integer.parseInt(inputs[0]);
        int m = Integer.parseInt(inputs[1]);
        int v = Integer.parseInt(inputs[2]);

        for (int i = 0; i < m; i++) {
            inputs = br.readLine().split(" ");
            int a = Integer.parseInt(inputs[0]);
            int b = Integer.parseInt(inputs[1]);

            graph[a][b] = graph[b][a] = 1;
        }
        sb = new StringBuilder();
        sb.append(v + " ");
        dfs(v, n);
        System.out.println(sb);
        visited = new int[n + 1];
        sb = new StringBuilder();
    }

    static void dfs(int k, int n) {
        visited[k] = 1;
        for (int i = 1; i <= n; i++) {
            if (graph[k][i] == 1 && visited[i] == 0) {
                sb.append(i + " ");
                dfs(i,n);
            }
        }
    }

    static void bfs(int k,int n) {
        visited[k] = 1;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(k);
        while (!queue.isEmpty()) {
            int now = queue.poll();
            for (int i = 1; i <= n; i++) {
                if (graph[now][i] == 1 && visited[i] == 0) {
                    sb.append(i + " ");
                    queue.add(i);
                    visited[i] = 1;
                }
            }
        }
    }
}
