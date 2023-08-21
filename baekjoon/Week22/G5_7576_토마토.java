package baekjoon.Week22;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class G5_7576_토마토 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        int m = stoi(st.nextToken()); //가로
        int n = stoi(st.nextToken()); //세로

        int[][] board = new int[n][m];
        boolean[][] visit = new boolean[n][m];
        Queue<Position> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                board[i][j] = stoi(st.nextToken());
                if(board[i][j]==1){ q.add(new Position(j, i));
                    board[i][j] = 0;}
            }
        }

        while (!q.isEmpty()) {
            Position now = q.poll();
            visit[now.y][now.x] = true;
            for (int i = 0; i < 4; i++) {
                int ny = now.y + dy[i];
                int nx = now.x + dx[i];
                if (nx >= 0 && ny >= 0 && nx < m && ny < n && visit[ny][nx] == false && board[ny][nx] != -1) {
                    board[ny][nx] = board[now.y][now.x]+1;
                    visit[ny][nx] = true;
                    q.add(new Position(nx, ny));
                }
            }
        }

        boolean flag = false;
        int answer = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == 0 && visit[i][j] == false) {
                    flag = true;
                    break;
                } else {
                    answer = Math.max(answer, board[i][j]);
                }
            }
            if(flag)break;
        }
        if(flag) System.out.println(-1);
        else System.out.println(answer);
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
