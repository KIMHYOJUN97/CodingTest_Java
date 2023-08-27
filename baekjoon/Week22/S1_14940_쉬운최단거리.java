package baekjoon.Week22;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class S1_14940_쉬운최단거리 {

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = stoi(st.nextToken());
        int m = stoi(st.nextToken());
        int[][] board = new int[n][m];

        Position start = null;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                board[i][j] = stoi(st.nextToken());
                if(board[i][j] == 2) start = new Position(j, i);
            }
        }
        boolean[][] visit = new boolean[n][m];


        Queue<Position> q = new LinkedList<>();
        q.add(start);
        board[start.y][start.x] = 0;
        while (!q.isEmpty()) {
            Position now = q.poll();
            visit[now.y][now.x] = true;
            for (int i = 0; i < 4; i++) {
                int ny = now.y + dy[i];
                int nx = now.x + dx[i];
                if (ny >= 0 && nx >= 0 && ny < n && nx < m && board[ny][nx] != 0 && visit[ny][nx] == false) {
                    visit[ny][nx] = true;
                    board[ny][nx] = board[now.y][now.x]+1;
                    q.add(new Position(nx, ny));
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(board[i][j]==1 && visit[i][j]==false)board[i][j] = -1;
                sb.append(board[i][j]+" ");
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }

    static class Position{
        int x;
        int y;

        public Position(int x,int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int stoi(String s) {
        return Integer.parseInt(s);
    }
}
