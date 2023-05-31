package baekjoon.Week12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class G5_16234_인구이동 {

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int n,l,r;
    static int[][] graph;
    static int[][] visited;

    static List<Node> bfs(int a, int b) {
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(a, b));
        List<Node> nodes = new ArrayList<>();
        nodes.add(new Node(a, b));
        while (!q.isEmpty()) {
            Node now = q.poll();
            int x = now.x;
            int y = now.y;
            for (int i = 0; i < n; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (nx >= 0 && ny >= 0 && nx < n && ny < n && visited[nx][ny] == 0) {
                    if (l <= Math.abs(graph[nx][ny] - graph[x][y]) && Math.abs(graph[nx][ny] - graph[x][y]) <= r) {
                        visited[nx][ny] = 1;
                        q.add(new Node(nx, ny));
                        nodes.add(new Node(nx, ny));
                    }
                }
            }
        }
        return nodes;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");
        n = Integer.parseInt(inputs[0]);
        l = Integer.parseInt(inputs[1]);
        r = Integer.parseInt(inputs[2]);
        graph = new int[n][n];
        for (int i = 0; i < n; i++) {
            inputs = br.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                graph[i][j] = Integer.parseInt(inputs[j]);
            }
        }

        int ans = 0;
        while (true) {
            visited = new int[n][n];
            int flag = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (visited[i][j] == 0) {
                        visited[i][j] = 1;
                        List<Node> country = bfs(i, j);
                        if (country.size() > 1) {
                            flag = 1;
                            int num = 0;
                            for (Node node : country) {
                                num += graph[node.x][node.y];
                            }
                            num /= country.size();
                            for (Node node : country) {
                                graph[node.x][node.y] = num;
                            }
                        }
                    }
                }
            }
            if (flag == 0) {
                break;
            }
            ans++;
        }
        System.out.println(ans);
    }

    static class Node{
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
