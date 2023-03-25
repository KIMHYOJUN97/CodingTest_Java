package baekjoon.Week11_Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class S2_1260_DFS와BFS {

    static int n,m,v;
    static int[][] graph;
    static int[] visited;
    static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");
        n = Integer.parseInt(inputs[0]);
        m = Integer.parseInt(inputs[1]);
        v = Integer.parseInt(inputs[2]);
        graph = new int[n+1][n+1];
        visited = new int[n + 1];
        for (int i = 0; i < m; i++) {
            inputs = br.readLine().split(" ");
            int a = Integer.parseInt(inputs[0]);
            int b = Integer.parseInt(inputs[1]);

            graph[a][b] = graph[b][a] = 1;
        }
        sb = new StringBuilder();
        sb.append(v+" ");
        dfs(v);
        System.out.println(sb);
        sb = new StringBuilder();
        visited = new int[n+1];
        sb.append(v+" ");
        bfs(v);
        System.out.println(sb);
    }

    private static void dfs(int k) {
        visited[k] = 1;
        for (int i = 1; i <= n; i++) {
            if (graph[k][i] == 1 && visited[i] == 0) {
                sb.append(i+" ");
                dfs(i);
            }
        }
    }

    private static void bfs(int k) {
        visited[k] = 1;
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(k);
        while (!queue.isEmpty()) {
            int now = queue.poll();
            for (int i = 1; i <= n; i++) {
                if (graph[now][i] == 1 && visited[i] == 0) {
                    sb.append(i+" ");
                    queue.offer(i);
                    visited[i] = 1;
                }
            }
        }
    }
}
