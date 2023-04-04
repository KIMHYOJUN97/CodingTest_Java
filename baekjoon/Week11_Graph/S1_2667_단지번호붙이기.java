package baekjoon.Week11_Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;

public class S1_2667_단지번호붙이기 {
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int N;
    static int[][] graph;
    static ArrayList<Integer> al;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        graph = new int[N][N];
        al = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < N; j++) {
                graph[i][j] = s.charAt(j)-'0';
            }
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(graph[i][j]==1) bfs(i, j);
            }
        }
        al.sort(Comparator.naturalOrder());
        System.out.println(al.size());
        for (int x : al) {
            System.out.println(x);
        }
    }

    private static void bfs(int n,int m) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(m, n));
        int cnt = 1;
        while (!queue.isEmpty()) {
            Node now = queue.poll();
            int x = now.x;
            int y = now.y;
            graph[y][x] = 0;
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (nx >= 0 && ny >= 0 && nx < N && ny < N && graph[ny][nx]==1) {
                    graph[ny][nx] = 0;
                    cnt++;
                    queue.add(new Node(nx, ny));
                }
            }
        }
        al.add(cnt);
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
