package baekjoon.Week11_Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 어디 틀렸을까?
 */
public class S1_14940_쉬운최단거리 {
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int N;
    static int M;
    static int[][] graph;
    static int[][] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");
        N = Integer.parseInt(inputs[0]);
        M = Integer.parseInt(inputs[1]);
        graph = new int[N][M];
        visited = new int[N][M];
        int[] target = new int[2];
        for (int i = 0; i < N; i++) {
            inputs = br.readLine().split(" ");
            for (int j = 0; j < M; j++) {
                graph[i][j] = Integer.parseInt(inputs[j]);
                if(graph[i][j]==2){
                    //target[0] = y, target[1] = x;
                    target[0] = i;
                    target[1] = j;
                }
            }
        }

        bfs(target[1], target[0]);
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(graph[i][j]==1)graph[i][j]=-1;
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                System.out.print(graph[i][j]+" ");
            }
            System.out.println();
        }
    }

    private static void bfs(int n, int m) {
        graph[m][n] = 0;
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(n, m));
        visited[m][n] = 1;
        while (!queue.isEmpty()) {
            Node now = queue.poll();
            int x = now.x;
            int y = now.y;
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (nx >= 0 && ny >= 0 && nx < M && ny < N && graph[ny][nx] != 0 && visited[ny][nx]==0) {
                    graph[ny][nx] = graph[y][x]+1;
                    visited[ny][nx]=1;
                    queue.add(new Node(nx, ny));
                }
            }
        }
    }

    private static class Node{
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
